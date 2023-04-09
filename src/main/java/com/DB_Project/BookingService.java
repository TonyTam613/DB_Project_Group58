package com.DB_Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookingService {

    public List<Booking> getBookings() throws Exception {
        String sql = "SELECT * FROM booking;";

        ConnectionDB db = new ConnectionDB();

        List<Booking> bookings = new ArrayList<Booking>();

        try (Connection con = db.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking(
                        rs.getInt("booking_id"),
                        rs.getInt("room_id"),
                        rs.getInt("employee_id"),
                        rs.getInt("customer_id"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date"),
                        rs.getString("current_status")
                );

                bookings.add(booking);

            }

            rs.close();
            stmt.close();
            con.close();
            db.close();

            return bookings;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String createBooking(Booking booking) throws Exception {
        String message = "";
        Connection con = null;

        ConnectionDB db = new ConnectionDB();
        System.out.println(booking.getId());

        String insertBookingQuery = "INSERT INTO booking (booking_id, room_id, employee_id, customer_id, start_date, end_date, current_status) VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(insertBookingQuery);

            stmt.setInt(1, booking.getId());
            stmt.setInt(2, booking.getRoomId());
            stmt.setInt(3, booking.getEmployeeId());
            stmt.setInt(4, booking.getCustomerId());
            stmt.setDate(5, booking.getStartDate());
            stmt.setDate(6, booking.getEndDate());
            stmt.setString(7, booking.getCurrentStatus());

            int output = stmt.executeUpdate();
            System.out.println(output);

            stmt.close();
            db.close();
        } catch (Exception e) {
            message = "Error while inserting booking" + e.getMessage();
        } finally {
            if (con != null) {
                con.close();
            }
            if (message.equals("")) {
                message = "Booking successfully inserted";
            }
        }
        return message;
    }

    public String deleteBooking(Integer id) throws Exception {
        Connection con = null;
        String message = "";

        // sql query
        String sql = "DELETE FROM booking WHERE booking_id = ?;";

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
            message = "Error while delete booking: " + e.getMessage();
        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "Booking successfully deleted!";
        }

        return message;
    }

    public String updateBooking(Booking booking) throws Exception {
        Connection con = null;
        String message = "";

        String sql = "UPDATE booking SET booking_id=?, room_id=?, employee_id=?, customer_id=?, start_date=?, end_date=?, current_status=? WHERE booking_id=?;";


        ConnectionDB db = new ConnectionDB();

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, booking.getId());
            stmt.setInt(2, booking.getRoomId());
            stmt.setInt(3, booking.getEmployeeId());
            stmt.setInt(4, booking.getCustomerId());
            stmt.setDate(5, booking.getStartDate());
            stmt.setDate(6, booking.getEndDate());
            stmt.setString(7, booking.getCurrentStatus());
            stmt.setInt(8, booking.getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (Exception e) {
            message = "Error while updating booking: " + e.getMessage();
        } finally {
            if (con != null) {
                con.close();
            }
            if (message.equals("")) {
                message = "Booking successfully updated";
            }
        }
        return message;
    }

}
