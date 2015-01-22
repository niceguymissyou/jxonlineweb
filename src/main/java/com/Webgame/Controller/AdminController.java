/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.Controller;

import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.Webgame.Model.*;
import com.Webgame.Service.PostsService;
import com.Webgame.Service.UserService;
import org.springframework.stereotype.Controller;

/**
 *
 * @author VuNguyen
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private static List<Posts> posts = Collections.synchronizedList(new LinkedList<Posts>());
    private static List<Posts> postsSuKien = Collections.synchronizedList(new LinkedList<Posts>());
    private static List<Posts> postsCamNang = Collections.synchronizedList(new LinkedList<Posts>());
    private static List<Posts> postsTinhNang = Collections.synchronizedList(new LinkedList<Posts>());
  //   private static List<Posts> postsMoiNhat = Collections.synchronizedList(new LinkedList<Posts>());
    private static List<Slide> lstSlide = Collections.synchronizedList(new LinkedList<Slide>());
    
    /**
     * @return the posts
     */
    public static List<Posts> getPosts() {
        return posts;
    }

    /**
     * @return the postsSuKien
     */
    public static List<Posts> getPostsSuKien() {
        return postsSuKien;
    }

    /**
     * @return the postsCamNang
     */
    public static List<Posts> getPostsCamNang() {
        return postsCamNang;
    }

    /**
     * @return the postsTinhNang
     */
    public static List<Posts> getPostsTinhNang() {
        return postsTinhNang;
    }

    /**
     * @return the lstSlide
     */
    public static List<Slide> getLstSlide() {
        return lstSlide;
    }
    @Autowired
    PostsService postsService;
    
    @Autowired
    UserService userService;
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Admin/index");
        modelAndView.addObject("page", "content-right.jsp");
        modelAndView.addObject("post", new Posts());
        modelAndView.addObject("lstpost", postsService.getList(0, 5));
        return modelAndView;
    }
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ModelAndView post(@Valid @ModelAttribute("post") Posts post, BindingResult result, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        ModelAndView modelAndView = new ModelAndView();

        if (result.hasErrors()) {

            modelAndView.setViewName("Admin/index");
            modelAndView.addObject("page", "content-right.jsp");
            return modelAndView;

        }

        modelAndView.setViewName("Admin/bangtin/index");
        modelAndView.addObject("page", "content-right.jsp");
        post.setPost_time(new Date());
        modelAndView.addObject("post", post);
        if (post.getPreview() != null && post.getPreview().equals("preview")) {
            post.setPost_subject(post.getPost_subject() + "(Preview)");
            return modelAndView;
        }

        if ( !postsService.insert(post)) {
            //post.setPost_text("Đăng bài không thành công");
            postsService.editData(post);
            for (int i = 0; i < posts.size(); i++) {

                if (posts.get(i).getPost_link().equals(post.getPost_link())) {
                    posts.set(i, post);
                }
            }
            for (int i = 0; i < postsSuKien.size(); i++) {

                if (postsSuKien.get(i).getPost_link().equals(post.getPost_link())) {
                    postsSuKien.set(i, post);
                }
            }
            for (int i = 0; i < postsCamNang.size(); i++) {

                if (postsCamNang.get(i).getPost_link().equals(post.getPost_link())) {
                    postsCamNang.set(i, post);
                }
            }
            for (int i = 0; i < postsTinhNang.size(); i++) {

                if (postsTinhNang.get(i).getPost_link().equals(post.getPost_link())) {
                    postsTinhNang.set(i, post);
                }
            }
        } else {
            switch (post.getPost_type()) {
                case "1":
                    posts.add(post);
                    break;
                case "2":
                    postsSuKien.add(post);
                    break;
                case "3":
                    postsTinhNang.add(post);
                    break;
                case "4":
                    postsCamNang.add(post);
                    break;
                default:
                    break;
            }

        }

        return modelAndView;

    }

    @RequestMapping(value = "/postdelete", method = RequestMethod.GET)
    public @ResponseBody
    String postdelete(@ModelAttribute("Post_link") String Post_link) {
        String str = "";
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getPost_link().equals(Post_link)) {
                posts.remove(i);
                str = "true";
                break;
            }
        }
        Posts post = new Posts();
        post.setPost_link(Post_link);
        postsService.delete(post);
        return str;
    }

    @RequestMapping(value = "/postupdown", method = RequestMethod.GET)
    public @ResponseBody
    String postup(@ModelAttribute("index") String str, @ModelAttribute("updown") String str1, @ModelAttribute("post_type") String str2, HttpServletRequest request, HttpServletResponse response) throws Exception {

        int index = 0;
        int i = 0;
        switch (str2) {
            case "1":

                for (i = 0; i < getPosts().size(); i++) {
                    if (getPosts().get(i).getPost_link().equals(str)) {
                        index = i;
                        break;
                    }
                }

                if (str1.equals("up")) {
                    if (i >= getPosts().size() - 1) {
                        Posts post = new Posts();
                        post = postsService.getData(str);
                        posts.set(getPosts().size() - 1, post);
                        return "true";
                    }
                    if (index <= 0) {
                        return "false";
                    }

                    Posts temp = posts.get(index - 1);
                    posts.set(index - 1, posts.get(index));
                    posts.set(index, temp);
                    return "true";
                } else {
                    if (index >= getPosts().size() - 1) {
                        return "false";
                    }
                    Posts temp = posts.get(index + 1);
                    posts.set(index + 1, posts.get(index));
                    posts.set(index, temp);
                    return "true";
                }
            case "2":

                for (i = 0; i < getPostsSuKien().size(); i++) {
                    if (getPostsSuKien().get(i).getPost_link().equals(str)) {
                        index = i;
                        break;
                    }
                }

                if (str1.equals("up")) {
                    if (i >= getPostsSuKien().size() - 1) {
                        Posts post = new Posts();
                        post = postsService.getData(str);
                        postsSuKien.set(getPostsSuKien().size() - 1, post);
                        return "true";
                    }
                    if (index <= 0) {
                        return "false";
                    }

                    Posts temp = postsSuKien.get(index - 1);
                    postsSuKien.set(index - 1, postsSuKien.get(index));
                    postsSuKien.set(index, temp);
                    return "true";
                } else {
                    if (index >= getPostsSuKien().size() - 1) {
                        return "false";
                    }
                    Posts temp = postsSuKien.get(index + 1);
                    postsSuKien.set(index + 1, postsSuKien.get(index));
                    postsSuKien.set(index, temp);
                    return "true";
                }
            case "3":
                for (i = 0; i < getPostsTinhNang().size(); i++) {
                    if (getPostsTinhNang().get(i).getPost_link().equals(str)) {
                        index = i;
                        break;
                    }
                }

                if (str1.equals("up")) {
                    if (i >= getPostsTinhNang().size() - 1) {
                        Posts post = new Posts();
                        post = postsService.getData(str);
                        postsTinhNang.set(getPostsTinhNang().size() - 1, post);
                        return "true";
                    }
                    if (index <= 0) {
                        return "false";
                    }

                    Posts temp = postsTinhNang.get(index - 1);
                    postsTinhNang.set(index - 1, postsTinhNang.get(index));
                    postsTinhNang.set(index, temp);
                    return "true";
                } else {
                    if (index >= getPostsTinhNang().size() - 1) {
                        return "false";
                    }
                    Posts temp = postsTinhNang.get(index + 1);
                    postsTinhNang.set(index + 1, postsTinhNang.get(index));
                    postsTinhNang.set(index, temp);
                    return "true";
                }
            case "4":
                for (i = 0; i < getPostsCamNang().size(); i++) {
                    if (getPostsCamNang().get(i).getPost_link().equals(str)) {
                        index = i;
                        break;
                    }
                }

                if (str1.equals("up")) {
                    if (i >= getPostsCamNang().size() - 1) {
                        Posts post = new Posts();
                        post = postsService.getData(str);
                        postsCamNang.set(getPosts().size() - 1, post);
                        return "true";
                    }
                    if (index <= 0) {
                        return "false";
                    }

                    Posts temp = postsCamNang.get(index - 1);
                    postsCamNang.set(index - 1, postsCamNang.get(index));
                    postsCamNang.set(index, temp);
                    return "true";
                } else {
                    if (index >= getPostsCamNang().size() - 1) {
                        return "false";
                    }
                    Posts temp = postsCamNang.get(index + 1);
                    postsCamNang.set(index + 1, postsCamNang.get(index));
                    postsCamNang.set(index, temp);
                    return "true";
                }
            default:
                return "false";
        }

    }

    @RequestMapping(value = "/postmanage", method = RequestMethod.GET)
    public ModelAndView PostManage(@ModelAttribute("post_type") String str) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView = new ModelAndView();
        modelAndView.setViewName("Admin/index");
        modelAndView.addObject("page", "content-right-post.jsp");

        //load to memmory
        posts = postsService.getList(0, 15, "1");
        postsSuKien = postsService.getList(0, 15, "2");
        postsTinhNang = postsService.getList(0, 15, "3");
        postsCamNang = postsService.getList(0, 15, "4");
        lstSlide = postsService.getListSlide();
       // List<Posts> sublist = posts.subList(0, 10);
        // modelAndView.addObject("lstPost",sublist);
        modelAndView.addObject("post_type", str);
        return modelAndView;
    }

    @RequestMapping(value = "/postedit", method = RequestMethod.GET)
    public ModelAndView postedit(@ModelAttribute("Post_link") String Post_link, HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Admin/index");
        modelAndView.addObject("page", "content-right.jsp");
        Posts post = new Posts();
        post = postsService.getData(Post_link);
        modelAndView.addObject("post", post);

        return modelAndView;
    }

    @RequestMapping(value = "/count-user-online", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<String> getPostList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
        return new ResponseEntity<String>("user online = " + Integer.toString(userService.CountUserOnline()), responseHeaders, HttpStatus.CREATED);
    }

}
