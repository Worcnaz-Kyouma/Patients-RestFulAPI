package com.medcloud.Patients.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AddressModel {

    @Column(nullable = false, length = 85)
    private String city;

    @Column(nullable = false, length = 38)
    private String street;

    @Column(nullable = false, length = 10)
    private String zip;

    @Column(nullable = false, length = 52)
    private String state;

    @Column(nullable = false, length = 56)
    private String country;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
