package com.Group25.PluggableAuth.Adapters.inbound.EmailLogin;

import java.io.IOException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Group25.PluggableAuth.Domain.LoginService;

import org.springframework.ui.Model;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/login")
public class EmailRequestController {
    
    private LoginService loginService;


    public EmailRequestController(LoginService loginService) {
        this.loginService = loginService;
    }
    
    @PostMapping()
    public String loginSubbmit(@RequestBody EmailLogin email, Model model) throws IOException{
        model.addAttribute("login", email);
        System.out.printf("%s",email.getEmail());
        loginService.sendMail(email.getEmail());
        System.out.printf("Mail!");
        return "result";
    }
}
