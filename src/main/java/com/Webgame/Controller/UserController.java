/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author VuNguyen
 */
@Controller
@RequestMapping(value = "/tai-khoan")
public class UserController {

    ModelAndView model = new ModelAndView();

    @RequestMapping("/dang-nhap")
    public ModelAndView login() {
        model.setViewName("User/login");
        return model;
    }

    @RequestMapping("/dang-ky")
    public ModelAndView register() {
        model.setViewName("User/register");
        return model;
    }
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){
        model.setViewName("User/index");
        return model;
    }
}
