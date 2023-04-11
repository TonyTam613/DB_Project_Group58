<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Integer room_id = Integer.parseInt(request.getParameter("selected_room_id"));
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
    <h2>SECURE YOUR ROOM HERE!</h2>
    <nav class = "navigations">
        <a href="index.jsp">Go back to home page</a>
        <a href="Rooms_PerArea.jsp">Rooms per area</a>
        <a href="Room_Capacity_PerHotel.jsp">Capacity per hotel</a>
        <a href="Selection.jsp">Back </a>
    </nav>

</header>

<div class="wrapper" >
    <div class="form-box login">
        <h2>BOOK HERE!</h2>
        <form action = "createBooking.jsp" method="POST">
            <div class="input-box">
                <span class="icon"></span>
                <input name="room_id" value="<%=room_id%>" required>
                <label>Booking ID</label>
            </div>
            <div class="input-box">
                <span class="icon"></span>
                <input name="start_date" id="startDate" onchange="setMin()" type="Date" required>
                <label>Start date</label>
            </div>
            <div class="input-box">
                <span class="icon"></span>
                <input name="end_date" id="endDate" type="Date" required>
                <label>End date</label>
            </div>
            <button type="submit" class="btn">BOOK</button>
        </form>
    </div>
</div>

<script>
    function setMin() {
        let startDate = document.getElementById("startDate").value;
        document.getElementById("endDate").setAttribute("min", startDate);
    }
</script>
</body>
</html>
