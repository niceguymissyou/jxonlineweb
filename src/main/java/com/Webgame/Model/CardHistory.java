/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.Model;

import java.util.Date;

/**
 *
 * @author VuNguyen
 */
public class CardHistory {
    
    private String username;
    
    private int resultcode;
    
    private String transactionkey;
    
    private Date time;
    
    public CardHistory(){
        
    }
    public CardHistory(String username, int resultcode, String transactionkey, Date time ){
        this.username = username;
        this.resultcode = resultcode;
        this.transactionkey = transactionkey;
        this.time = time;
    }
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the resultcode
     */
    public int getResultcode() {
        return resultcode;
    }

    /**
     * @param resultcode the resultcode to set
     */
    public void setResultcode(int resultcode) {
        this.resultcode = resultcode;
    }

    /**
     * @return the transactionkey
     */
    public String getTransactionkey() {
        return transactionkey;
    }

    /**
     * @param transactionkey the transactionkey to set
     */
    public void setTransactionkey(String transactionkey) {
        this.transactionkey = transactionkey;
    }

    /**
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Date time) {
        this.time = time;
    }
}
