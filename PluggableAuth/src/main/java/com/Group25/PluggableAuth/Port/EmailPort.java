package com.Group25.PluggableAuth.Port;

import com.Group25.PluggableAuth.Adapters.outbound.SendMail.SendMailDemo;
import java.io.IOException;

public class EmailPort {
    private SendMailDemo mail;

    public EmailPort(){
        mail = new SendMailDemo();
    }


    public String sendMail(String to, String message) throws IOException{
        System.out.printf("Sending Mail!");
        int result = mail.sendMail(to, message);
        if (result == 1)
            return "success";
        else
            return "failed";
    }
    
}
