/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author VuNguyen
 */
@Controller
@RequestMapping(value = "/download")
public class DownloadController {
        @RequestMapping(value = "/autoupdate",method = RequestMethod.GET)
    public void serveResource(@ModelAttribute("filename")  String filename ,HttpServletRequest request, HttpServletResponse response) throws IOException{
         try {

             //String path = request.getSession().getServletContext().getRealPath("");

             File f = new File("/home/vunguyen/thapdaiphai.com/patch" + "//" + filename);

 

             response.setContentType("application/zip");

             response.setContentLength(new Long(f.length()).intValue());

             response.setHeader("Content-Disposition","attachment; filename=download.zip");

             FileCopyUtils.copy(new FileInputStream(f),

                     response.getOutputStream());

 

         } catch (Exception e) {

 

             e.printStackTrace();

         }
    }
}
