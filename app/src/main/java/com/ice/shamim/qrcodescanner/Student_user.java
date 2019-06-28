package com.ice.shamim.qrcodescanner;

public class Student_user
{
    private String email;

    private String username;

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [email = "+email+", username = "+username+"]";
    }
}

