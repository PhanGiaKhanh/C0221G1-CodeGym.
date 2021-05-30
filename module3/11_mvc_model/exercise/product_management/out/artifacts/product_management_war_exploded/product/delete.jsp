<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting product</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/Products">Back to customer list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Product information</legend>
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
            <tr>
                <td><input type="submit" value="Delete product"></td>
            </tr>
        </table>
    </fieldset>
</body>
</html>