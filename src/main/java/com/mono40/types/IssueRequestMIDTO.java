package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;


public class IssueRequestMIDTO {

    private Long msisdn;
    @XmlElement(name = "session-id")
    @JsonProperty("session-id")
    private String sessionId;
    private Partners partner;
    private ProductoPlan productoPlan;
    private String codformapago;
    private String partnerCode;
    @XmlElement(name = "funding-account")
    @JsonProperty("funding-account")
    private Account fundingAccount;
    private GenerateReqResponse generateReqResponse;
    private String pin;
    private boolean creditCard;

    @Override
    public String toString() {
        return "IssueRequestMIDTO{" +
                "msisdn=" + msisdn +
                ", sessionId='" + sessionId + '\'' +
                ", partner=" + partner +
                ", productoPlan=" + productoPlan +
                ", codformapago='" + codformapago + '\'' +
                ", partnerCode='" + partnerCode + '\'' +
                ", fundingAccount=" + fundingAccount +
                ", generateReqResponse=" + generateReqResponse +
                ", pin='" + "****" + '\'' +
                ", creditCard=" + creditCard +
                '}';
    }

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

    public Partners getPartner() {
        return partner;
    }

    public void setPartner(Partners partner) {
        this.partner = partner;
    }

    public ProductoPlan getProductoPlan() {
        return productoPlan;
    }

    public void setProductoPlan(ProductoPlan productoPlan) {
        this.productoPlan = productoPlan;
    }

    public String getCodformapago() {
        return codformapago;
    }

    public void setCodformapago(String codformapago) {
        this.codformapago = codformapago;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public Account getFundingAccount() {
        return fundingAccount;
    }

    public void setFundingAccount(Account fundingAccount) {
        this.fundingAccount = fundingAccount;
    }

    public GenerateReqResponse getGenerateReqResponse() {
        return generateReqResponse;
    }

    public void setGenerateReqResponse(GenerateReqResponse generateReqResponse) {
        this.generateReqResponse = generateReqResponse;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public boolean isCreditCard() {
        return creditCard;
    }

    public void setCreditCard(boolean creditCard) {
        this.creditCard = creditCard;
    }
}
