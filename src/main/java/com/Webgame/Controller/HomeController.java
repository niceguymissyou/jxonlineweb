/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Webgame.Controller;


import com.Webgame.Model.*;
import com.Webgame.Service.PostsService;
import com.google.gson.Gson;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import static com.Webgame.Controller.AdminController.*;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PathVariable;
/**
 *
 * @author VuNguyen
 */
@Controller
public class HomeController {
    
    @Autowired
    PostsService postsService;
    
    @RequestMapping("/index")
    public ModelAndView index(){
       ModelAndView model = new ModelAndView();
        model.setViewName("index");   
        return model;
    }
    @RequestMapping("/remember")
    public ModelAndView abc(HttpSession session){
        ModelAndView model = new ModelAndView();
        model.setViewName("remember");
        model.addObject("user", session.getAttribute("user"));
        return model;
    }
    @RequestMapping(value = "/getpostlist", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<String> getPostList(@ModelAttribute("index") String str, @ModelAttribute("post_type") String str1, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();

        int index = Integer.parseInt(str);

        List<Posts> postlist = postsService.getList(index, index + 9, str1);
        for (Posts p : postlist) {
            p.setPost_text("");
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
        return new ResponseEntity<String>(gson.toJson(postlist), responseHeaders, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/danh-sach-tin", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<String> getPostListType(@ModelAttribute("post_type") String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        List<Posts> lstPost = new ArrayList<Posts>();
        switch(type){
            case "1":
                for (Posts p : getPosts()) {
                    Posts tmp = new Posts(p.getPost_link(),p.getPost_subject(),p.getPost_text(),p.getPost_type(),p.getPreview()); 
                    tmp.setPost_text("");
                    lstPost.add(tmp);
                }
                break;
            case "2":
                for (Posts p : getPostsSuKien()) {
                    Posts tmp = new Posts(p.getPost_link(), p.getPost_subject(), p.getPost_text(), p.getPost_type(), p.getPreview());
                    tmp.setPost_text("");
                    lstPost.add(tmp);
                }
                break;
            case "3":
                for (Posts p : getPostsTinhNang()) {
                    Posts tmp = new Posts(p.getPost_link(), p.getPost_subject(), p.getPost_text(), p.getPost_type(), p.getPreview());
                    tmp.setPost_text("");
                    lstPost.add(tmp);
                }
                break;
            case "4":
                for (Posts p : getPostsCamNang()) {
                    Posts tmp = new Posts(p.getPost_link(), p.getPost_subject(), p.getPost_text(), p.getPost_type(), p.getPreview());
                    tmp.setPost_text("");
                    lstPost.add(tmp);
                }
                break;
                
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
        return new ResponseEntity<String>(gson.toJson(lstPost), responseHeaders, HttpStatus.CREATED);
    }
    @RequestMapping("/{post_link}-post")
    public ModelAndView postView(@PathVariable("post_link") String post_link){
        ModelAndView model = new ModelAndView();
        model.setViewName("Home/post");
        model.addObject("url", post_link + "-post-1.html");
        
        return model;
    }
    @RequestMapping(value = "/{post_link}-post-1", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<String> Post(@PathVariable("post_link") String post_link, HttpServletRequest request, HttpServletResponse response) { 
        response.setCharacterEncoding("UTF-8");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
        Gson gson = new Gson();
        
        Posts post = null;
        for (int i = 0; i < getPosts().size(); i++) {
            if (getPosts().get(i).getPost_link().equals(post_link)) {
                post = getPosts().get(i);
                return new ResponseEntity<String>(gson.toJson(post), responseHeaders, HttpStatus.CREATED);
            }
        }
        for (int i = 0; i < getPostsSuKien().size(); i++) {
            if (getPostsSuKien().get(i).getPost_link().equals(post_link)) {
                post = getPostsSuKien().get(i);
                return new ResponseEntity<String>(gson.toJson(post), responseHeaders, HttpStatus.CREATED);     
            }
        }

        for (int i = 0; i < getPostsCamNang().size(); i++) {
            if (getPostsCamNang().get(i).getPost_link().equals(post_link)) {
                post = getPostsCamNang().get(i);
                return new ResponseEntity<String>(gson.toJson(post), responseHeaders, HttpStatus.CREATED);
            }
        }
        for (int i = 0; i < getPostsTinhNang().size(); i++) {
            if (getPostsTinhNang().get(i).getPost_link().equals(post_link)) {
                post = getPostsTinhNang().get(i);
                return new ResponseEntity<String>(gson.toJson(post), responseHeaders, HttpStatus.CREATED);
            }
        }

        post = postsService.getData(post_link);
        if (post == null) {
            post = new Posts();
            post.setPost_subject("error");
            post.setPost_text("Link không tồn tại");
        }
        return new ResponseEntity<String>(gson.toJson(post), responseHeaders, HttpStatus.CREATED);
    }
    
    @RequestMapping("/{type}-lst")
    public ModelAndView postList(@PathVariable("type") String type){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView = new ModelAndView();
        modelAndView.setViewName("Home/postlst");
         switch(type){
            case "tin-tuc":
                modelAndView.addObject("type", "Tin tức");
                modelAndView.addObject("post_type", '1');
                break;
            case "su-kien":
                modelAndView.addObject("type", "Sự kiện");
                modelAndView.addObject("post_type", '2');
                break;
            case "tinh-nang":
                modelAndView.addObject("type", "Tính năng");
                modelAndView.addObject("post_type", '3');
                break;
            case "cam-nang":
                modelAndView.addObject("type", "Cẩm nang");
                modelAndView.addObject("post_type", '4');
                break;    
            default:  
                modelAndView.addObject("type", "Tin tức");
                modelAndView.addObject("post_type", '1');
                break;
        }
        return modelAndView;
    }

}
