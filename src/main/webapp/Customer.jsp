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
    <title>Customer Page</title>
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
        <form name="customer-form" action = "VerifyCustomer.jsp" method="POST">
            <div class="input-box">
                <span class="icon"></span>
                <input id="customer_SSN" name="customer_SSN" type="SIN/SSN" required>
                <label for="customer_SSN" >SIN/SSN</label>
            </div>
            <button type="submit" class="btn">LOGIN</button>
        </form>
    </div>
</div>
</body>
</html>
