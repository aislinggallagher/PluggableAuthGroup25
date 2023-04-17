package com.Group25.PluggableAuth.Adapters.outbound.SendCookie;

import com.Group25.PluggableAuth.Port.CookiePort;

import jakarta.servlet.http.HttpServletResponse;
/*
 * Sends the values that will be needted to set the login cookie on the website.
 */
public class CookieSender implements CookiePort{

    public CookieSender(){}

    public void sendCookie(HttpServletResponse response, String jwt, String cookieName){
        response.addHeader("cookieName", cookieName);
        response.addHeader("jwt", jwt);
    }
    
}
