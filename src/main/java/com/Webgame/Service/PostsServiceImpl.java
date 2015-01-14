/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.Service;

import com.Webgame.Model.Posts;
import com.Webgame.Model.Slide;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author VuNguyen
 */
public class PostsServiceImpl implements PostsService {

    @Autowired
    DataSource dataSourceMysql;

    public static class SlideRowMapper implements RowMapper {

        public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Slide slide = new Slide();
            slide.setSlide_link(resultSet.getString("slide_link"));
            slide.setSlide_img(resultSet.getString("slide_img"));
            return slide;
        }

    }

    public class PostsRowMapper implements RowMapper<Posts> {

        @Override
        public Posts mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Posts post = new Posts();
            post.setPost_link(resultSet.getString("post_link"));
            post.setPost_text(resultSet.getString("post_text"));
            post.setPost_subject(resultSet.getString("post_subject"));
            post.setPost_type(resultSet.getString("post_type"));
            post.setPost_time(resultSet.getTimestamp("post_time"));

            return post;
        }

    }

    @Override
    public boolean insert(Posts post) {
        try {
            String sql = "insert into posts(post_link,post_subject,post_text,post_time,post_type)   values(?,?,?,?,?)";
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
            jdbcTemplate.update(sql, new Object[]{post.getPost_link(),
                post.getPost_subject(),
                post.getPost_text(),
                new java.util.Date(),
                post.getPost_type()});
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public void editData(Posts post) {
        String sql = "update posts set post_subject = ?, post_text = ?, post_time = ?,post_type = ? where post_link = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        jdbcTemplate.update(sql, new Object[]{
            post.getPost_subject(),
            post.getPost_text(),
            new java.util.Date(),
            post.getPost_type(),
            post.getPost_link()});
    }

    @Override
    public void delete(Posts post) {
        String sql = "delete from posts where post_link = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        jdbcTemplate.update(sql, new Object[]{post.getPost_link()});
    }

    @Override
    public Posts getData(String post_link) {
        String sql = "select * from posts where post_link = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List<Posts> postList = jdbcTemplate.query(sql, new Object[]{post_link}, new PostsRowMapper());
        if (postList.size() != 1) {
            return null;
        }
        return postList.get(0);
    }

    @Override
    public List<Posts> getList(int from, int to, String type) {
        String sql = "select * from posts where post_type = ?  order by post_time desc limit ?,?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List postList = jdbcTemplate.query(sql, new Object[]{type, from, to}, new PostsRowMapper());
        return postList;
    }

    @Override
    public List<Posts> getList(int from, int to) {
        String sql = "select * from posts order by post_time desc limit ?,?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List postList = jdbcTemplate.query(sql, new Object[]{from, to}, new PostsRowMapper());
        return postList;
    }

    @Override
    public List<Slide> getListSlide() {
        String sql = "select * from slide  limit 0,6";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceMysql);
        List lstSlide = jdbcTemplate.query(sql, new SlideRowMapper());
        return lstSlide;
    }

}
