package com.Group25.PluggableAuth.Adapters.inbound.SecureLayer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeEndPoint {
    @GetMapping(value = {"/home","/home/{token}"})
    public String home(@CookieValue(name = "Login_JWT", required = false) String LoginJWT, @PathVariable(required = false) String token, HttpServletResponse response ,Model model) {
        System.out.println("Token: " + token);
        if(LoginJWT == null){
            if(token == null){
                return "pleaseLogIn";
            }
            else{
                 Cookie cookie = new Cookie("Login_JWT", token);
                cookie.setDomain("localhost");
                cookie.setHttpOnly(true);
                response.addCookie(cookie);
            }
            
        }
        return "home";
    }
}
