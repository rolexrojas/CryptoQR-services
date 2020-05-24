package com.mono40.types;



/**
 * Created by wbinet on 4/20/2018.
 */

public class PaypalAccount {

    private int id;
    private String documentId;
    private long msisdn;
    private String paypalEmail;
    private String paypalAccountId;
    private String preApprovalKey;
    private String alias;
    private String token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(long msisdn) {
        this.msisdn = msisdn;
    }

    public String getPaypalEmail() {
        return paypalEmail;
    }

    public void setPaypalEmail(String paypalEmail) {
        this.paypalEmail = paypalEmail;
    }

    public String getPaypalAccountId() {
        return paypalAccountId;
    }

    public void setPaypalAccountId(String paypalAccountId) {
        this.paypalAccountId = paypalAccountId;
    }

    public String getPreApprovalKey() {
        return preApprovalKey;
    }

    public void setPreApprovalKey(String preApprovalKey) {
        this.preApprovalKey = preApprovalKey;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
