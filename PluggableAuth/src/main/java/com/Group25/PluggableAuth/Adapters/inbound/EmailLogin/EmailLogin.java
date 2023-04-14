package com.Group25.PluggableAuth.Adapters.inbound.EmailLogin;

/*
 * This class is the data format that we expect to recive from the login httprequest it is used to store the email adress and pass it onto the domain.
 */
public class EmailLogin {
    private String email;
    boolean terms;

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
