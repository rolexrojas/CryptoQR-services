package com.mono40.types.error;


public class ErrorMessage {

    private String exceptionClass;
    private String code;
    private String httpStatus;
    private String description;

    public String getExceptionClass() {
        return exceptionClass;
    }

    public String getCode() {
        return code;
    }

    public String getHttpStatus() {
        return httpStatus;
    }

    public String getDescription() {
        return description;
    }
}
