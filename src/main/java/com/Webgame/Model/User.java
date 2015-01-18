/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.sql.DataSource;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author VuNguyen
 */
public class User {
    @Size(min=6,max=18)
    @Pattern(regexp="[a-zA-Z0-9]+")
    @NotEmpty 
    private String cAccName;
    
    @Pattern(regexp="[a-zA-Z0-9]+")
    @Size(min=8,max=24)
    @NotEmpty 
    private String cSecPassWord;
    
    @Pattern(regexp="[a-zA-Z0-9]+")
    @Size(min=8,max=24)
    @NotEmpty 
    private String cPassWord;
    
    @Email
    @NotEmpty
    private String cEmail;
    
    private String cRealName;
    
    private int CSex ;
    
    
    private Date dBirthDay ;
    
    @Pattern(regexp="[0-9]+")
    private String cPhone ;
    
    private Date createdatetime;
    
    private int emailactive;
    
    private String captcha;
    
    
    /**
     * @return the cAccName
     */
    
    public String getcAccName() {
        return cAccName;
    }

    /**
     * @param cAccName the cAccName to set
     */
    public void setcAccName(String cAccName) {
        this.cAccName = cAccName;
    }

    /**
     * @return the cSecPassWord
     */
    public String getcSecPassWord() {
        return cSecPassWord;
    }

    /**
     * @param cSecPassWord the cSecPassWord to set
     */
    public void setcSecPassWord(String cSecPassWord) {
        this.cSecPassWord = cSecPassWord;
    }

    /**
     * @return the cEmail
     */
    public String getcEmail() {
        return cEmail;
    }

    /**
     * @param cEmail the cEmail to set
     */
    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    /**
     * @return the captcha
     */
    public String getCaptcha() {
        return captcha;
    }

    /**
     * @param captcha the captcha to set
     */
    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    /**
     * @return the cPassWord
     */
    public String getcPassWord() {
        return cPassWord;
    }

    /**
     * @param cPassWord the cPassWord to set
     */
    public void setcPassWord(String cPassWord) {
        this.cPassWord = cPassWord;
    }

    /**
     * @return the cRealName
     */
    public String getcRealName() {
        return cRealName;
    }

    /**
     * @param cRealName the cRealName to set
     */
    public void setcRealName(String cRealName) {
        this.cRealName = cRealName;
    }

    /**
     * @return the CSex
     */
    public int getCSex() {
        return CSex;
    }

    /**
     * @param CSex the CSex to set
     */
    public void setCSex(int CSex) {
        this.CSex = CSex;
    }

    /**
     * @return the dBirthDay
     */
    public Date getdBirthDay() {
        return dBirthDay;
    }

    /**
     * @param dBirthDay the dBirthDay to set
     */
    public void setdBirthDay(Date dBirthDay) {
        this.dBirthDay = dBirthDay;
    }

    /**
     * @return the cPhone
     */
    public String getcPhone() {
        return cPhone;
    }

    /**
     * @param cPhone the cPhone to set
     */
    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    /**
     * @return the createdatetime
     */
    public Date getCreatedatetime() {
        return createdatetime;
    }

    /**
     * @param createdatetime the createdatetime to set
     */
    public void setCreatedatetime(Date createdatetime) {
        this.createdatetime = createdatetime;
    }

    /**
     * @return the emailactive
     */
    public int getEmailactive() {
        return emailactive;
    }

    /**
     * @param emailactive the emailactive to set
     */
    public void setEmailactive(int emailactive) {
        this.emailactive = emailactive;
    }
}
