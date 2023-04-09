package com.DB_Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    public List<Customer> getCustomers() throws Exception {
        String sql = "SELECT * FROM customer;";

        ConnectionDB db = new ConnectionDB();

        List<Customer> customers = new ArrayList<Customer>();

        try (Connection con = db.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getInt("customer_id"),
                        rs.getString("customer_name"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getInt("SSN"),
                        rs.getDate("date_of_registration")
                );

                customers.add(customer);

            }

            rs.close();
            stmt.close();
            con.close();
            db.close();

            return customers;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String createCustomer(Customer customer) throws Exception {
        String message = "";
        Connection con = null;

        ConnectionDB db = new ConnectionDB();
        System.out.println(customer.getId());

        String insertCustomerQuery = "INSERT INTO customer (customer_id, customer_name, address, city, SSN, date_of_registration) VALUES (?, ?, ?, ?, ?, ?);";

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(insertCustomerQuery);

            stmt.setInt(1, customer.getId());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getAddress());
            stmt.setString(4, customer.getCity());
            stmt.setInt(5, customer.getSSN());
            stmt.setDate(6, customer.getDOR());

            int output = stmt.executeUpdate();
            System.out.println(output);

            stmt.close();
            db.close();
        } catch (Exception e) {
            message = "Error while inserting customer" + e.getMessage();
        } finally {
            if (con != null) {
                con.close();
            }
            if (message.equals("")) {
                message = "Customer successfully inserted";
            }
        }
        return message;
    }

    public String deleteCustomer(Integer id) throws Exception {
        Connection con = null;
        String message = "";

        // sql query
        String sql = "DELETE FROM customer WHERE customer_id = ?;";

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
            message = "Error while delete customer: " + e.getMessage();
        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "Customer successfully deleted!";
        }

        return message;
    }

    public String updateCustomer(Customer customer) throws Exception {
        Connection con = null;
        String message = "";

        String sql = "UPDATE customer SET customer_id=?, customer_name=?, address=?, city=?, SSN=?, date_of_registration=? WHERE customer_id=?;";


        ConnectionDB db = new ConnectionDB();

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, customer.getId());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getAddress());
            stmt.setString(4, customer.getCity());
            stmt.setInt(5, customer.getSSN());
            stmt.setDate(6, customer.getDOR());
            stmt.setInt(7, customer.getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (Exception e) {
            message = "Error while updating customer: " + e.getMessage();
        } finally {
            if (con != null) {
                con.close();
            }
            if (message.equals("")) {
                message = "customer successfully updated";
            }
        }
        return message;
    }
}
