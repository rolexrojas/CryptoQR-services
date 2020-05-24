package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class QueryBalanceResponse {

    @JsonProperty("balance-desc")
    private String balanceDesc;
    private BigDecimal total;
    private BigDecimal available;


    public String getBalanceDesc() {
        return balanceDesc;
    }

    public void setBalanceDesc(String balanceDesc) {
        this.balanceDesc = balanceDesc;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getAvailable() {
        return available;
    }

    public void setAvailable(BigDecimal available) {
        this.available = available;
    }
}
