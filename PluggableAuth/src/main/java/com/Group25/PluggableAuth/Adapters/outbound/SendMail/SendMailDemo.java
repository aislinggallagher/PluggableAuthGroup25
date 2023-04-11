package com.Group25.PluggableAuth.Adapters.outbound.SendMail;

import org.apache.catalina.webresources.FileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.util.ResourceUtils;

import com.Group25.PluggableAuth.Port.EmailPort;

import javax.mail.MessagingException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;
import java.nio.file.*;


public class SendMailDemo implements EmailPort { 
//New version of sendmail demo that uses spring API and reads user/pass from application.properties file

    JavaMailSenderImpl mailSender;
    Properties props;
    String s;
    private SimpleMailMessage mail;


    public SendMailDemo() 
    {
        mailSender = new JavaMailSenderImpl();

        try{ 
            ClassLoader classLoader = getClass().getClassLoader();
            
        File inputFile = new File(classLoader.getResource("application.properties").getFile());
        
    
        
        Scanner scanner = new Scanner(inputFile);
        
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine(); //Essentially checks  application.properties line by line for properties

            if(currentLine.startsWith("spring.mail.host=")) {
                 s = currentLine.replace("spring.mail.host=","");
                mailSender.setHost(s);
                System.out.println(mailSender.getHost());
            }
            else if(currentLine.startsWith("spring.mail.port=")){
                 s = currentLine.replace("spring.mail.port=","");

                mailSender.setPort(Integer.parseInt(s));
            }
            else if(currentLine.startsWith("spring.mail.username=")){
                 s = currentLine.replace("spring.mail.username=","");
                 mailSender.setUsername(s);
                
                }

            else if(currentLine.startsWith("spring.mail.password=")){
                s = currentLine.replace("spring.mail.password=","");
                mailSender.setPassword(s);
            }

            else if(currentLine.startsWith("spring.mail.properties.mail.smtp.auth=true")){
                props = mailSender.getJavaMailProperties();                                         //if smtp auth is true we know the transfer protocol is smtp and we can also set its auth to true
                props.put("mail.transport.protocol", "smtp");
                props.put("mail.smtp.auth", "true");
            }
            else if(currentLine.startsWith("spring.mail.properties.mail.smtp.starttls.enable=true")){
                props.put("mail.smtp.starttls.enable", "true");                        
                props.put("mail.debug", "true");
            }
        
        }
        scanner.close();
    }

        catch(FileNotFoundException e){ //Handles file not found error
            e.printStackTrace();
        }
    

    }
    

    public int sendMail(String to, String message) //Login service uses, to address, message format so i changed sendemail to do the same
    {   
        
      try{
        mail = new SimpleMailMessage();
        mail.setFrom(mailSender.getUsername());  //Some SMTPs need you to set from address to send
        mail.setTo(to);         //Sets to address
        mail.setText(message);  //Sets text of mail as inputted string
        mailSender.send(mail);  //Actually sends mail

        return 1;
    }

        catch (MailException ex) {                 //Thrown when error occurs
            ex.printStackTrace();
            return 0;                      //Print error   

           }

    }
}

