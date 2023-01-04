package com.medcloud.Patients.dtos;

import jakarta.validation.constraints.NotBlank;

public class AddressDTO {

    @NotBlank
    private String city;

    @NotBlank
    private String street;

    @NotBlank
    private String zip;

    @NotBlank
    private String state;

    @NotBlank
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
