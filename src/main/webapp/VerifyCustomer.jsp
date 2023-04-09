<%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 4/7/2023
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.DB_Project.Customer"%>
<%@ page import="com.DB_Project.CustomerService" %>
<%@ page import="com.DB_Project.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%
    Integer id = Integer.valueOf(request.getParameter("id"));

    Message msg;
    boolean worked = false;
    try {
        worked = true;
        CustomerService customerService = new CustomerService();

        List<Customer> customerList = customerService.getCustomers();

        boolean found = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == id) {
                found = true;
            }
        }
        msg = new Message("Success", "User found and signing in");
        if (found) {
            response.sendRedirect("booking.jsp");
        } else {
            response.sendRedirect("signup.jsp");
        }
    } catch (Exception e) {
        worked = false;
        e.printStackTrace();
        msg = new Message("Error", "Something went wrong with fetching customers");
    }

    ArrayList<Message> messages = new ArrayList<Message>();
    messages.add(msg);
    if (!worked) {
        response.sendRedirect("index.jsp");
    }

%>
