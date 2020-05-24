package com.mono40.types;


import org.springframework.hateoas.ResourceSupport;


public class InitialGeneral extends ResourceSupport {

    private InitialQuery query;
    private PaymentQuery payment;
    private Object beneficiaries;

    public InitialQuery getQuery() {
        return query;
    }

    public void setQuery(InitialQuery query) {
        this.query = query;
    }

    public PaymentQuery getPayment() {
        return payment;
    }

    public void setPayment(PaymentQuery payment) {
        this.payment = payment;
    }

    public Object getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(Object beneficiaries) {
        this.beneficiaries = beneficiaries;
    }
}
