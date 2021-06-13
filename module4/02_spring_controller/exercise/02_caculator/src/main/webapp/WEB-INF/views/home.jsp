<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/13/2021
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link rel="stylesheet" href="../lib/bootstrap.min.css">
</head>
<body>
<h1>Calculator</h1>
<form method="post">
    <input type="number" placeholder="number one" name="num1">
    <input type="number" placeholder="number two" name="num2">
    <br>
    <button type="submit" value="+" name="calculation">Addition(+)</button>
    <button type="submit" value="-" name="calculation">Subtraction(-)</button>
    <button type="submit" value="*" name="calculation">Multiplication(*)</button>
    <button type="submit" value="/" name="calculation">Division(/)</button>
</form>
<h1>${result}</h1>
</body>
</html>
