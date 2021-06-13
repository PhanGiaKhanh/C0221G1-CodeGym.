<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/13/2021
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
    <link rel="stylesheet" href="../lib/bootstrap.min.css">
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save" method="post" class="form-group">
    <input class="form-control" type="checkbox" name="condiment" value="lettuce"><b>Lettuce</b>
    <input class="form-control" type="checkbox" name="condiment" value="tomate"><b>Tomate</b>
    <input class="form-control" type="checkbox" name="condiment" value="mustard"><b>Mustard</b>
    <input class="form-control" type="checkbox" name="condiment" value="sprouts"><b>Sprouts</b>
    <hr>
    <input type="submit" value="Save" class="btn btn-primary">
</form>

<h1>${result}</h1>
</body>
</html>
