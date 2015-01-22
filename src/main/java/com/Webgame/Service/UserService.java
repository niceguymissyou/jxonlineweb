/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.Service;

import com.Webgame.Form.LoginForm;
import com.Webgame.Form.PassChangeForm;
import com.Webgame.Form.RegisterForm;
import com.Webgame.Form.UpdateInfoForm;
import com.Webgame.Model.CardHistory;
import com.Webgame.Model.User;

/**
 *
 * @author VuNguyen
 */
public interface UserService {

    public boolean login(LoginForm loginForm);

    public boolean kickAcc(User user);

    public int CountUserOnline();

    public boolean PassChange(PassChangeForm passChangeForm, String cAccName);

    public User getUser(String cAccName);

    public boolean updateInfo(UpdateInfoForm udateInfoForm, String cAccName);
    
    public boolean register(RegisterForm registerForm);
    
    public boolean IsExistsEmail(String email);
    
    public boolean IsExistsUserName(String userName);
    
    public boolean insertCardHistory(CardHistory cardHistory);
    
    public boolean NapCard(CardHistory cardHistory);
    
    public int SoDu(String username);
    
}
