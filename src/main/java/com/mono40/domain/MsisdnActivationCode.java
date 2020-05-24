package com.mono40.domain;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by yinfante on 8/28/17.
 */

@Entity
public class MsisdnActivationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Long msisdn;
    @Column(name = "activation_code", nullable = false)
    private String activationCode;

    @Column(name = "creation_date_otp", nullable = false)
    private Date dateCreationOtp;

    @Column(name = "is_valid_otp", nullable = false)
    private boolean otpValid;

    @Column(name = "valid_user_date_otp")
    private Date validUserDateOtp;

    @Column(name = "is_verified_sign_up", nullable = false)
    private boolean verifiedSignUp;

    @Column(name = "verified_sign_up_date")
    private Date verifiedSignUpDate;

    public MsisdnActivationCode() {
    }

    public MsisdnActivationCode(Long msisdn, String activationCode) {
        this.msisdn = msisdn;
        this.activationCode = activationCode;
        this.dateCreationOtp = new Date();
        this.verifiedSignUp =false;
        this.otpValid = false;

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

    public Date getDateCreationOtp() {
        return dateCreationOtp;
    }

    public void setDateCreationOtp(Date dateCreationOtp) {
        this.dateCreationOtp = dateCreationOtp;
    }

    public boolean isOtpValid() {
        return otpValid;
    }

    public void setOtpValid(boolean otpValid) {
        this.otpValid = otpValid;
    }

    public Date getValidUserDateOtp() {
        return validUserDateOtp;
    }

    public void setValidUserDateOtp(Date validUserDateOtp) {
        this.validUserDateOtp = validUserDateOtp;
    }

    public boolean isVerifiedSignUp() {
        return verifiedSignUp;
    }

    public void setVerifiedSignUp(boolean verifiedSignUp) {
        this.verifiedSignUp = verifiedSignUp;
    }

    public Date getVerifiedSignUpDate() {
        return verifiedSignUpDate;
    }

    public void setVerifiedSignUpDate(Date verifiedSignUpDate) {
        this.verifiedSignUpDate = verifiedSignUpDate;
    }
}
