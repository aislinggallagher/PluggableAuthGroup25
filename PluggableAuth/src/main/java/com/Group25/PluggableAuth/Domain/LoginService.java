package com.Group25.PluggableAuth.Domain;

import com.Group25.PluggableAuth.Port.EmailPort;
import com.Group25.PluggableAuth.Adapters.outbound.SendMail.SendMailDemo;
import com.Group25.PluggableAuth.Domain.JwtService;

import com.nimbusds.jose.JOSEException;

import java.io.IOException;

import org.springframework.mail.SimpleMailMessage;


public class LoginService {

    private EmailPort mailPort;
    private JwtService jwtService;
    private String message;
    
    public  LoginService(EmailPort mailPort2, JwtService jwtService, String message){
        this.mailPort = mailPort2;
        this.jwtService = jwtService;
        this.message = message;
    }

    public  LoginService(EmailPort mailPort2, JwtService jwtService){
        this.mailPort = mailPort2;
        this.jwtService = jwtService;
        this.message = "";
    }

    public void sendMail(String to) throws IOException{
        // setup message and add the jwt to the link and concatenate to message.
        String website = "http://localhost:8080/";
        try{
            String jwt = jwtService.generateJWT(to, website);
            String returnToken = website+"?token="+jwt;
            message.concat("\n\n" + returnToken);
            mailPort.sendMail(to, message);
        } catch (JOSEException e) {
            e.printStackTrace();
        }
    }



}
    
