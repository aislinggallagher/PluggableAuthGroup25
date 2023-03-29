package com.Group25.PluggableAuth.Domain;

import com.Group25.PluggableAuth.Port.EmailPort;
import com.Group25.PluggableAuth.Adapters.outbound.SendMail.SendMailDemo;
import com.Group25.PluggableAuth.Domain.JwtService;

import com.nimbusds.jose.JOSEException;

import java.io.IOException;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class LoginService {

    private EmailPort mailPort;
    private JwtService jwtService;
    private String message;
    
    public  LoginService(EmailPort mailPort, JwtService jwtService, String message){
        this.mailPort = mailPort;
        this.jwtService = jwtService;
        this.message = message;
    }

    public void sendMail(String email) throws JOSEException {
        // setup message and add the jwt to the link and concatenate to message.

        String website = "http://localhost:8080/";
        try{
            String secretKey = jwtService.generateJWT(email, website);
            String jwt = jwtService.generateJWT(email, website);
            String returnToken = website+"?token="+jwt;
            message.concat("\n\n" + returnToken);
            mailPort.sendMail(email, message);
        } catch (JOSEException e) {
            e.printStackTrace();
        }
    }



}
    
