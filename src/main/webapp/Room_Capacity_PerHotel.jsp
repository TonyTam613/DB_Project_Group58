<%@ page import="java.util.List" %>
<%@ page import="com.DB_Project.CapacityHotel" %>
<%@ page import="com.DB_Project.CapacityHotelService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    CapacityHotelService capacityHotelService = new CapacityHotelService();
    List<CapacityHotel> view = capacityHotelService.getCHView();

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
        <h2>Room capacity per hotel!</h2>
        <nav class = "navigations">
            <a href="index.jsp">Go back to home page</a>
            <a href="Rooms_PerArea.jsp">Rooms per area</a>
            <a href="Room_Capacity_PerHotel.jsp">Capacity per hotel</a>
            <a href="Customer_Search_page.jsp">Back </a>
        </nav>

    </header>

    <table style="top: 100px; position: absolute;" bgcolor="black" width="900">
        <tr bgcolor="#add8e6">
            <th>Hotel ID</th>
            <th>Capacity</th>
        </tr>
        <% for (CapacityHotel viewEntry : view ) { %>
                <tr bgcolor="#d3d3d3" align="center">
                    <td><%=viewEntry.getHotel_id()%></td>
                    <td><%=viewEntry.getTotalCapacity()%></td>
                </tr>
        <% }%>

    </table>

</body>