package com.mono40.domain;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table
public class PreAffiliationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private long msisdn;

    @Column(nullable = false)
    private String name;

    @Column(name = "last_name" , nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(name = "bank_partner_id", nullable = false)
    private String bankPartnerId;

    @Column(name = "bank_partner_name", nullable = false)
    private String bankPartnerName;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(long msisdn) {
        this.msisdn = msisdn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankPartnerId() {
        return bankPartnerId;
    }

    public void setBankPartnerId(String bankPartnerId) {
        this.bankPartnerId = bankPartnerId;
    }

    public String getBankPartnerName() {
        return bankPartnerName;
    }

    public void setBankPartnerName(String bankPartnerName) {
        this.bankPartnerName = bankPartnerName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
