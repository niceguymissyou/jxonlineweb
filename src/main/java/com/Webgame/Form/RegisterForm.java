/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.Form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author VuNguyen
 */
public class RegisterForm {

    @Size(min = 6, max = 18)
    @Pattern(regexp = "[a-zA-Z0-9]+")
    @NotEmpty
    private String cAccName;

    @Pattern(regexp = "[a-zA-Z0-9]+")
    @Size(min = 8, max = 24)
    @NotEmpty
    private String cPassWord;
   
  //  @Email
   // @NotEmpty
   // private String cEmail;
    
    

    /**
     * @return the cAccName
     */
    public String getcAccName() {
        return cAccName;
    }

    /**
     * @param cAccName the cAccName to set
     */
    public void setcAccName(String cAccName) {
        this.cAccName = cAccName;
    }

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
}
