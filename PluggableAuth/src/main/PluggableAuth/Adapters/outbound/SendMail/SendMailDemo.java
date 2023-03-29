package com.Group25.PluggableAuth.Adapters.outbound.SendMail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.Group25.PluggableAuth.Port.EmailPort;

public class SendMailDemo implements EmailPort {
    Session session;
    String from;
    String password;
    

    public SendMailDemo(){
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.office365.com"); //Basically the address that lets us send emails, different providers have different ones
        props.put("mail.smtp.port", "587"); 
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", "587");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.ssl.trust", "smtp.office365.com");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2"); //Without this it tries to run an older TLS version and dies
        from = "pluggableauthg25@outlook.com"; // Address of person its being sent from (i created an outlook email for us because it worked, theoretically you could use any email service that has functional smtp support)
        password = "Bigauthfan25*"; // password for email mail address. 

        
        session = Session.getInstance(props, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
         return new PasswordAuthentication(from, password);
         }
        });
    }   

    public int sendMail(String email, String messageText) {

        //SendMailDemo newMail = new SendMailDemo(); //Creating instance of the demo mail class

        String to = email; //sets the destination email as whatever the user enters

        try {
 
            Message message = new MimeMessage(this.session);
            message.setFrom(new InternetAddress(this.from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Pluggable Auth Test"); 
             
            String msg = "Testing. Group 25 Authentication. ";
            msg.concat(messageText);
             
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(msg, "text/html"); //This part of the email is HTML however images and other attachments can be added
              
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart); //This adds the msg string to the email

            message.setContent(multipart); //Sets the final messages content now that i have added everything i want
          
            Transport.send(message); //Transport.send actually sends the message using javamail
          
            return 1;
          
           } catch (MessagingException e) {
            e.printStackTrace(); //Javamail exception thrown when authentication fails e.g wrong password etc
            return 0;
           }
          }

    }
    
    

