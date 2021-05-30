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
        <td>${product.getId()}</td>
    </tr>
    <tr>
        <td>Name: </td>
        <td>${product.getNameP()}</td>
    </tr>
    <tr>
        <td>Price: </td>
        <td>${product.getPriceP()}</td>
    </tr>
    <tr>
        <td>Description: </td>
        <td>${product.getDescriptionP()}</td>
    </tr>
    <tr>
        <td>Manufacturer: </td>
        <td>${product.getManufacturer()}</td>
    </tr>
</table>
</body>
</html>
