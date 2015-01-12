/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author VuNguyen
 */
public class Posts {
    @Pattern(regexp="[a-zA-Z0-9-]+")
    @Size(min=10,max=100)
    @NotEmpty 
    private String Post_link;
    
    @Size(min=100)
    @NotEmpty 
    private String Post_text;
    
    @Size(min=10,max=100)
    @NotEmpty 
    private String Post_subject;
    
    private Date Post_time;
    
    @Pattern(regexp="[1-4]+")
    @Size(min=1,max=1)
    @NotEmpty 
    private String Post_type;

    private String preview = "";
    
    public Posts(){}
    
  
    /**
     * @return the Post_text
     */
    public String getPost_text() {
        return Post_text;
    }

    /**
     * @param Post_text the Post_text to set
     */
    public void setPost_text(String Post_text) {
        this.Post_text = Post_text;
    }

    /**
     * @return the Post_subject
     */
    public String getPost_subject() {
        return Post_subject;
    }

    /**
     * @param Post_subject the Post_subject to set
     */
    public void setPost_subject(String Post_subject) {
        this.Post_subject = Post_subject;
    }

    /**
     * @return the Post_time
     */
    public Date getPost_time() {
        return Post_time;
    }

    /**
     * @param Post_time the Post_time to set
     */
    public void setPost_time(Date Post_time) {
        this.Post_time = Post_time;
    }

    /**
     * @return the Post_type
     */
    public String getPost_type() {
        return Post_type;
    }

    /**
     * @param Post_type the Post_type to set
     */
    public void setPost_type(String Post_type) {
        this.Post_type =  Post_type;
    }

    /**
     * @return the Post_link
     */
    public String getPost_link() {
        return Post_link;
    }

    /**
     * @param Post_link the Post_link to set
     */
    public void setPost_link(String Post_link) {
        this.Post_link = Post_link;
    }

    /**
     * @return the preview
     */
    public String getPreview() {
        return preview;
    }

    /**
     * @param preview the preview to set
     */
    public void setPreview(String preview) {
        this.preview = preview;
    }
    
    @Autowired
    static DataSource dataSourceMysql;
    public static class PostsRowMapper implements RowMapper {

        public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Posts post = new Posts();
            post.setPost_link(resultSet.getString("post_link"));
            post.setPost_text(resultSet.getString("post_text"));
            post.setPost_subject(resultSet.getString("post_subject"));
            post.setPost_type(resultSet.getString("post_type"));
            post.setPost_time(resultSet.getTimestamp("post_time"));
            
            return post;
        }

    }
     public static class SlideRowMapper implements RowMapper {

        public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Slide slide = new Slide();
            slide.setSlide_link(resultSet.getString("slide_link"));
            slide.setSlide_img(resultSet.getString("slide_img"));
            return slide;
        }

    }
    public  boolean insert(){
        try{
            String sql = "insert into posts(post_link,post_subject,post_text,post_time,post_type)   values(?,?,?,?,?)";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
            jdbcTemplate.update(sql, new Object[]{this.getPost_link(),
                this.getPost_subject(),
                this.getPost_text(),
                new java.util.Date(),
                this.getPost_type()});
            return true;
        } catch (Exception ex){
            return false;
        }
    }
    public void editData() {
        String sql = "update posts set post_subject = ?, post_text = ?, post_time = ?,post_type = ? where post_link = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        jdbcTemplate.update(sql, new Object[]{
            this.getPost_subject(),
            this.getPost_text(),
            new java.util.Date(),
            this.getPost_type(),
            this.getPost_link()});
    }
    public void delete() {
        String sql = "delete from posts where post_link = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        jdbcTemplate.update(sql, new Object[]{this.Post_link});
    }
    public static Posts getData(String post_link) {
        String sql = "select * from posts where post_link = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List<Posts> postList = jdbcTemplate.query(sql, new Object[]{post_link}, new PostsRowMapper());
        if (postList.size() != 1) {
            return null;
        }
        return postList.get(0);
    }
    public static List<Posts> getList(int from, int to, String type) {
        String sql = "select * from posts where post_type = ?  order by post_time desc limit ?,?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List postList = jdbcTemplate.query(sql, new Object[]{type, from, to}, new PostsRowMapper());
        return postList;
    }
    public static List<Posts> getList(int from, int to) {
        String sql = "select * from posts order by post_time desc limit ?,?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List postList = jdbcTemplate.query(sql, new Object[]{from, to}, new PostsRowMapper());
        return postList;
    }
    public static List<Slide> getListSlide() {
        String sql = "select * from slide  limit 0,6";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List lstSlide = jdbcTemplate.query(sql, new SlideRowMapper());
        return lstSlide;
    }
}
