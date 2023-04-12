package com.Group25.PluggableAuth.Adapters.inbound.SecureLayer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeEndPoint {
    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }
}
