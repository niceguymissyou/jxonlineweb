/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.lib;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author VuNguyen
 */

public class ReCaptchaImpl implements ReCaptchaGoogle {

    /**
     * @return the secret
     */
    public String getSecret() {
        return secret;
    }

    /**
     * @param secret the secret to set
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * @return the siteSecret
     */
    public String getSiteSecret() {
        return siteSecret;
    }

    /**
     * @param siteSecret the siteSecret to set
     */
    public void setSiteSecret(String siteSecret) {
        this.siteSecret = siteSecret;
    }

    @Override
    public boolean isValid() {
        return this.isValid;
    }

    public static class ReCaptchaResponse {
        public String success;
        public String errorCodes;
    }
    private static String signupUrl  = "https://www.google.com/recaptcha/admin";
    private static String siteVerifyUrl 
            = "https://www.google.com/recaptcha/api/siteverify?";
    private  String secret ;
    private String siteSecret;
    private static String  version  = "java_1.0";
    private boolean isValid = false;
    
    @Override
    public boolean checkAnswer(String remoteAddr, String response) {
        String json;
        try {
            json = readUrl(this.siteVerifyUrl
                    + "secret=" + this.secret
                    + "&response=" + response
                    + "&remoteip=" + remoteAddr );
            Gson gson = new Gson();
            ReCaptchaResponse reCaptchaResponse = gson.fromJson(json, ReCaptchaResponse.class);
            if (reCaptchaResponse.success.equals("true")) {
                this.isValid = true;
                return true;
            }
            return false;
        } catch (Exception ex) {
            Logger.getLogger(ReCaptchaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1) {
                buffer.append(chars, 0, read);
            }

            return buffer.toString();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }
}
