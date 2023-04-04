package com.Group25.PluggableAuth.Adapters.outbound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.Group25.PluggableAuth.Adapters.outbound.SendMail.SendMailDemo;
import com.Group25.PluggableAuth.Port.EmailPort;

@Configuration
public class OutboundAdapterConfig {

@Bean
    public EmailPort emailClient() {
        return new SendMailDemo();
    }
    
}
