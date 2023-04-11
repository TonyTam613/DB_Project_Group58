
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewpoint" content="width=device-width, initial-scale=1.0">
    <title>Hotel bookings</title>
    <link rel = "stylesheet" href="Style.css">
</head>


<body class ="Employee_Management">
    <header>
        <h2>Book and monitor hotel and room bookings here!</h2>

        <a href="Employee.jsp">Back</a>
    </header>

    <div class = "wrapper">
        <div class = form-box login>
            <h2>Login</h2>
            <form action = "UpdateBooking.jsp">
                <div class="input-box">
                    <span class="icon"></span>
                    <input name="booking_id" type="Booking_ID" required>
                    <label>Booking_ID</label>
                </div>
                <div class="input-box">
                    <span class="icon"></span>
                    <input name="booking_status" type="Booking Status" required>
                    <label>Booking Status</label>
                </div>
                <button type="submit" class="btn">Change Status</button>
        </div>

    </div>



</body>
</html>