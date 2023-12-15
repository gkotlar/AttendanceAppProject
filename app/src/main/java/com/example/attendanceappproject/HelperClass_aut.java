package com.example.attendanceappproject;

public class HelperClass_aut {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAccount_type() {
        return account_type;
    }

    public void setAccount_type(Boolean account_type) {
        this.account_type = account_type;
    }

    public HelperClass_aut(String username, String password, String email, Boolean account_type) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.account_type = account_type;
    }

    String email;
    Boolean account_type;

    public HelperClass_aut() {
    }
}
