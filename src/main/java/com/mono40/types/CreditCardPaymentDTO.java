package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;


import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

public class CreditCardPaymentDTO {

    private Long msisdn;
    private String pin;

    @XmlElement(name = "amount-to-pay")
    @JsonProperty("amount-to-pay")
    private BigDecimal amountToPay;

    @XmlElement(name = "pay-option")
    @JsonProperty("pay-option")
    private int payOption;

    @XmlElement(name = "lang-pref")
    @JsonProperty("lang-pref")
    private String langPref;

    @XmlElement(name = "session-id")
    @JsonProperty("session-id")
    private String sessionId;

    @XmlElement(name = "credit-card")
    @JsonProperty("credit-card")
    private CreditCard creditCard;
    @XmlElement(name = "funding-account")
    @JsonProperty("funding-account")
    private Account fundingAccount;

    @Override
    public String toString() {
        return "CreditCardPaymentDTO{" +
                "msisdn=" + msisdn +
                ", pin='" + "****" + '\'' +
                ", amountToPay=" + amountToPay +
                ", payOption=" + payOption +
                ", langPref='" + langPref + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", creditCard=" + creditCard +
                ", fundingAccount=" + fundingAccount +
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

    public BigDecimal getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(BigDecimal amountToPay) {
        this.amountToPay = amountToPay;
    }

    public int getPayOption() {
        return payOption;
    }

    public void setPayOption(int payOption) {
        this.payOption = payOption;
    }

    public String getLangPref() {
        return langPref;
    }

    public void setLangPref(String langPref) {
        this.langPref = langPref;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Account getFundingAccount() {
        return fundingAccount;
    }

    public void setFundingAccount(Account fundingAccount) {
        this.fundingAccount = fundingAccount;
    }
}
