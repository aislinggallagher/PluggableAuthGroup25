package com.Group25.PluggableAuth.Port;

import jakarta.servlet.http.HttpServletResponse;

public interface CookiePort {
    void sendCookie(HttpServletResponse response, String jwt, String cookieName);
}
