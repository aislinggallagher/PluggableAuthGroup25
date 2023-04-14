package com.Group25.PluggableAuth.Adapters.outbound;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Group25.PluggableAuth.Adapters.outbound.SendMail.SendMailDemo;
import com.Group25.PluggableAuth.Adapters.outbound.SendCookie.CookieSender;

@Configuration
public class OutboundAdapterConfig {

@Bean
    public SendMailDemo mailPort() {
        return new SendMailDemo();
    }

@Bean
    public CookieSender cookiePort() {
        return new CookieSender();
    }
}
