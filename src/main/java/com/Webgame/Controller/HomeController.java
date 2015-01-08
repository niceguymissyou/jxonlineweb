/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Webgame.Controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author VuNguyen
 */
@Controller
@SessionAttributes("user")
public class HomeController {
    
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
    
    
    
}
