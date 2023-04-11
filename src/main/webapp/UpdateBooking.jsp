<%@ page import="java.sql.Date" %>
<%@ page import="com.DB_Project.Booking" %>
<%@ page import="com.DB_Project.BookingService" %>
<%@ page import="com.DB_Project.Message" %><%--
  Created by IntelliJ IDEA.
  User: Tony
  Date: 4/10/2023
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    Integer bookingId = Integer.parseInt(request.getParameter("booking_id"));
    String status = request.getParameter("booking_status");
    Integer employeeId = (Integer) session.getAttribute("employee_id");

    Message msg;
    boolean worked = false;
    try {
        worked = true;

        Booking newBooking = new Booking(bookingId, employeeId, status);

        BookingService bookingService = new BookingService();
        bookingService.empUpdateBooking(newBooking);
        msg = new Message("Success", "updated booking");

    } catch (Exception e) {
        worked = false;
        e.printStackTrace();
        msg = new Message("Error", "Couldn't update booking");
    }

    response.sendRedirect("index.jsp");

%>
