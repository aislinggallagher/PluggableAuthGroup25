package com.Group25.PluggableAuth.Adapters.inbound;

import com.Group25.PluggableAuth.Adapters.inbound.EmailLogin.EmailLoginController;
import com.Group25.PluggableAuth.Adapters.inbound.SecureLayer.HomeEndPoint;
import com.Group25.PluggableAuth.Adapters.inbound.SecureLayer.JwtValidation;
import com.Group25.PluggableAuth.Domain.LoginService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//the domain exists without knowledge of the adapters, and so the adapters have to make use of themselves along with
// the necessary services provided in the domain
//this will dictate how the program uses the inbound tasks, and there will be one for the outbound tasks that deals
//with sending the email to the client....but might not be necessary, we'll see about that i suppose



@Configuration
public class InboundAdaptorConfig {
    @Autowired
    private LoginService loginService;
    
    @Bean
    public EmailLoginController loginEndpoint() {
        return new EmailLoginController(loginService);
    }
    @Bean
    public HomeEndPoint HomePage() {
        return new HomeEndPoint();
    }
    @Bean
    public FilterRegistrationBean<JwtValidation> filterRegistrationBean() {
        FilterRegistrationBean<JwtValidation> registrationBean = new FilterRegistrationBean();

        registrationBean.setFilter(new JwtValidation());
        registrationBean.addUrlPatterns("/welcome");
        registrationBean.setOrder(2);
        return registrationBean;
    }
}

//potential config file, don't upload yet tho...waiting on the login Service first

