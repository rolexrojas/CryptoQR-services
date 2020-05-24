package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;


public class InitialQuery {

    private Object accounts;
    @JsonProperty("credit-cards")
    private Object creditCards;
    private Object loans;

    public Object getAccounts() {
        return accounts;
    }

    public void setAccounts(Object accounts) {
        this.accounts = accounts;
    }

    public Object getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Object creditCards) {
        this.creditCards = creditCards;
    }

    public Object getLoans() {
        return loans;
    }

    public void setLoans(Object loans) {
        this.loans = loans;
    }
}
