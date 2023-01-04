package com.medcloud.Patients.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "PATIENTS")
public class PatientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private Date birthday;

    @Column(nullable = false, unique = true, length = 320)
    private String email;

    @Embedded
    private AddressModel address;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }
}
