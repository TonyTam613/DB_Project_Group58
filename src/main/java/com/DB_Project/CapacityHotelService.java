package com.DB_Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CapacityHotelService {
    public List<CapacityHotel> getCHView() throws Exception {
        String sql = "SELECT * FROM capacity_per_hotel;";

        ConnectionDB db = new ConnectionDB();

        List<CapacityHotel> view = new ArrayList<CapacityHotel>();

        try (Connection con = db.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CapacityHotel viewEntry = new CapacityHotel(
                        rs.getInt("Hotel_ID"),
                        rs.getInt("Total_Capacity")
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
