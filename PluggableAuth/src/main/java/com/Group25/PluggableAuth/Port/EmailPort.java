package com.Group25.PluggableAuth.Port;
public interface EmailPort{
    int sendMail(String email, String messageText);
}
