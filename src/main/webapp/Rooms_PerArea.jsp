<%@ page import="com.DB_Project.AvailableRooms" %>
<%@ page import="com.DB_Project.AvailableRoomsService" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    AvailableRoomsService availableRoomsService = new AvailableRoomsService();
    List<AvailableRooms> view = availableRoomsService.getARView();
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewpoint" content="width=device-width, initial-scale=1.0">
    <title>Hotel bookings</title>
    <link rel = "stylesheet" href="Style.css">
</head>


<body class = "Room_Capacity_PerHotel">
<header>
    <h2>Room capacity per area!</h2>
    <nav class = "navigations">
        <a href="index.jsp">Go back to home page</a>
        <a href="Rooms_PerArea.jsp">Rooms per area</a>
        <a href="Room_Capacity_PerHotel.jsp">Capacity per hotel</a>
        <a href="Customer_Search_page.jsp">Back </a>
    </nav>

</header>

<table bgcolor="black" width="900">
    <tr bgcolor="#add8e6">
        <th>Available Rooms</th>
        <th>Location</th>

    </tr>
    <% for (AvailableRooms rooms : view) { %>
        <tr bgcolor="#d3d3d3" align="center">
            <td><%=rooms.getAvailableRooms()%></td>
            <td><%=rooms.getArea()%></td>

        </tr>
    <% } %>
</table>

</body>