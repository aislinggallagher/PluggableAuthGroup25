package com.Group25.PluggableAuth.Adapters.outbound;

import com.Group25.PluggableAuth.Adapters.outbound.SendMail.SendMailDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;



@Configuration
public class OutboundAdapterConfig {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Bean
    public SendMailDemo SendMailDemo() {
        return new SendMailDemo();
    }
}
