package com.DB_Project;

import java.sql.Date;

public class Booking {
    private Integer id;
    private Integer room_id;
    private Integer employee_id;
    private Integer customer_id;
    private Date start_date;
    private Date end_date;
    private String current_status;

    public Booking(Integer id, Integer room_id, Integer employee_id, Integer customer_id, Date start_date, Date end_date, String current_status) {
        this.id = id;
        this.room_id = room_id;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.current_status = current_status;
    }

    public Booking(Integer room_id, Integer customer_id, Date start_date, Date end_date, String current_status) {
        this.room_id = room_id;
        this.customer_id = customer_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.current_status = current_status;
    }

    public Booking(Integer id, Integer employee_id, String current_status) {
        this.id = id;
        this.employee_id = employee_id;
        this.current_status = current_status;
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

    public Date getStartDate() { return start_date; }

    public Date getEndDate() { return end_date; }

    public String getCurrentStatus() { return current_status; }

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

    public void setStartDate(Date start_date) { this.start_date = start_date; }

    public void setEndDate(Date end_date) { this.end_date = end_date; }

    public void setCurrentStatus(String current_status) { this.current_status = current_status; }

    @Override
    public String toString() {
        return "booking_id: " + id.toString();
    }
}
