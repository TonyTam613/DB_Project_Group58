package com.DB_Project;

public class CapacityHotel {
    Integer hotel_id;
    Integer totalCapacity;

    public CapacityHotel(Integer hotel_id, Integer totalCapacity) {
        this.hotel_id = hotel_id;
        this.totalCapacity = totalCapacity;
    }

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Integer getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(Integer totalCapacity) {
        this.totalCapacity = totalCapacity;
    }
}
