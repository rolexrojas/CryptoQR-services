package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenModel {

    @JsonProperty("account-id")
    private Long accountId;

    @JsonProperty("public-key")
    private String publicKey;


    public TokenModel() {
    }

    public TokenModel(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
