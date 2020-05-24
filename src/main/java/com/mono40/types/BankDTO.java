package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


import java.math.BigDecimal;



@JsonRootName(value = "bank")
public class BankDTO {

    private boolean active = true;

    @JsonProperty("bank-id")
    private String bankPartnerId;

    @JsonProperty("bank-code")
    private BigDecimal bankPartnerCode;

    @JsonProperty("bank-logo-uri")
    private String bankLogoURI;

    @JsonProperty("bank-name")
    private String bankPartnerName;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getBankPartnerId() {
        return bankPartnerId;
    }

    public void setBankPartnerId(String bankPartnerId) {
        this.bankPartnerId = bankPartnerId;
    }

    public BigDecimal getBankPartnerCode() {
        return bankPartnerCode;
    }

    public void setBankPartnerCode(BigDecimal bankPartnerCode) {
        this.bankPartnerCode = bankPartnerCode;
    }

    public String getBankLogoURI() {
        return bankLogoURI;
    }

    public void setBankLogoURI(String bankLogoURI) {
        this.bankLogoURI = bankLogoURI;
    }

    public String getBankPartnerName() {
        return bankPartnerName;
    }

    public void setBankPartnerName(String bankPartnerName) {
        this.bankPartnerName = bankPartnerName;
    }
}
