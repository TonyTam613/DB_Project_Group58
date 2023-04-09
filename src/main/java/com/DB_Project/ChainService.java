package com.DB_Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChainService {

    public List<Chain> getChains() throws Exception {
        String sql = "SELECT * FROM hotel_chain;";

        ConnectionDB db = new ConnectionDB();

        List<Chain> chains = new ArrayList<Chain>();

        try (Connection con = db.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Chain chain = new Chain(
                        rs.getInt("chain_id"),
                        rs.getInt("number_of_hotels"),
                        rs.getString("email"),
                        rs.getBigDecimal("phone"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("chain_name")
                );

                chains.add(chain);

            }

            rs.close();
            stmt.close();
            con.close();
            db.close();

            return chains;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String createChain(Chain chain) throws Exception {
        String message = "";
        Connection con = null;

        ConnectionDB db = new ConnectionDB();
        System.out.println(chain.getId());

        String insertChainQuery = "INSERT INTO hotel_chain (chain_id,number_of_hotels,email,phone,address,city,chain_name) VALUES (?, ?, ?, ?, ?, ?, ?);";

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(insertChainQuery);

            stmt.setInt(1, chain.getId());
            stmt.setInt(2, chain.getNumHotels());
            stmt.setString(3, chain.getEmail());
            stmt.setBigDecimal(4, chain.getPhone());
            stmt.setString(5, chain.getAddress());
            stmt.setString(6, chain.getCity());
            stmt.setString(7, chain.getName());

            int output = stmt.executeUpdate();
            System.out.println(output);

            stmt.close();
            db.close();
        } catch (Exception e) {
            message = "Error while inserting chain" + e.getMessage();
        } finally {
            if (con != null) {
                con.close();
            }
            if (message.equals("")) {
                message = "Chain successfully inserted";
            }
        }
        return message;
    }

    public String deleteChain(Integer id) throws Exception {
        Connection con = null;
        String message = "";

        // sql query
        String sql = "DELETE FROM hotel_chain WHERE chain_id = ?;";

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
            message = "Error while delete hotel chain: " + e.getMessage();
        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "Hotel Chain successfully deleted!";
        }

        return message;
    }

    public String updateChain(Chain chain) throws Exception {
        Connection con = null;
        String message = "";

        String sql = "UPDATE chain SET chain_id=?, number_of_hotels=?, email=?, phone=?, address=?, city=?, chain_name=? WHERE chain_id=?;";


        ConnectionDB db = new ConnectionDB();

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, chain.getId());
            stmt.setInt(2, chain.getNumHotels());
            stmt.setString(3, chain.getEmail());
            stmt.setBigDecimal(4, chain.getPhone());
            stmt.setString(5, chain.getAddress());
            stmt.setString(6, chain.getCity());
            stmt.setString(7, chain.getName());
            stmt.setInt(8, chain.getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (Exception e) {
            message = "Error while updating chain: " + e.getMessage();
        } finally {
            if (con != null) {
                con.close();
            }
            if (message.equals("")) {
                message = "Chain successfully updated";
            }
        }

        return message;
    }

}
