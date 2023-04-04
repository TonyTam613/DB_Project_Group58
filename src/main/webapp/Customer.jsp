<%--
  Created by IntelliJ IDEA.
  User: sijibomiadaramaja
  Date: 2023-04-03
  Time: 10:02 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee bookings</title>
    <link rel = "stylesheet" href="Style.css">
</head>

<body id="customer">
<header>
    <h2>Hello Customer!</h2>

    <a href="index.jsp">Go back to home page</a>

</header>



<div class="wrapper">
    <div class="form-box login">
        <h2>Login</h2>
        <form action = "#">
            <div class="input-box">
                <span class="icon"></span>
                <input type="SIN/SSN" required>
                <label>SIN/SSN</label>
            </div>
            <div class="input-box">
                <span class="icon"></span>
                <input type="NAME" required>
                <label>NAME</label>
            </div>
            <div class="input-box">
                <span class="icon"></span>
                <input type="email" required>
                <label>Email</label>
            </div>
            <div class="input-box">
                <span class="icon"></span>
                <input type="Address" required>
                <label>Address</label>
            </div>
            <div class="input-box">
                <span class="icon"></span>
                <input type="Date" required>
                <label>Date</label>
            </div>
            <button type="submit" class="btn">LOGIN</button>
        </form>
    </div>
</div>
</body>
</html>
