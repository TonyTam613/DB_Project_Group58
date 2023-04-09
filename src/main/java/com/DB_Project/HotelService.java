package com.DB_Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HotelService {

    public List<Hotel> getHotels() throws Exception {
        String sql = "SELECT * FROM hotel;";

        ConnectionDB db = new ConnectionDB();

        List<Hotel> hotels = new ArrayList<Hotel>();

        try (Connection con = db.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Hotel hotel = new Hotel(
                        rs.getInt("hotel_id"),
                        rs.getInt("number_of_rooms"),
                        rs.getString("email"),
                        rs.getBigDecimal("phone"),
                        rs.getString("category"),
                        rs.getInt("chain_id"),
                        rs.getString("address"),
                        rs.getString("city")
                );

                hotels.add(hotel);

            }

            rs.close();
            stmt.close();
            con.close();
            db.close();

            return hotels;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String createHotel(Hotel hotel) throws Exception {
        String message = "";
        Connection con = null;

        ConnectionDB db = new ConnectionDB();
        System.out.println(hotel.getId());

        String insertHotelQuery = "INSERT INTO hotel (hotel_id,chain_id,number_of_room,email,phone,category,address,city) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(insertHotelQuery);

            stmt.setInt(1, hotel.getId());
            stmt.setInt(2, hotel.getChainId());
            stmt.setInt(3, hotel.getNumRooms());
            stmt.setString(4, hotel.getEmail());
            stmt.setBigDecimal(5, hotel.getPhone());
            stmt.setString(6, hotel.getCategory());
            stmt.setString(7, hotel.getAddress());
            stmt.setString(8, hotel.getCity());

            int output = stmt.executeUpdate();
            System.out.println(output);

            stmt.close();
            db.close();
        } catch (Exception e) {
            message = "Error while inserting hotel" + e.getMessage();
        } finally {
            if (con != null) {
                con.close();
            }
            if (message.equals("")) {
                message = "Hotel successfully inserted";
            }
        }
        return message;
    }

    public String deleteHotel(Integer id) throws Exception {
        Connection con = null;
        String message = "";

        // sql query
        String sql = "DELETE FROM hotel WHERE hotel_id = ?;";

        // database connection object
        ConnectionDB db = new ConnectionDB();

        // try connect to database, catch any exceptions
        try {
            con = db.getConnection();

            // prepare statement
            PreparedStatement stmt = con.prepareStatement(sql);

            // set every ? of statement
            stmt.setInt(1, id);

            // execute the query
            stmt.executeUpdate();

            // close the statement
            stmt.close();

        } catch (Exception e) {
            message = "Error while delete hotel: " + e.getMessage();
        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "Hotel successfully deleted!";
        }

        return message;
    }

    public String updateHotel(Hotel hotel) throws Exception {
        Connection con = null;
        String message = "";

        String sql = "UPDATE hotel SET hotel_id=?, chain_id=?, number_of_room=?, email=?, phone=?, category=?, address=?, city=? WHERE hotel_id=?;";


        ConnectionDB db = new ConnectionDB();

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, hotel.getId());
            stmt.setInt(2, hotel.getChainId());
            stmt.setInt(3, hotel.getNumRooms());
            stmt.setString(4, hotel.getEmail());
            stmt.setBigDecimal(5, hotel.getPhone());
            stmt.setString(6, hotel.getCategory());
            stmt.setString(7, hotel.getAddress());
            stmt.setString(8, hotel.getCity());
            stmt.setInt(9, hotel.getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (Exception e) {
            message = "Error while updating hotel: " + e.getMessage();
        } finally {
            if (con != null) {
                con.close();
            }
            if (message.equals("")) {
                message = "Hotel successfully updated";
            }
        }

        return message;
    }

}
