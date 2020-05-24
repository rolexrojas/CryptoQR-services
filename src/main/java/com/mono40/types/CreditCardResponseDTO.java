package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.io.Serializable;


public class CreditCardResponseDTO implements Serializable {

    @JsonProperty("account-number")
    private String accountNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
