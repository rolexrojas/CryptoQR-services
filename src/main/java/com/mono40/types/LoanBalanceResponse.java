package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

public class LoanBalanceResponse {

    @XmlElement(name = "balance-desc")
    @JsonProperty("balance-desc")
    private String balanceDesc;
    private BigDecimal balance;
    private BigDecimal fee;
    @XmlElement(name = "due-date")
    @JsonProperty("due-date")
    private String dueDate;

    public String getBalanceDesc() {
        return balanceDesc;
    }

    public void setBalanceDesc(String balanceDesc) {
        this.balanceDesc = balanceDesc;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
