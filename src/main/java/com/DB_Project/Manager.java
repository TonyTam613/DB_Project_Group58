package com.DB_Project;

public class Manager {
    private Integer id;
    private Integer hotel_id;
    private String name;
    private String address;
    private Integer SSN;

    public Manager(Integer id, Integer hotel_id, String name, String address, Integer SSN) {
        this.id = id;
        this.hotel_id = hotel_id;
        this.name = name;
        this.address = address;
        this.SSN = SSN;
    }

    public Integer getId() {
        return id;
    }

    public Integer getHotelId() {
        return hotel_id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Integer getSSN() {
        return SSN;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHotelId(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSSN(Integer SSN) {
        this.SSN = SSN;
    }
}
