package com.Group25.PluggableAuth.Domain;

import com.Group25.PluggableAuth.Port.EmailPort;

import java.io.IOException;
import java.util.Date;

public class LoginService {

    private EmailPort mailPort;
    private JwtService jwtService;
    private String message;

    
    public  LoginService(){
        this.mailPort = new EmailPort();
        this.jwtService = new JwtService();
        this.message = new String();
        message.concat("\nYour login link: ");
    }
    
    public  LoginService(EmailPort mailPort, JwtService jwtService, String message){
        this.mailPort = mailPort;
        this.jwtService = jwtService;
        this.message = message;
    }

    public void sendMail(String to) throws IOException{
        // setup message and add the jwt to the link and concatenate to message.
        try{
            mailPort.sendMail(to, message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
    
