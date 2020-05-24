package com.mono40.types;



public class AuthPin {
    private Long msisdn;
    private String pin;


    public AuthPin(Long msisdn, String pin) {
        this.msisdn = msisdn;
        this.pin = pin;
    }

    public AuthPin() {
    }

    @Override
    public String toString() {
        return "AuthPin{" +
                "msisdn=" + msisdn +
                ", pin='" + "*******" + '\'' +
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
}
