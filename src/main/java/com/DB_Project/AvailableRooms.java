package com.DB_Project;

public class AvailableRooms {
    Integer availableRooms;
    String area;

    public AvailableRooms(Integer availableRooms, String area) {
        this.availableRooms = availableRooms;
        this.area = area;
    }

    public void setAvailableRooms(Integer availableRooms) {
        this.availableRooms = availableRooms;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getAvailableRooms() {
        return availableRooms;
    }

    public String getArea() {
        return area;
    }
}
