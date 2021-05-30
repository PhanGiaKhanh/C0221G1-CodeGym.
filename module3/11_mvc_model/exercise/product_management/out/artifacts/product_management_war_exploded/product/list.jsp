<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/28/2021
  Time: 4:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List product</title>
</head>
<body>
<h1>Product</h1>
<p>
<form action="/Products?action=search" method="post">
    <input type="search" name="name" placeholder="search name">
    <input type="submit" value="Search">
</form>

</p>
<p>
    <a href="Products?action=create">Create new product</a>
</p>
<table border="1">
    <tr>
        <td>Id</td>
        <td>Name product</td>
        <td>Price product</td>
        <td>Description</td>
        <td>Manufacturer</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${products}' var="product">
        <tr>
            <td><a href="/Products?action=view&id=${product.getId()}">${product.getId()}</a></td>
            <td>${product.getNameP()}</td>
            <td>${product.getPriceP()}</td>
            <td>${product.getDescriptionP()}</td>
            <td>${product.getManufacturer()}</td>
            <td><a href="/Products?action=edit&id=${product.getId()}">edit</a></td>
            <td><a href="/Products?action=delete&id=${product.getId()}">delete</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
