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
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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
    
    public Posts(String Post_link, String Post_subject, String Post_text, String Post_type,String preview){
        this.Post_link = Post_link;
        this.Post_text = Post_text;
        this.Post_type = Post_type;
        this.preview = preview;
        this.Post_subject = Post_subject;
    }
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
}
