package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;


import javax.xml.bind.annotation.XmlElement;


public class CreditCardBalance {

    private Long msisdn;
    @XmlElement(name = "session-id")
    @JsonProperty("session-id")
    private String sessionId;
    @XmlElement(name = "credit-card")
    @JsonProperty("credit-card")
    private CreditCard creditCard;

    public Long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(Long msisdn) {
        this.msisdn = msisdn;
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
}
