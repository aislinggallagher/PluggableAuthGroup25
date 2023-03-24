package com.Group25.PluggableAuth.Adapters.inbound.EmailLogin;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Group25.PluggableAuth.Domain.LoginService;

@Controller
public class EmailLoginController{

    private LoginService loginService;

    public EmailLoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping ("/login")
    public String loginPage(Model model) {
        model.addAttribute("login", new EmailLogin());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubbmit( @ModelAttribute EmailLogin login, Model model) throws IOException{
        model.addAttribute("login", login);
        loginService.sendMail(login.getEmail());
        System.out.printf("Mail!");
        return "result";
    }
}

