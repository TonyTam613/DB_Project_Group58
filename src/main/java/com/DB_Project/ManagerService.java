package com.DB_Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ManagerService {

    public List<Manager> getManagers() throws Exception {
        String sql = "SELECT * FROM manager;";

        ConnectionDB db = new ConnectionDB();

        List<Manager> managers = new ArrayList<Manager>();

        try (Connection con = db.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Manager manager = new Manager(
                        rs.getInt("manager_id"),
                        rs.getInt("hotel_id"),
                        rs.getString("manager_name"),
                        rs.getString("address"),
                        rs.getInt("SSN")
                );

                managers.add(manager);

            }

            rs.close();
            stmt.close();
            con.close();
            db.close();

            return managers;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String createManager(Manager manager) throws Exception {
        String message = "";
        Connection con = null;

        ConnectionDB db = new ConnectionDB();
        System.out.println(manager.getId());

        String insertManagerQuery = "INSERT INTO manager (manager_id,hotel_id,manager_name,address,SSN) VALUES (?, ?, ?, ?, ?);";

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(insertManagerQuery);

            stmt.setInt(1, manager.getId());
            stmt.setInt(2, manager.getHotelId());
            stmt.setString(3, manager.getName());
            stmt.setString(4, manager.getAddress());
            stmt.setInt(5, manager.getSSN());

            int output = stmt.executeUpdate();
            System.out.println(output);

            stmt.close();
            db.close();
        } catch (Exception e) {
            message = "Error while inserting manager" + e.getMessage();
        } finally {
            if (con != null) {
                con.close();
            }
            if (message.equals("")) {
                message = "Manager successfully inserted";
            }
        }
        return message;
    }

    public String updateManager(Manager manager) throws Exception {
        Connection con = null;
        String message = "";

        String sql = "UPDATE manager SET manager_id=?, hotel_id=?, manager_name=?, address=?, SSN=? WHERE manager_id=?;";


        ConnectionDB db = new ConnectionDB();

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, manager.getId());
            stmt.setInt(2, manager.getHotelId());
            stmt.setString(3, manager.getName());
            stmt.setString(4, manager.getAddress());
            stmt.setInt(5, manager.getSSN());
            stmt.setInt(6, manager.getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (Exception e) {
            message = "Error while updating manager: " + e.getMessage();
        } finally {
            if (con != null) {
                con.close();
            }
            if (message.equals("")) {
                message = "Manager successfully updated";
            }
        }

        return message;
    }

}
