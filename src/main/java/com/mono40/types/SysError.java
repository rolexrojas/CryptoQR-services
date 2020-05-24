package com.mono40.types;

public class SysError {

    private String code;
    private String description;
    private String transaction;

    public SysError() {

    }

    public SysError(String code, String description) {
        this.code = code;
        this.description = description;
    }


    @Override
    public String toString() {
        return "{" +
                "\"code\":\"" + code + "\"" +
                ", \"description\":\"" + description + "\"" +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }
}
