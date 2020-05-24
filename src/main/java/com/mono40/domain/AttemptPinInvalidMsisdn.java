package com.mono40.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table
public class AttemptPinInvalidMsisdn implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Long msisdn;
    private int pinFailAttempts;
    private Date lastPinFailAttemptDate;
    private String lastPinFailTransaction;

    public AttemptPinInvalidMsisdn() {
    }


    public AttemptPinInvalidMsisdn(Long msisdn, int pinFailAttempts, Date lastPinFailAttemptDate, String lastPinFailTransaction) {
        this.msisdn = msisdn;
        this.pinFailAttempts = pinFailAttempts;
        this.lastPinFailAttemptDate = lastPinFailAttemptDate;
        this.lastPinFailTransaction = lastPinFailTransaction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(Long msisdn) {
        this.msisdn = msisdn;
    }

    public int getPinFailAttempts() {
        return pinFailAttempts;
    }

    public void setPinFailAttempts(int pinFailAttempts) {
        this.pinFailAttempts = pinFailAttempts;
    }

    public Date getLastPinFailAttemptDate() {
        return lastPinFailAttemptDate;
    }

    public void setLastPinFailAttemptDate(Date lastPinFailAttemptDate) {
        this.lastPinFailAttemptDate = lastPinFailAttemptDate;
    }

    public String getLastPinFailTransaction() {
        return lastPinFailTransaction;
    }

    public void setLastPinFailTransaction(String lastPinFailTransaction) {
        this.lastPinFailTransaction = lastPinFailTransaction;
    }
}
