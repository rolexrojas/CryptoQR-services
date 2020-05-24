package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;

/**
 * Created by wbinet on 4/20/2018.
 */
public class PaypalRechargeAccount {

    @JsonProperty("paypal-accounts")
    private List<PaypalAccount> paypalAccounts;

    public PaypalRechargeAccount(List<PaypalAccount> paypalAccount) {
        this.paypalAccounts = paypalAccount;
    }

    public List<PaypalAccount> getPaypalAccounts() {
        return paypalAccounts;
    }

    public void setPaypalAccounts(List<PaypalAccount> paypalAccounts) {
        this.paypalAccounts = paypalAccounts;
    }
}
