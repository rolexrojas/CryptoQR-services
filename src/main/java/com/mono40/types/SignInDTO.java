package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;


public class SignInDTO {

    private String username;
    private String password;
    private String accountKey;

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

    public String getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(String accountKey) {
        this.accountKey = accountKey;
    }

    @Override
    public String toString() {
        return "SignInDTO{" +
                "username='" + username + '\'' +
                ", password='" + "*********" + '\'' +
                ", accountKey=" + accountKey +
                '}';
    }


}
