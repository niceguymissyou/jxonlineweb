/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.lib;

import java.util.Date;

/**
 *
 * @author VuNguyen
 */
public class CardLimit {
    
    public String username = "";
    
    public Date time;
    
    public int count = 0;
    public CardLimit(){
        
    }
    
    public CardLimit(String username, Date time, int count){
        this.username = username;
        this.time = time;
        this.count = count;
    }
}
