<%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 4/7/2023
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.DB_Project.Employee"%>
<%@ page import="com.DB_Project.EmployeeService" %>
<%@ page import="com.DB_Project.Message" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%
    Integer id = Integer.valueOf(request.getParameter("employee_id"));
    Integer ssn = Integer.valueOf(request.getParameter("employee_SSN"));

    Message msg;
    boolean worked = false;
    try {
        worked = true;
        EmployeeService employeeService = new EmployeeService();

        List<Employee> employeeList = employeeService.getEmployees();

        boolean found = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id) && employeeList.get(i).getSSN().equals(ssn)) {
                found = true;
                session.setAttribute("employee_id", employeeList.get(i).getId());
            }
        }
        if (found) {
            msg = new Message("Success", "Employee found and signing in");
            response.sendRedirect("Employee_Management.jsp");
        } else {
            msg = new Message("Error", "Employee does not exist");
        }
    } catch (Exception e) {
        worked = false;
        e.printStackTrace();
        msg = new Message("Error", "Something went wrong with fetching employees");
    }

    ArrayList<Message> messages = new ArrayList<Message>();
    messages.add(msg);
    session.setAttribute("messages", messages);
    if (!worked) {
        response.sendRedirect("index.jsp");
    }

%>
