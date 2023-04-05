package com.DB_Project;

import java.math.BigDecimal;

public class Chain {
    private Integer id;
    private Integer numHotels;
    private String email;
    private BigDecimal phone;
    private String address;
    private String city;
    private String name;

    public Chain(Integer id, Integer numHotels, String email, BigDecimal phone, String address, String city, String name) {
        this.id = id;
        this.numHotels = numHotels;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.name = name;
    }

    public Integer getId() { return id; }
    public Integer getNumHotels() { return numHotels; }
    public String getEmail() { return email; }
    public BigDecimal getPhone() { return phone; }
    public String getAddress() { return address; }
    public String getCity() { return city; }
    public String getName() { return name; }

    public void setId(Integer id) { this.id = id; }
    public void setNumHotels(Integer numHotels) { this.numHotels = numHotels; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(BigDecimal phone) { this.phone = phone; }
    public void setAddress(String address) { this.address = address; }
    public void setCity(String city) { this.city = city; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "<ul>"
                + "<li>id= " + id + "</li>"
                + "<li>numHotels= " + numHotels + "</li>"
                + "<li>email= " + email + "</li>"
                + "<li>phone= " + phone + "</li>"
                + "<li>address= " + address + "</li>"
                + "<li>city= " + city + "</li>"
                + "<li>name= " + name + "</li>";
    }
}
