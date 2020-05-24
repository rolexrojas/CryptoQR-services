package com.mono40.types;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("invoice")
public class CustomerInvoice {

    private String contract;
    private PartnerDTO partner;

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public PartnerDTO getPartner() {
        return partner;
    }

    public void setPartner(PartnerDTO partner) {
        this.partner = partner;
    }
}
