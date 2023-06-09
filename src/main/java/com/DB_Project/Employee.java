package com.DB_Project;

public class Employee {
    private Integer id;
    private String name;
    private String address;
    private String city;
    private Integer SSN;

    public Employee(Integer id, String name, String address, String city, Integer SSN) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.SSN = SSN;
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

    public String toString() {
        return "employee_id: " + id.toString();
    }
}
