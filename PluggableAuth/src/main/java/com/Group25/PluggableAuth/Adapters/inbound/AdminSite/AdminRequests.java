package com.Group25.PluggableAuth.Adapters.inbound.AdminSite;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

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

@CrossOrigin(origins = "http://localhost:3001", allowCredentials = "true")
@RestController
@RequestMapping("/admin")
public class AdminRequests {
    
    LoginService loginService;
    public AdminRequests(LoginService loginService) {
        this.loginService = loginService;
    }
    
    @PostMapping()
    public String loginSubbmit(@RequestBody Adminlogin admin, Model model, @RequestHeader(name="Origin", required=false)String host, HttpServletResponse response) throws IOException{
        model.addAttribute("admin", admin);
        String jwt = loginService.adminLogin(admin.getEmail(), admin.getPassword());
        if(jwt != ""){
            Cookie cookie = new Cookie("Admin_Login_JWT", jwt);
            cookie.setDomain("localhost");
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            return "/AdminPortal"; 
        }
        return ""; 
    }
}
