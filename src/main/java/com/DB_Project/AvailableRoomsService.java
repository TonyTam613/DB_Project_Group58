package com.DB_Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AvailableRoomsService {
    public List<AvailableRooms> getARView() throws Exception {
        String sql = "SELECT * FROM available_rooms;";

        ConnectionDB db = new ConnectionDB();

        List<AvailableRooms> view = new ArrayList<AvailableRooms>();

        try (Connection con = db.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AvailableRooms viewEntry = new AvailableRooms(
                        rs.getInt("Number_Of_Available_Rooms"),
                        rs.getString("Area")
                );

                view.add(viewEntry);

            }

            rs.close();
            stmt.close();
            con.close();
            db.close();

            return view;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
