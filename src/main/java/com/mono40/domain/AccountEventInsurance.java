package com.mono40.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.*;


@Entity(name = "account_event_insurance")
public class AccountEventInsurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long Id;

    private String insuranceNo;
    private Long accountId;
    private String eventKey;

    public AccountEventInsurance(String insuranceNo, Long accountId, String eventKey) {
        this.insuranceNo = insuranceNo;
        this.accountId = accountId;
        this.eventKey = eventKey;
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}
