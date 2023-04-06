package com.Group25.PluggableAuth.Adapters.outbound;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Group25.PluggableAuth.Adapters.outbound.SendMail.SendMailDemo;
import com.Group25.PluggableAuth.Port.EmailPort;

@Configuration
public class OutboundAdapterConfig {

@Bean
    public EmailPort mailPort() {
        EmailPort mailPort = new SendMailDemo();
        return mailPort;
    }
}
