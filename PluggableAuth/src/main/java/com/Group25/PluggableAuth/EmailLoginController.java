package com.Group25.PluggableAuth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EmailLoginController {

    @GetMapping ("/login")
    public String loginPage(Model model) {
        model.addAttribute("login", new EmailLogin());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubbmit( @ModelAttribute EmailLogin login, Model model){
        model.addAttribute("login", login);
        return "result";
    }
}

