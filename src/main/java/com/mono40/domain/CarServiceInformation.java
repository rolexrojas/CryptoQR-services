package com.mono40.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CarServiceInformation implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String eventkey;
    private String miles;
    private String year;
    private String make;
    private String model;
    private String insuranceNo;

    public CarServiceInformation(String eventkey, String miles, String year, String make, String model, String insuranceNo) {
        this.eventkey = eventkey;
        this.miles = miles;
        this.year = year;
        this.make = make;
        this.model = model;
        this.insuranceNo = insuranceNo;
    }

    public String getMiles() {
        return miles;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }
}
