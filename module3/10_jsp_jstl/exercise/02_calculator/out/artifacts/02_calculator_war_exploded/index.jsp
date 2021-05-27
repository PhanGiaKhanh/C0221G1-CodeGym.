<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/27/2021
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>
    <link rel="stylesheet" href="Bootstrap4/bootstrap.min.css">

</head>
<body class="d-flex justify-content-center">
<form class="modal-sm border" action="calculation" method="get">
    <table class="table-dark table rounded">
        <thead>
        </thead>
        <tbody>
        <tr>
            <th>First operand:</th>
            <td class="form-group"><input type="number" class="rounded" name="first-number"></td>
        </tr>
        <tr>
            <th>Operator:</th>
            <td class="form-group">
                <select class="custom-select my-1 mr-sm-2" name="choose">x
                    <option value="add">Addition</option>
                    <option value="sub">Subtraction</option>
                    <option value="div">Division</option>
                    <option value="mut">Multiplication</option>
                </select>
            </td>
        </tr>
        <tr>
            <th>Second operand:</th>
            <td class="form-group"><input type="number" class="rounded" name="second-number"></td>
        </tr>
        <tr>
            <th></th>
            <td class="form-group"><input type="submit" class="rounded" value="Calculator"></td>
        </tr>
        </tbody>
    </table>
</form>

<script src="Bootstrap4/bootstrap.min.js"></script>
<script src="Bootstrap4/jquery-3.6.0.min.js"></script>
</body>
</html>
