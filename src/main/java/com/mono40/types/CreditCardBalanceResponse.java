package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.math.BigDecimal;


public class CreditCardBalanceResponse {

    @JsonProperty("period-amount")
    private BigDecimal periodAmount;
    @JsonProperty("min-amount")
    private BigDecimal minAmount;
    @JsonProperty("current-balance")
    private BigDecimal currentBalance;
    @JsonProperty("due-date")
    private String dueDate;

    public BigDecimal getPeriodAmount() {
        return periodAmount;
    }

    public void setPeriodAmount(BigDecimal periodAmount) {
        this.periodAmount = periodAmount;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
