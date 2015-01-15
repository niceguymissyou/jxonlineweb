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
/**
 *
 * @author VuNguyen
 */
@Controller
@SessionAttributes("user")
public class HomeController {
    
    @Autowired
    PostsService postsService;
    
    public ModelAndView model = new ModelAndView();
    
    @RequestMapping("/index")
    public ModelAndView index(){
        model.setViewName("index");
        model.addObject("user", "adafs");
        
        return model;
    }
    @RequestMapping("/remember")
    public ModelAndView abc(HttpSession session){
        model.setViewName("remember");
        model.addObject("user", session.getAttribute("user"));
        
        System.out.println(session.getAttribute("user"));
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
        List<Posts> lstPost = new ArrayList();
        switch(type){
            case "1":
                lstPost = getPosts();
                for (Posts p : lstPost) {
                    p.setPost_text("");
                }
                break;
            case "2":
                lstPost = getPostsSuKien();
                for (Posts p : lstPost) {
                    p.setPost_text("");
                }
                break;
            case "3":
                lstPost = getPostsTinhNang();
                for (Posts p : lstPost) {
                    p.setPost_text("");
                }
                break;
            case "4":
                lstPost = getPostsCamNang();
                for (Posts p : lstPost) {
                    p.setPost_text("");
                }
                break;
                
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
        return new ResponseEntity<String>(gson.toJson(lstPost), responseHeaders, HttpStatus.CREATED);
    }

}
