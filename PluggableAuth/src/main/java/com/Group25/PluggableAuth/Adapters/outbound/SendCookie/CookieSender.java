package com.Group25.PluggableAuth.Adapters.outbound.SendCookie;

import com.Group25.PluggableAuth.Port.CookiePort;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
/*
 * Sends the cookie as a respons for a request that arrived on an inbound adapter.
 */
public class CookieSender implements CookiePort{

    public CookieSender(){}

    public void sendCookie(HttpServletResponse response, String jwt, String cookieName){
        Cookie cookie = new Cookie(cookieName, jwt);
        cookie.setDomain("localhost");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }
    
}
