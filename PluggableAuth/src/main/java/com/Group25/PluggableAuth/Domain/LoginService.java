package com.Group25.PluggableAuth.Domain;

import com.Group25.PluggableAuth.Port.EmailPort;
import com.Group25.PluggableAuth.Port.CookiePort;

import com.nimbusds.jose.JOSEException;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * The brains of the operation used to handle the various login rewuest from users and the admins on the adminsite.
 */
public class LoginService {

    private EmailPort mailPort;
    private CookiePort cookiePort;
    private JwtService jwtService;
    private String message;
    
    public  LoginService(EmailPort mailPort, CookiePort cookiePort, JwtService jwtService){
        this.mailPort = mailPort;
        this.cookiePort = cookiePort;
        this.jwtService = jwtService;
        this.message = new String();
    }

    /*
     * This method is used to generate a JWT iusing the email parameter and then call the MailPort to send out the email containing the callback url to the user and the
     * CookiPort to send out the login cookie.
     */
    public String sendMail(String to, HttpServletResponse response) throws IOException{
        // setup message and add the jwt to the link and concatenate to message.
        String website = "http://localhost:8080/";
        try{
            String jwt = jwtService.generateJWT(to, website);
            String returnToken = website+"home/"+jwt;
            message = message + returnToken;
            mailPort.sendMail(to, message);
            cookiePort.sendCookie(response, jwt, "Login_JWT");
            return jwt;
        } catch (JOSEException e) {
            e.printStackTrace();
            return "";
        }
    }

    /*
     * This method is used to generate a JWT for the administrator using the email parameter it checks if the admin is a registered admin and using the email and pasword combination.
     * it then calls the CookiPort to send out the login cookie.
     */
    public String adminLogin(String adminMail, String adminPassword, HttpServletResponse response) throws IOException{
        // setup message and add the jwt to the link and concatenate to message.
        String website = "http://localhost:3001/";
        String mail;
        String password;
        boolean verified = false;
        try{ 
            ClassLoader classLoader = getClass().getClassLoader();
            
            File inputFile = new File(classLoader.getResource("application.properties").getFile());
    
        
            Scanner scanner = new Scanner(inputFile);
        
            while (scanner.hasNextLine()) {
                String currentLine = scanner.nextLine(); //Essentially checks  application.properties line by line for properties
                if(currentLine.startsWith("Admin.email=")) {
                    mail = currentLine.replace("Admin.email=","");
                    if(mail.equalsIgnoreCase(adminMail)){
                        if(scanner.hasNextLine()){
                            currentLine = scanner.nextLine();
                            if(currentLine.startsWith("Admin.password=")){
                                password = currentLine.replace("Admin.password=","");
                                if(password.equalsIgnoreCase(adminPassword)){
                                    verified = true;
                                }
                            }
                        }
                    }
                }
            }
            scanner.close();
        }
        catch(FileNotFoundException e){ //Handles file not found error
            e.printStackTrace();
        }
        if(verified){
            try{
                String jwt = jwtService.generateJWT(adminMail, website);
                cookiePort.sendCookie(response, jwt, "Admin_Login_JWT");
                return jwt;
            } catch (JOSEException e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }



}
    
