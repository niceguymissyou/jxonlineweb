/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.Form;

import java.util.Date;
import javax.validation.constraints.Pattern;

/**
 *
 * @author VuNguyen
 */
public class UpdateInfoForm {

    private String cRealName;

    private int CSex;

    private Date dBirthDay;

    @Pattern(regexp = "[0-9]+")
    private String cPhone;

    /**
     * @return the cRealName
     */
    public String getcRealName() {
        return cRealName;
    }

    /**
     * @param cRealName the cRealName to set
     */
    public void setcRealName(String cRealName) {
        this.cRealName = cRealName;
    }

    /**
     * @return the CSex
     */
    public int getCSex() {
        return CSex;
    }

    /**
     * @param CSex the CSex to set
     */
    public void setCSex(int CSex) {
        this.CSex = CSex;
    }

    /**
     * @return the dBirthDay
     */
    public Date getdBirthDay() {
        return dBirthDay;
    }

    /**
     * @param dBirthDay the dBirthDay to set
     */
    public void setdBirthDay(Date dBirthDay) {
        this.dBirthDay = dBirthDay;
    }

    /**
     * @return the cPhone
     */
    public String getcPhone() {
        return cPhone;
    }

    /**
     * @param cPhone the cPhone to set
     */
    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }
}
