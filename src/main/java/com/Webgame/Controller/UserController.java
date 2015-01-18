/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.Controller;

import com.Webgame.Form.LoginForm;
import com.Webgame.Form.PassChangeForm;
import com.Webgame.Form.RegisterForm;
import com.Webgame.Form.UpdateInfoForm;
import com.Webgame.Model.*;
import com.Webgame.Service.UserService;
import com.Webgame.lib.JsonResponse;
import com.Webgame.lib.ReCaptchaGoogle;
import com.Webgame.lib.ReCaptchaImpl;
import com.google.gson.Gson;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
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

    @Autowired
    UserService userService;

    @RequestMapping("/dang-nhap")
    public ModelAndView loginView(@ModelAttribute("username") String username) {
        model.setViewName("User/login");
        model.addObject("username", username);
        return model;
    }

    @RequestMapping(value = "/dang-nhap", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> login(@Valid LoginForm loginForm,
            BindingResult result, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
        Gson gson = new Gson();
        
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.result = "Sai tên đăng nhập hoặc mật khẩu";
        jsonResponse.success = false;
        
        String remoteAddr = request.getRemoteAddr();
        
        if (!result.hasErrors() && reCaptcha.checkAnswer(remoteAddr,request.getParameter("g-recaptcha-response"))) {
            if (userService.login(loginForm)) {
                jsonResponse.result = "";
                jsonResponse.success = true;
                session.setAttribute("user", loginForm.getcAccName());
            }
        }        
        response.setCharacterEncoding("UTF-8");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
        return new ResponseEntity<String>(gson.toJson(jsonResponse), responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping("/dang-ky")
    public ModelAndView registerView() {
        model.setViewName("User/register");
        return model;
    }
    @Autowired
    private MessageSource messages;

    @RequestMapping(value = "/dang-ky", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> register(@Valid RegisterForm registerForm,
            BindingResult result, HttpServletRequest request, HttpServletResponse response) {
        Gson gson = new Gson();
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.success = true;
        String remoteAddr = request.getRemoteAddr();
        
        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                String[] resolveMessageCodes = result.resolveMessageCodes(fieldError.getCode());
                String string = resolveMessageCodes[0];
                String message = messages.getMessage(string + "." + fieldError.getField(), new Object[]{fieldError.getRejectedValue()}, null);
                jsonResponse.result += "<div>" + message + "</div>";
                jsonResponse.success = false;
            }
        }
        if (userService.IsExistsEmail(registerForm.getcEmail())) {
            jsonResponse.result += "<div>" + "Email đã tồn tại" + "</div>";
            jsonResponse.success = false;
        }
        if (userService.IsExistsUserName(registerForm.getcAccName())) {
           jsonResponse.result += "<div>" + "Tên đăng nhập đã tồn tại" + "</div>";
           jsonResponse.success = false;
        }
        if (!reCaptcha.checkAnswer(remoteAddr,request.getParameter("g-recaptcha-response") )) {
             jsonResponse.result += "<div>" + "Lỗi bảo mật" + "</div>";
             jsonResponse.success = false;
        }
        if (jsonResponse.success == true) {
            userService.register(registerForm);
            jsonResponse.result = "";
        } 
        response.setCharacterEncoding("UTF-8");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
        return new ResponseEntity<String>(gson.toJson(jsonResponse), responseHeaders, HttpStatus.CREATED);
    }    
    
    @RequestMapping(value = "/thong-tin", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<String> info(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        Gson gson = new Gson();
        User u = userService.getUser(session.getAttribute("user").toString());
        if (u != null) {
            u.setcSecPassWord("");
            u.setcPassWord("");
        }
        response.setCharacterEncoding("UTF-8");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
        return new ResponseEntity<String>(gson.toJson(u), responseHeaders, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/thong-tin", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> updateInfo(@Valid UpdateInfoForm updateInfoForm, 
            BindingResult result,
            HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        Gson gson = new Gson();
        JsonResponse jsonResponse = new JsonResponse();
        jsonResponse.success = false;
        jsonResponse.result = "<div>Thông tin không hợp lệ</div>";
        if (!result.hasErrors()) {
            if(userService.updateInfo(updateInfoForm,session.getAttribute("user").toString())){
                jsonResponse.success = true;
                jsonResponse.result = "<div>Cập nhật thông tin thành công</div>";
            }
        }
        response.setCharacterEncoding("UTF-8");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
        return new ResponseEntity<String>(gson.toJson(jsonResponse), responseHeaders, HttpStatus.CREATED);
    }
    
   @RequestMapping(value = "/doi-mat-khau",method = RequestMethod.GET)
    public ModelAndView passChange(HttpSession session) {
        model.setViewName("User/passchange");
        model.addObject("user", session.getAttribute("user"));
        return model;
    }
    @RequestMapping(value = "/doi-mat-khau-1", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> password1Change(@Valid PassChangeForm passChangeForm, 
            BindingResult result,
            HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        Gson gson = new Gson();
        JsonResponse jsonResponse = new JsonResponse();
        if (result.hasErrors()) {
            jsonResponse.success = false;
            jsonResponse.result = "<div>Mật khẩu phải là kí tự số hoặc chữ (8 - 24)</div>";
        }
        if (userService.PassChange(passChangeForm, session.getAttribute("user").toString())) {
            jsonResponse.success = true;
            jsonResponse.result = "<div>Đổi mật khẩu thành công</div>";
        }
        
        response.setCharacterEncoding("UTF-8");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");
        return new ResponseEntity<String>(gson.toJson(jsonResponse), responseHeaders, HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) {
        model.setViewName("User/index");
        model.addObject("user", session.getAttribute("user"));
        return model;
    }

}
