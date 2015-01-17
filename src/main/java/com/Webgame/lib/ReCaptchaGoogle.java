/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.lib;

/**
 *
 * @author VuNguyen
 */
public interface ReCaptchaGoogle {
    public boolean checkAnswer(String remoteAddr, String response);
    public boolean isValid();
}
