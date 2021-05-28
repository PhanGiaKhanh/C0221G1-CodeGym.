<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>Product details</h1>
<p>
    <a href="/Products">Back to product list</a>
</p>
<table>
    <tr>
        <td>Id: </td>
        <td>${requestScope["product"].getId()}</td>
    </tr>
    <tr>
        <td>Name: </td>
        <td>${requestScope["product"].getNameP()}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${requestScope["product"].getPriceP()}</td>
    </tr>
    <tr>
        <td>Description: </td>
        <td>${requestScope["product"].getDescriptionP()}</td>
    </tr>
    <tr>
        <td>Manufacturer: </td>
        <td>${requestScope["product"].getManufacturer()}</td>
    </tr>
</table>
</body>
</html>
