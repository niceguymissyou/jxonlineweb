/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Webgame.Controller;

import java.util.Collections;
import javax.websocket.OnMessage;
import org.springframework.stereotype.Controller;

/**
 *
 * @author VuNguyen
 */
@Controller
public class WebsocketController {
    
     @OnMessage
    public String onMessage(String message) {
        return null;
    }
}
