package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;


public class QueryBalance {

    private Long msisdn;
    private String pin;
    private BankDTO bank;
    private String currency;

    @JsonProperty("session-id")
    private String sessionId;

    @JsonProperty("account-number")
    private String accountNumber;

    @JsonProperty("lang-pref")
    private String langPref;

    @JsonProperty("account-alias")
    private String accountAlias;

    @JsonProperty("account-type")
    private String accountType;

    @Override
    public String toString() {
        return "QueryBalance{" +
                "msisdn=" + msisdn +
                ", pin='" + "****" + '\'' +
                ", bank=" + bank +
                ", currency='" + currency + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", langPref='" + langPref + '\'' +
                ", accountAlias='" + accountAlias + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }

    public Long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(Long msisdn) {
        this.msisdn = msisdn;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public BankDTO getBank() {
        return bank;
    }

    public void setBank(BankDTO bank) {
        this.bank = bank;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getLangPref() {
        return langPref;
    }

    public void setLangPref(String langPref) {
        this.langPref = langPref;
    }

    public String getAccountAlias() {
        return accountAlias;
    }

    public void setAccountAlias(String accountAlias) {
        this.accountAlias = accountAlias;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
