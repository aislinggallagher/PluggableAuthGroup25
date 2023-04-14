package com.Group25.PluggableAuth.Domain;

import com.Group25.PluggableAuth.Port.EmailPort;

import com.nimbusds.jose.JOSEException;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginService {

    private EmailPort mailPort;
    private JwtService jwtService;
    private String message;
    
    public  LoginService(EmailPort mailPort, JwtService jwtService){
        this.mailPort = mailPort;
        this.jwtService = jwtService;
        this.message = new String();
    }

    public String sendMail(String to) throws IOException{
        // setup message and add the jwt to the link and concatenate to message.
        String website = "http://localhost:8080/";
        try{
            String jwt = jwtService.generateJWT(to, website);
            String returnToken = website+"home/"+jwt;
            message = message + returnToken;
            mailPort.sendMail(to, message);
            return jwt;
        } catch (JOSEException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String adminLogin(String adminMail, String adminPassword) throws IOException{
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
                return jwt;
            } catch (JOSEException e) {
                e.printStackTrace();
                return "";
            }
        }
        return "";
    }



}
    
