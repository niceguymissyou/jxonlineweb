/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.Controller;

import com.Webgame.lib.ReCaptchaGoogle;
import com.Webgame.lib.ReCaptchaImpl;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
   @Autowired
    ReCaptchaGoogle reCaptcha;
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
    @RequestMapping("/captcha")
    public ModelAndView captcha() {
        model.setViewName("User/captcha");
        return model;
    }
    @RequestMapping(value = "/validate", method = RequestMethod.GET)
    public ModelAndView validate(@ModelAttribute("g-recaptcha-response") String gRecaptchaResponse , HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        reCaptcha.checkAnswer(remoteAddr,gRecaptchaResponse);
        if (reCaptcha.isValid()) {
            model.addObject("result", "ok" );
        } else {
          model.addObject("result", "ko" );
        }
        model.setViewName("User/validate");
        return model;
    }
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(){
        model.setViewName("User/index");
        return model;
    }
    
}
