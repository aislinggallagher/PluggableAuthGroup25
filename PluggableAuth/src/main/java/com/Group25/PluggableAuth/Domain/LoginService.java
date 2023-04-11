package com.Group25.PluggableAuth.Domain;

import com.Group25.PluggableAuth.Port.EmailPort;

import com.nimbusds.jose.JOSEException;

import java.io.IOException;


public class LoginService {

    private EmailPort mailPort;
    private JwtService jwtService;
    private String message;
    
    public  LoginService(EmailPort mailPort, JwtService jwtService){
        this.mailPort = mailPort;
        this.jwtService = jwtService;
        this.message = new String();
    }

    public void sendMail(String to) throws IOException{
        // setup message and add the jwt to the link and concatenate to message.
        String website = "http://localhost:8080/";
        try{
            String jwt = jwtService.generateJWT(to, website);
            String returnToken = website+"home?token="+jwt;
            message = message + returnToken;
            System.out.println("Message: " + message);
            System.out.println(returnToken);
            mailPort.sendMail(to, message);
        } catch (JOSEException e) {
            e.printStackTrace();
        }
    }



}
    
