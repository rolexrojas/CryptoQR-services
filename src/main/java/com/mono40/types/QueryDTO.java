package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;


public abstract class QueryDTO {

    protected BankDTO bank;
    protected String currency;
    protected boolean payable;
    private Integer priority;

    @JsonProperty("account-number")
    private String accountNumber;

    @JsonProperty("account-alias")
    private String accountAlias;

    @JsonProperty("account-type")
    private String accountType;

    @JsonProperty("query-fee")
    private BigDecimal queryFee;

    @JsonProperty("default-account")
    private Boolean defaultAccount;

    @JsonProperty("altpan-key")
    private String altPanKey;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public boolean isPayable() {
        return payable;
    }

    public void setPayable(boolean payable) {
        this.payable = payable;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public BigDecimal getQueryFee() {
        return queryFee;
    }

    public void setQueryFee(BigDecimal queryFee) {
        this.queryFee = queryFee;
    }

    public Boolean getDefaultAccount() {
        return defaultAccount;
    }

    public void setDefaultAccount(Boolean defaultAccount) {
        this.defaultAccount = defaultAccount;
    }

    public String getAltPanKey() {
        return altPanKey;
    }

    public void setAltPanKey(String altPanKey) {
        this.altPanKey = altPanKey;
    }

    public BankDTO getBank() {
        return bank;
    }

    public void setBank(BankDTO bank) {
        this.bank = bank;
    }
}
