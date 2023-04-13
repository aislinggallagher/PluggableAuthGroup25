package com.Group25.PluggableAuth.Adapters.inbound.SecureLayer;

import org.apache.tomcat.util.digester.SystemPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeEndPoint {
    @GetMapping("/home")
    public String home(@CookieValue(name = "Login_JWT", required = false) String LoginJWT,Model model) {
        if(LoginJWT == null){
            return "pleaseLogIn";
        }
        return "home";
    }
}
