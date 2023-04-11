<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.DB_Project.*" %>

<%
    List<Room> rooms = (ArrayList<Room>) session.getAttribute("filteredRooms");
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewpoint" content="width=device-width, initial-scale=1.0">
    <title>Hotel bookings</title>
    <link rel = "stylesheet" href="Style.css">
</head>

<body class = "Selection">
<header>
    <h2>SEARCH RESULT!</h2>
    <nav class = "navigations">
        <a href="index.jsp">Go back to home page</a>
        <a href="Rooms_PerArea.jsp">Rooms per area</a>
        <a href="Room_Capacity_PerHotel.jsp">Capacity per hotel</a>
        <a href="Customer_Search_page.jsp">Back </a>
    </nav>

</header>

<table style="position: absolute; top: 100px;" bgcolor="black" width="900">
    <tr bgcolor="#add8e6">
        <th>Room ID</th>
        <th>Capacity</th>
        <th>Price($)</th>
        <th>Availability</th>

    </tr>

    <% for (Room room : rooms) { %>
        <tr bgcolor="#d3d3d3" align="center">
            <form action="Booking.jsp" method="POST">
                <td><%=room.getId().intValue()%></td>
                <input name="selected_room_id" value="<%=room.getId().intValue()%>" hidden>
                <td><%=room.getCapacity().intValue()%></td>
                <td><%=room.getPrice().toString()%></td>
                <td>  <a href= "Booking.jsp">
                    <button type="submit"  class="btn">Book</button>
                </a>
                </td>
            </form>
        </tr>
    <% } %>

</table>

</body>