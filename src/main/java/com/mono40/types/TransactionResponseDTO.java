package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;



public class TransactionResponseDTO {

    @JsonProperty("transaction-id")
    private String transactionId;

    @JsonProperty("transaction-message")
    private String transactionMessage;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionMessage() {
        return transactionMessage;
    }

    public void setTransactionMessage(String transactionMessage) {
        this.transactionMessage = transactionMessage;
    }
}
