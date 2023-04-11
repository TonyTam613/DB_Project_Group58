package com.DB_Project;

import java.math.BigDecimal;

public class Room {
    private Integer id;
    private BigDecimal price;
    private Integer capacity;
    private String view;
    private String extendability;
    private String condition;
    private Integer hotelId;

    public Room(Integer id, BigDecimal price, Integer capacity, String view, String extendability, String condition, Integer hotelId) {
        this.id = id;
        this.price = price;
        this.capacity = capacity;
        this.view = view;
        this.extendability = extendability;
        this.condition = condition;
        this.hotelId = hotelId;
    }

    public Integer getId() { return this.id; }
    public BigDecimal getPrice() { return this.price; }
    public Integer getCapacity() { return this.capacity; }
    public String getView() { return this.view; }
    public String getExtendability() { return this.extendability; }
    public String getCondition() { return this.condition; }
    public Integer getHotelId() { return this.hotelId; }

    public void setId(Integer id) { this.id = id; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public void setView(String view) { this.view = view; }
    public void setExtendability(String extendability) { this.extendability = extendability; }
    public void setCondition(String condition) { this.condition = condition; }
    public void setHotelId(Integer hotelId) { this.hotelId = hotelId; }

    @Override
    public String toString() {
        return "<ul>"
                + "<li>id= " + id + "</li>"
                + "<li>price= " + price + "</li>"
                + "<li>capacity= " + capacity + "</li>"
                + "<li>view= " + view + "</li>"
                + "<li>extendability= " + extendability + "</li>"
                + "<li>condition= " + condition + "</li>"
                + "<li>hotel_id= " + hotelId + "</li>"
                + "</ul>";
    }

}
