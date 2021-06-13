<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/12/2021
  Time: 8:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Translate</title>
</head>
<body>
<h1>Translate</h1>
<form action="translate" method="post">
<%--    <input type="text" placeholder="Vietnamese" name="vn"> :--%>
    <input type="text" placeholder="English" name="eng">
    <input type="submit" value="translate">
</form>
<h1>${vn}</h1>
</body>
</html>
