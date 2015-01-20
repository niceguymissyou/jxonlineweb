/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Webgame.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author VuNguyen
 */
public class UserFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       
        HttpServletRequest req = ( HttpServletRequest)request;
        HttpServletResponse res= (HttpServletResponse) response;
         HttpSession session = req.getSession(false);
         
         if (session.getAttribute("user") != null){
             chain.doFilter(req,res); 
            
             
         } else{
          RequestDispatcher rd =  req.getRequestDispatcher("/tai-khoan/dang-nhap.html");
          rd.forward(req, res);
         }
        
    }

    @Override
    public void destroy() {
        
    }
    
}
