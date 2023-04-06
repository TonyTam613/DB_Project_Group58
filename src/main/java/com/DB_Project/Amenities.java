package com.DB_Project;

public class Amenities {
    private String service;
    private Integer room_id;
    private Integer hotel_id;

    public Amenities(String service, Integer room_id, Integer hotel_id) {
        this.service = service;
        this.room_id = room_id;
        this.hotel_id = hotel_id;
    }

    public String getService() {
        return service;
    }

    public Integer getRoomId() {
        return room_id;
    }

    public Integer getHotelId() {
        return hotel_id;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setRoomId(Integer room_id) {
        this.room_id = room_id;
    }

    public void setHotelId(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }
}
