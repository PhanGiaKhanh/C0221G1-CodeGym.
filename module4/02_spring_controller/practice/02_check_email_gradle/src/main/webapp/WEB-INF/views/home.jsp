<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/12/2021
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check Email</title>
</head>
<body>
<h1>Email Validate</h1>
<h3 style="color:${!message.contains('invalid') ? "blue":"red"}">${message}</h3>

<form action="validate" method="post">
    <input type="text" name="email" value="${email}"><br>
    <input type="submit" value="Validate">
</form>

<c:if test="${!message.contains('invalid') }">
<h2 style="color: greenyellow">Hi ${email}</h2>
</c:if>
</body>
</html>
