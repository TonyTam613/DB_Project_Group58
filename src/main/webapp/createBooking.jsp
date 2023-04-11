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
    Integer roomId = Integer.parseInt(request.getParameter("room_id"));
    Date startDate = Date.valueOf(request.getParameter("start_date"));
    Date endDate = Date.valueOf(request.getParameter("end_date"));
    Integer customerId = (Integer) session.getAttribute("customer_id");

    Message msg;
    boolean worked = false;
    try {
        worked = true;

        Booking newBooking = new Booking(roomId, customerId, startDate, endDate, "booking");

        BookingService bookingService = new BookingService();
        bookingService.createBookingNoEmp(newBooking);
        msg = new Message("Success", "made new booking");

    } catch (Exception e) {
        worked = false;
        e.printStackTrace();
        msg = new Message("Error", "Couldn't make booking");
    }

    response.sendRedirect("index.jsp");

%>
