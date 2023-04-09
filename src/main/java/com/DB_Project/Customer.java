package com.DB_Project;

import java.sql.Date;

public class Customer {
    private Integer id;
    private String name;
    private String address;
    private String city;
    private Integer SSN;
    private Date DOR;

    public Customer(Integer id, String name, String address, String city, Integer SSN, Date DOR) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.SSN = SSN;
        this.DOR = DOR;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public Integer getSSN() {
        return SSN;
    }

    public Date getDOR() {
        return DOR;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSSN(Integer SSN) {
        this.SSN = SSN;
    }

    public void setDOR(Date DOR) {
        this.DOR = DOR;
    }

    @Override
    public String toString() {
        return "customer_id: " + id.toString();
    }
}
