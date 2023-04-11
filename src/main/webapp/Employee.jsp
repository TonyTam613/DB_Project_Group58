<%--
  Created by IntelliJ IDEA.
  User: sijibomiadaramaja
  Date: 2023-04-03
  Time: 10:20 a.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee bookings</title>
    <link rel = "stylesheet" href="Style.css">
</head>

<body id="employee">
    <header>
        <h2>Hello Employee!</h2>

        <a href="index.jsp">Go back to home page</a>

    </header>



    <div class="wrapper">
        <div class="form-box login">
            <h2>Login</h2>
            <form action = "VerifyEmployee.jsp">
                <div class="input-box">
                    <span class="icon"></span>
                    <input name="employee_SSN" id="employee_SSN" type="SIN/SSN" required>
                    <label for="employee_SSN">SIN/SSN</label>
                </div>
                <div class="input-box">
                    <span class="icon"></span>
                    <input name="employee_id" id="employee_id" type="employee_id" required>
                    <label for="employee_id">EMPLOYEE_ID</label>
                </div>
                <button type="submit" class="btn">LOGIN</button>
            </form>
        </div>
    </div>
</body>
</html>
