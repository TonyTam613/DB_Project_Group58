package com.DB_Project;

import java.sql.Date;

public class Booking {
    private Integer id;
    private Integer room_id;
    private Integer employee_id;
    private Integer customer_id;
    private Date date_of_booking;
    private Integer length_of_stay;

    public Booking(Integer booking_id, Integer room_id, Integer employee_id, Integer customer_id, Date date_of_booking, Integer length_of_stay) {
        this.id = booking_id;
        this.room_id = room_id;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
        this.date_of_booking = date_of_booking;
        this.length_of_stay = length_of_stay;
    }

    public Integer getId() {
        return id;
    }

    public Integer getRoomId() {
        return room_id;
    }

    public Integer getEmployeeId() {
        return employee_id;
    }

    public Integer getCustomerId() {
        return customer_id;
    }

    public Date getDateOfBooking() {
        return date_of_booking;
    }

    public Integer getLengthOfStay() {
        return length_of_stay;
    }

    public void setBookingId(Integer booking_id) {
        this.id = booking_id;
    }

    public void setRoomId(Integer room_id) {
        this.room_id = room_id;
    }

    public void setEmployeeId(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public void setCustomerId(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public void setDateOfBooking(Date date_of_booking) {
        this.date_of_booking = date_of_booking;
    }

    public void setLengthOfStay(Integer length_of_stay) {
        this.length_of_stay = length_of_stay;
    }
}
