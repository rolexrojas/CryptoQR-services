package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;


import javax.xml.bind.annotation.XmlElement;


public class LoanBalance {

    private Long msisdn;
    @XmlElement(name = "session-id")
    @JsonProperty("session-id")
    private String sessionId;
    private Loan loan;

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

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}
