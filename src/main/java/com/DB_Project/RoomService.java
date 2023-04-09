package com.DB_Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomService {

    public List<Room> getRooms() throws Exception {
        String sql = "SELECT * FROM room;";

        ConnectionDB db = new ConnectionDB();

        List<Room> rooms = new ArrayList<Room>();

        try (Connection con = db.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Room room = new Room(
                        rs.getInt("room_id"),
                        rs.getBigDecimal("price"),
                        rs.getString("capacity"),
                        rs.getString("room_view"),
                        rs.getString("extendability"),
                        rs.getString("room_condition"),
                        rs.getInt("hotel_id")
                );

                rooms.add(room);

            }

            rs.close();
            stmt.close();
            con.close();
            db.close();

            return rooms;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String createRoom(Room room) throws Exception {
        String message = "";
        Connection con = null;

        ConnectionDB db = new ConnectionDB();
        System.out.println(room.getId());

        String insertRoomQuery = "INSERT INTO room (room_id, hotel_id, price, capacity, room_view, extendability, room_condition) VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(insertRoomQuery);

            stmt.setInt(1, room.getId());
            stmt.setInt(2, room.getHotelId());
            stmt.setBigDecimal(3, room.getPrice());
            stmt.setString(4, room.getCapacity());
            stmt.setString(5, room.getView());
            stmt.setString(6, room.getExtendability());
            stmt.setString(7, room.getCondition());

            int output = stmt.executeUpdate();
            System.out.println(output);

            stmt.close();
            db.close();
        } catch (Exception e) {
            message = "Error while inserting room" + e.getMessage();
        } finally {
            if (con != null) {
                con.close();
            }
            if (message.equals("")) {
                message = "Room successfully inserted";
            }
        }
        return message;
    }

    public String deleteRoom(Integer id) throws Exception {
        Connection con = null;
        String message = "";

        // sql query
        String sql = "DELETE FROM room WHERE room_id = ?;";

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
            message = "Error while delete room: " + e.getMessage();
        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "Room successfully deleted!";
        }

        return message;
    }

    public String updateRoom(Room room) throws Exception {
        Connection con = null;
        String message = "";

        String sql = "UPDATE room SET room_id=?, hotel_id=?, price=?, capacity=?, room_view=?, extendability=?, room_condition=? WHERE room_id=?;";


        ConnectionDB db = new ConnectionDB();

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, room.getId());
            stmt.setInt(2, room.getHotelId());
            stmt.setBigDecimal(3, room.getPrice());
            stmt.setString(4, room.getCapacity());
            stmt.setString(5, room.getView());
            stmt.setString(6, room.getExtendability());
            stmt.setString(7, room.getCondition());
            stmt.setInt(8, room.getId());

            stmt.executeUpdate();

            stmt.close();
        } catch (Exception e) {
            message = "Error while updating room: " + e.getMessage();
        } finally {
            if (con != null) {
                con.close();
            }
            if (message.equals("")) {
                message = "Room successfully updated";
            }
        }

        return message;
    }

}
