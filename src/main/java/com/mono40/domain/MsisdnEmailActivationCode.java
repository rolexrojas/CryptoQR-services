package com.mono40.domain;


import javax.persistence.*;
import java.util.Date;


@Entity
public class MsisdnEmailActivationCode {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long msisdn;

    @Column(name = "activation_code", nullable = false)
    private String activationCode;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "is_valid", nullable = false)
    private boolean isValid;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    @Column(name = "verification_date", nullable = false)
    private Date verificationDate;

    public MsisdnEmailActivationCode() {
    }

    public MsisdnEmailActivationCode(Long msisdn, String activationCode, String email, boolean isValid) {
        this.msisdn = msisdn;
        this.activationCode = activationCode;
        this.email = email;
        this.isValid = isValid;
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

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getVerificationDate() {
        return verificationDate;
    }

    public void setVerificationDate(Date verificationDate) {
        this.verificationDate = verificationDate;
    }
}
