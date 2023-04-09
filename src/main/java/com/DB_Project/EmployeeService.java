package com.DB_Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public List<Employee> getEmployees() throws Exception {
        String sql = "SELECT * FROM employee;";

        ConnectionDB db = new ConnectionDB();

        List<Employee> employees = new ArrayList<Employee>();

        try (Connection con = db.getConnection()) {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("employee_name"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getInt("SSN")
                );

                employees.add(employee);

            }

            rs.close();
            stmt.close();
            con.close();
            db.close();

            return employees;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public String createEmployee(Employee employee) throws Exception {
        String message = "";
        Connection con = null;

        ConnectionDB db = new ConnectionDB();
        System.out.println(employee.getId());

        String insertEmployeeQuery = "INSERT INTO employee (employee_id, employee_name, address, city, SSN) VALUES (?, ?, ?, ?, ?);";

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(insertEmployeeQuery);

            stmt.setInt(1, employee.getId());
            stmt.setString(2, employee.getName());
            stmt.setString(3, employee.getAddress());
            stmt.setString(4, employee.getCity());
            stmt.setInt(5, employee.getSSN());

            int output = stmt.executeUpdate();
            System.out.println(output);

            stmt.close();
            db.close();
        } catch (Exception e) {
            message = "Error while inserting employee" + e.getMessage();
        } finally {
            if (con != null) {
                con.close();
            }
            if (message.equals("")) {
                message = "Employee successfully inserted";
            }
        }
        return message;
    }

    public String deleteEmployee(Integer id) throws Exception {
        Connection con = null;
        String message = "";

        // sql query
        String sql = "DELETE FROM employee WHERE employee_id = ?;";

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
            message = "Error while delete employee: " + e.getMessage();
        } finally {
            if (con != null) con.close();
            if (message.equals("")) message = "Employee successfully deleted!";
        }

        return message;
    }

    public String updateEmployee(Employee employee) throws Exception {
        Connection con = null;
        String message = "";

        String sql = "UPDATE employee SET employee_id=?, employee_name=?, address=?, city=?, SSN=? WHERE employee_id=?;";


        ConnectionDB db = new ConnectionDB();

        try {
            con = db.getConnection();

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, employee.getId());
            stmt.setString(2, employee.getName());
            stmt.setString(3, employee.getAddress());
            stmt.setString(4, employee.getCity());
            stmt.setInt(5, employee.getSSN());
            stmt.setInt(6, employee.getId());

            stmt.executeUpdate();
            stmt.close();

        } catch (Exception e) {
            message = "Error while updating employee: " + e.getMessage();
        } finally {
            if (con != null) {
                con.close();
            }
            if (message.equals("")) {
                message = "Employee successfully updated";
            }
        }
        return message;
    }

}
