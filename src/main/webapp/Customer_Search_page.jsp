<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.DB_Project.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<%

    List<Room> results = null;
    results = (ArrayList<Room>) session.getAttribute("filteredRooms");
    session.setAttribute("filteredRooms", null);
%>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewpoint" content="width=device-width, initial-scale=1.0">
    <title>Hotel bookings</title>
    <link rel = "stylesheet" href="Style.css">
</head>


<body class ="Customer_Search_page">
    <header>
        <h2>Search for the best hotels and rooms here!</h2>
        <nav class = "navigations">
            <a href="index.jsp">Go back to home page</a>
            <a href="Rooms_PerArea.jsp">Rooms per area</a>
            <a href="Room_Capacity_PerHotel.jsp">Capacity per hotel</a>
            <a href="Customer.jsp">Back </a>
        </nav>

    </header>

    <div class = "container">
        <form name="search_form" action="RoomSearch.jsp" method="POST">
            <div class = "search_wrap search_wrap_1">
                <div class = "search_box">
                    <input name="search_hotel" type ="text" class="input" placeholder="Hotel">

                </div>
            </div>
            <div class = "search_wrap search_wrap_2">
                <div class = "search_box">

                    <input name="search_price" type ="text" class="input" placeholder="Maximum price">

                </div>
            </div>
            <div class = "search_wrap search_wrap_3">
                <div class = "search_box">

                    <input name="search_capacity" type ="text" class="input" placeholder="Capacity">

                </div>
            </div>

            <div class = "search_wrap search_wrap_4">
                <div class = "search_box">

                    <input name="search_view" type ="text" class="input" placeholder="View">

                </div>

                <div class = "search_wrap search_wrap_3">
                    <div class = "search_box">

                        <input name="search_location" type ="text" class="input" placeholder="Area">

                    </div>
                </div>

                <button type="submit" class="btn">Search</button>
            </div>
        </form>
    </div>


</body>
</html>