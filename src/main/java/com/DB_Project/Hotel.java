package com.DB_Project;

import java.math.BigDecimal;

public class Hotel {
    private Integer id;
    private Integer numRooms;
    private String email;
    private BigDecimal phone;
    private String category;
    private Integer chainId;
    private String address;
    private String city;

    public Hotel(Integer id, Integer numRooms, String email, BigDecimal phone, String category, Integer chainId, String address, String city) {
        this.id = id;
        this.numRooms = numRooms;
        this.email = email;
        this.phone = phone;
        this.category = category;
        this.chainId = chainId;
        this.address = address;
        this.city = city;
    }

    public Integer getId() { return this.id; }
    public Integer getNumRooms() { return this.numRooms; }
    public String getEmail() { return this.email; }
    public BigDecimal getPhone() { return this.phone; }
    public String getCategory() { return this.category; }
    public Integer getChainId() { return this.chainId; }
    public String getAddress() { return this.address; }
    public String getCity() { return this.city; }

    public void setId(Integer id) { this.id = id; }
    public void setNumRooms(Integer numRooms) { this.numRooms = numRooms; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(BigDecimal phone) { this.phone = phone; }
    public void setCategory(String category) { this.category = category; }
    public void setChainId(Integer chainId) { this.chainId = chainId; }
    public void setAddress(String address) { this.address = address; }
    public void setCity(String city) { this.city = city; }

    @Override
    public String toString() {
        return "<ul>"
                + "<li>id= " + id + "</li>"
                + "<li>numRooms= " + numRooms + "</li>"
                + "<li>email= " + email + "</li>"
                + "<li>phone= " + phone + "</li>"
                + "<li>category= " + category + "</li>"
                + "<li>chain_id= " + chainId + "</li>"
                + "<li>address= " + address + "</li>"
                + "<li>city= " + city + "</li>";
    }
}
