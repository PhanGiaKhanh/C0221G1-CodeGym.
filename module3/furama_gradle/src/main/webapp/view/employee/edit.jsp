<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/30/2021
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit customer</title>
    <link rel="stylesheet" href="../../bootstrap4/bootstrap.min.css">
    <style>
        td:first-child {
            width: 24%;
            line-height: 40px;
        }

        td {
            padding: 5px !important;
        }

        input {
            box-shadow: 1px 1px #637fff;
        }

        .fborder {
            box-shadow: 4px 4px #6c757d;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row mt-4">
        <div class="col-3"></div>
        <div class="col-6 fborder border-secondary rounded">
            <h2 class="text-white rounded bg-info px-5 py-2 mt-2">Edit employee <sup><a href="/employees"
                                                                                        class="text-primary">x</a></sup>
            </h2>
            <p>
                <span class="text-success">${message}</span>
            </p>
            <form method="post">
                <table class="table table-borderless">
                    <tbody>
                    <tr>
                        <td>Id</td>
                        <td>
                            <lable name="id">${employee.getId()}</lable>
                        </td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td><input class="form-control" type="text" value="${employee.getName()}" name="name"></td>
                    </tr>
                    <tr>
                        <td>Birthday</td>
                        <td><input class="form-control" type="text" value="${employee.getBirthday()}" name="birthday">
                        </td>
                    </tr>
                    <tr>
                        <td>Id card</td>
                        <td><input class="form-control" type="number" value="${employee.getIdCard()}" name="card"></td>
                    </tr>
                    <tr>
                        <td>Salary</td>
                        <td><input class="form-control" type="number" value="${employee.getSalary()}" name="salary"></td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td><input class="form-control" type="number" value="${employee.getPhone()}" name="phone"></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input class="form-control" type="email" value="${employee.getEmail()}" name="email"></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><input class="form-control" type="text" value="${employee.getAddress()}" name="address"></td>
                    </tr>
                    <tr>
                        <td>Position</td>
                        <td>
                            <select class="form-control" name="position" id="typeCustomer">
                                <c:forEach items="${positions}" var="position">
                                    <c:choose>
                                        <c:when test="${position.getId() == employee.getIdPosition()}">
                                            <option value="${position.getId()}" selected>${position.getName()}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${position.getId()}">${position.getName()}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Degree</td>
                        <td>
                            <select name="degree" id="">
                                <c:forEach items="${degrees}" var="degree">
                                    <c:choose>
                                        <c:when test="${degree.getId() == employee.getIdDegree()}">
                                            <option value="${degree.getId()}" selected>${degree.getName()}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${degree.getId()}">${degree.getName()}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Division</td>
                        <td>
                            <select class="form-control" name="division">
                                <c:forEach items="${divisions}" var="division">
                                    <c:choose>
                                        <c:when test="${division.getId() == employee.getIdDivision()}">
                                            <option value="${division.getId()}" selected>${division.getName()}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${division.getId()}">${division.getName()}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>User Name</td>
                        <td><input class="form-control" type="text" value="${employee.getUserName()}" name="user">
                        </td>
                    </tr>
                    <tr>
                        <td><a href="/employees" class="btn btn-secondary">Close</a></td>
                        <td class="text-right"><input type="submit" value="Edit" class="btn btn-warning"></td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <div class="col-3"></div>
    </div>
</div>


<script src="../../bootstrap4/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap4/popper.min.js"></script>
<script src="../../bootstrap4/bootstrap.min.js"></script>
</body>
</html>
