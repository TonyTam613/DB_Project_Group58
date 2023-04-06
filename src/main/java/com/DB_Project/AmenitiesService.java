package com.DB_Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AmenitiesService {

    public List<Amenities> getAmenities() throws Exception {
        String sql = "SELECT * FROM amenities;";

        ConnectionDB db = new ConnectionDB();

        List<Amenities> amenities = new ArrayList<Amenities>();

        try (Connection con = db.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Amenities amenity = new Amenities(
                        rs.getString("service"),
                        rs.getInt("room_id"),
                        rs.getInt("hotel_id")
                );

                amenities.add(amenity);

            }

            rs.close();
            stmt.close();
            con.close();
            db.close();

            return amenities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String createAmenity(Amenities amenities) throws Exception {
        String message = "";
        Connection con = null;

        ConnectionDB db = new ConnectionDB();
        System.out.println(amenities.getService());
        System.out.println(amenities.getRoomId());
        System.out.println(amenities.getHotelId());

        String insertAmenitiesQuery = "INSERT INTO amenities (service, room_id, hotel_id) VALUES (?, ?, ?);";

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(insertAmenitiesQuery);

            stmt.setString(1, amenities.getService());
            stmt.setInt(2, amenities.getRoomId());
            stmt.setInt(3, amenities.getHotelId());

            int output = stmt.executeUpdate();
            System.out.println(output);

            stmt.close();
            db.close();
        } catch (Exception e) {
            message = "Error while inserting amenity" + e.getMessage();
        } finally {
            if (con != null) {
                con.close();
            }
            if (message.equals("")) {
                message = "Amenity successfully inserted";
            }
        }
        return message;
    }

    public String updateAmenity(Amenities amenities) throws Exception {
        Connection con = null;
        String message = "";

        String sql = "UPDATE amenities SET service=?, room_id=?, hotel_id=? WHERE service=? AND room_id=? AND hotel_id=?;";


        ConnectionDB db = new ConnectionDB();

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, amenities.getService());
            stmt.setInt(2, amenities.getRoomId());
            stmt.setInt(3, amenities.getHotelId());
            stmt.setString(4, amenities.getService());
            stmt.setInt(5, amenities.getRoomId());
            stmt.setInt(6, amenities.getHotelId());

            stmt.executeUpdate();
            stmt.close();

        } catch (Exception e) {
            message = "Error while updating amenity: " + e.getMessage();
        } finally {
            if (con != null) {
                con.close();
            }
            if (message.equals("")) {
                message = "Amenity successfully updated";
            }
        }
        return message;
    }
}
