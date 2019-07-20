package com.seleniumpractice.utilities;

public class Utilities {

    private String userEmail;
    private String userPassword;

    public void setUserEmail(String userEmail){
        this.userEmail = userEmail;
    }

    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }

    public String getUserEmail(){
        return this.userEmail;
    }

    public String getUserPassword(){
        return this.userPassword;
    }
}
