package com.mono40.types.error;



import java.util.List;


public class ErrorCatalog {
    private List<ErrorMessage> errorMessages;

    public List<ErrorMessage> getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(List<ErrorMessage> errorMessages) {
        this.errorMessages = errorMessages;
    }
}