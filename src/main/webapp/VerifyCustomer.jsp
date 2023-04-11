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
    Integer ssn = Integer.valueOf(request.getParameter("customer_SSN"));


    Message msg;
    boolean worked = false;
    try {
        worked = true;
        CustomerService customerService = new CustomerService();

        List<Customer> customerList = customerService.getCustomers();

        boolean found = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getSSN().equals(ssn)) {
                found = true;
                session.setAttribute("customer_id", customerList.get(i).getId());
            }
        }

        if (found) {
            msg = new Message("Success", "User found and signing in");
            response.sendRedirect("Customer_Search_page.jsp");
        } else {
            msg = new Message("Error", "User does not exist");
            response.sendRedirect("index.jsp");
        }
    } catch (Exception e) {
        worked = false;
        e.printStackTrace();
        msg = new Message("Error", "Something went wrong with fetching customers");
    }

    ArrayList<Message> messages = new ArrayList<Message>();
    messages.add(msg);
    session.setAttribute("messages", messages);
    if (!worked) {
        response.sendRedirect("index.jsp");
    }

%>
