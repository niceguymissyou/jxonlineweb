/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.Service;

import com.Webgame.Model.Posts;
import com.Webgame.Model.Slide;
import java.util.List;

/**
 *
 * @author VuNguyen
 */
public interface PostsService {
    
    public boolean insert(Posts post);

    public void editData(Posts post);

    public void delete(Posts post);

    public Posts getData(String post_link);

    public List<Posts> getList(int from, int to, String type);

    public List<Posts> getList(int from, int to);

    public List<Slide> getListSlide();

}
