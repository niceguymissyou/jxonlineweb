/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.Form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author VuNguyen
 */
public class PassChangeForm {

    @Pattern(regexp = "[a-zA-Z0-9]+")
    @Size(min = 8, max = 24)
    @NotEmpty
    private String cPassWord;

    @Pattern(regexp = "[a-zA-Z0-9]+")
    @Size(min = 8, max = 24)
    @NotEmpty
    private String cNewPassWord;

    /**
     * @return the cPassWord
     */
    public String getcPassWord() {
        return cPassWord;
    }

    /**
     * @param cPassWord the cPassWord to set
     */
    public void setcPassWord(String cPassWord) {
        this.cPassWord = cPassWord;
    }

    /**
     * @return the cNewPassWord
     */
    public String getcNewPassWord() {
        return cNewPassWord;
    }

    /**
     * @param cNewPassWord the cNewPassWord to set
     */
    public void setcNewPassWord(String cNewPassWord) {
        this.cNewPassWord = cNewPassWord;
    }

}
