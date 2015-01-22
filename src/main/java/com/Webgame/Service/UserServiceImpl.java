/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.Service;

import com.Webgame.Form.LoginForm;
import com.Webgame.Form.PassChangeForm;
import com.Webgame.Form.RegisterForm;
import com.Webgame.Form.UpdateInfoForm;
import com.Webgame.Model.CardHistory;
import com.Webgame.Model.User;
import static com.Webgame.lib.MD5.md5;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author VuNguyen
 */
public class UserServiceImpl implements UserService {

    @Autowired
    DataSource dataSource;

    @Autowired
    DataSource dataSourceMysql;

  
    public class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            User user = new User();

            user.setcAccName(resultSet.getString("username"));
            user.setcPassWord(resultSet.getString("password1"));
            user.setcSecPassWord(resultSet.getString("password2"));
            user.setcEmail(resultSet.getString("email"));
            user.setcRealName(resultSet.getString("fullname"));
            user.setCSex(resultSet.getInt("sex"));
            user.setdBirthDay(resultSet.getDate("birthday"));
            user.setcPhone(resultSet.getString("phone"));
            user.setCreatedatetime(resultSet.getDate("createdatetime"));
            user.setEmailactive(resultSet.getInt("emailactive"));

            return user;
        }

    }
    public class CardHistoryRowMapper implements RowMapper<CardHistory> {

        @Override
        public CardHistory mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            CardHistory cardHistory = new CardHistory();

            cardHistory.setUsername(resultSet.getString("username"));
            cardHistory.setResultcode(resultSet.getInt("resultcode"));
            cardHistory.setTransactionkey(resultSet.getString("transactionkey"));
            cardHistory.setTime(resultSet.getTimestamp("time"));
            
            return cardHistory;
        }

    }
     @Override
    public boolean IsExistsEmail(String email) {
        String sql = "select * from user where email = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List<User> userList = jdbcTemplate.query(sql, new Object[]{email}, new UserRowMapper());
        return !userList.isEmpty();
    }

    @Override
    public boolean IsExistsUserName(String userName) {
        String sql = "select * from user where username = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List<User> userList = (List<User>) jdbcTemplate.query(sql, new Object[]{userName}, new UserRowMapper());
        return !userList.isEmpty();
    }

    @Override
    public boolean insertCardHistory(CardHistory cardHistory) {
        try {
            String sql = "insert into carhistory(username,resultcode,transactionkey,time) "
                    + "values(?,?,?,?)";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
            jdbcTemplate.update(
                    sql,
                    new Object[]{cardHistory.getUsername(),
                        cardHistory.getResultcode(),
                        cardHistory.getTransactionkey(),
                        new Date()});
        } catch (Exception ex) {
            return false;
        }
       
        return true;
    }
    
      @Override
    public boolean NapCard(CardHistory cardHistory) {
        try {
            if (cardHistory.getResultcode() >= 10000 && cardHistory.getResultcode() % 10000 == 0) {
                String sql = "update Account_Info set nExtPoint1 = nExtPoint1 + ? where cAccName = ?";
                JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
                jdbcTemplate.update(
                        sql,
                        new Object[]{cardHistory.getResultcode()/10000,cardHistory.getUsername()});
                return true;
            }
        }catch(Exception ex){
            
        }        
        return false;
    }
        @Override
    public int SoDu(String username) {
        String sql = "select nExtPoint1 from Account_Info where  cAccName = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        
        return jdbcTemplate.queryForInt(sql,
                new Object[]{username});
    }

    @Override
    public boolean login(LoginForm loginForm) {
        User temp = this.getUser(loginForm.getcAccName());
        if (temp != null) {
            return temp.getcPassWord().equals(md5(loginForm.getcPassWord()));
        }
        return false;
    }

    @Override
    public boolean kickAcc(User user) {
        String sql = "update Account_Info set iClientID = 0 where  cAccName = ?";
        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(
                    sql,
                    new Object[]{user.getcAccName()});
            return true;

        } catch (Exception ex) {

        }
        return false;

    }

    @Override
    public int CountUserOnline() {
        String sql = "select count(*) from Account_Info where iClientID = 1";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.queryForInt(sql);
    }

    @Override
    public boolean PassChange(PassChangeForm passChangeForm , String cAccName) {
        try {
            String sql = "update Account_Info set cPassWord = ?, cSecPassWord = ? where cAccName = ? and cPassWord = ?";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            //Mssql
            jdbcTemplate.update(
                    sql,
                    new Object[]{md5(passChangeForm.getcNewPassWord()),md5(passChangeForm.getcNewPassWord()), cAccName,
                        md5(passChangeForm.getcPassWord())});

            String sql1 = "update user set password1 = ?, password2 = ?  where username = ? and password1 = ?";

            jdbcTemplate = new JdbcTemplate(dataSourceMysql);
            jdbcTemplate.update(sql1, new Object[]{md5(passChangeForm.getcNewPassWord()),md5(passChangeForm.getcNewPassWord()), cAccName,
                md5(passChangeForm.getcPassWord())});
            
            return true;
        }catch(Exception ex){
            return false;
        }
       
    }

    @Override
    public User getUser(String cAccName) {
        String sql = "select * from user where username = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List<User> userList = jdbcTemplate.query(sql, new Object[]{cAccName}, new UserRowMapper());
        return userList.isEmpty() ? null : userList.get(0);
    }

    @Override
    public boolean updateInfo(UpdateInfoForm updateInfoForm, String cAccName) {

        String sql1 = "update user set fullname = ? , sex = ?, birthday = ? , phone = ? where username = ? ";
        try {
            //Mysql
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
            jdbcTemplate.update(sql1, new Object[]{updateInfoForm.getcRealName(), updateInfoForm.getCSex(), updateInfoForm.getdBirthDay(), updateInfoForm.getcPhone(), cAccName});
            return true;

        } catch (Exception ex) {
            return false;
        }

    }

    @Override
    public boolean register(RegisterForm registerForm) {
        String sql = "INSERT INTO Account_Info(cAccName,cPassWord,cSecPassWord,iClientID,nExtPoint,nExtPoint1,nExtPoint2,nExtPoint3,nExtPoint4,nExtPoint5,nExtPoint6,nExtPoint7,bParentalControl,bisBanned,bisUseOTP,iOTPSessionLifeTime,iServiceFlag)"
                + "VALUES (?, ?, ?,0,1,0,1,1,1,1,1,1,'false','false','false',1,0)";

        String sql1 = "Insert into Account_Habitus(cAccName,dEndDate)"
                + "values(?,'10/10/2020 10:10:10 AM')";

        String MySql = "Insert into user(username,password1,password2,email,createdatetime) "
                + "values(?,?,?,?,?)";

        try {
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

            //Mssql
            jdbcTemplate.update(
                    sql,
                    new Object[]{registerForm.getcAccName(), md5(registerForm.getcPassWord()),
                        md5(registerForm.getcPassWord())});

            jdbcTemplate.update(
                    sql1,
                    new Object[]{registerForm.getcAccName()});

            //Mysql
            jdbcTemplate.setDataSource(dataSourceMysql);
            jdbcTemplate.update(
                    MySql,
                    new Object[]{registerForm.getcAccName(), md5(registerForm.getcPassWord()), md5(registerForm.getcPassWord()), null, new java.util.Date()});

        } catch (Exception ex) {
            return false;
        }

        return true;
    }

}
