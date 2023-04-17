package com.Group25.PluggableAuth.Adapters.inbound.EmailLogin;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Group25.PluggableAuth.Domain.LoginService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

/*
 * This Controller handles the HTTP requests sent to its localhoastport/login.
 * The Http rewuest should contain the email adress of the user once that has been recived it is passed on to the domain while we return the cookie in the response.
 */
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", exposedHeaders = {"jwt", "cookieName"} )
@RestController
@RequestMapping("/login")
public class EmailRequestController {
    
    private LoginService loginService;


    public EmailRequestController(LoginService loginService) {
        this.loginService = loginService;
    }
    
    @PostMapping()
    public void loginSubbmit(@RequestBody EmailLogin email, Model model, @RequestHeader(name="Origin", required=false)String host, HttpServletResponse response) throws IOException{
        model.addAttribute("login", email);
        String jwt = loginService.sendMail(email.getEmail(), response);
    }
}
