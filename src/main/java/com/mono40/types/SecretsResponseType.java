package com.mono40.types;


public class SecretsResponseType {

    private String key;

    public SecretsResponseType() {
    }

    public SecretsResponseType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
