package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.io.Serializable;


public class CreditCardInfoDTO implements Serializable {

    @JsonProperty("bank-id")
    private String bankId;
    @JsonProperty("account-number")
    private String accountNumber;
    @JsonProperty("account-type")
    private String accountType;
    @JsonProperty("client-id")
    private String clientId;
    @JsonProperty("client-id-type")
    private String clientIdType;
    private String telephone;
    String currency = "DOP";

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientIdType() {
        return clientIdType;
    }

    public void setClientIdType(String clientIdType) {
        this.clientIdType = clientIdType;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
