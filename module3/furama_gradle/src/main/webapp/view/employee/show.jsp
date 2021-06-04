<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/30/2021
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Show customer</title>
    <link rel="stylesheet" href="../../bootstrap4/bootstrap.min.css">
    <style>
        td:first-child {
            width: 24%;
        }

        .fborder {
            box-shadow: 5px 5px #657373;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row mt-1">
        <div class="col-3"></div>
        <div class="col-6 fborder border-secondary rounded">
            <h2 class="text-white rounded bg-info px-5 py-3 mt-2">Employee information</h2>
            <form>
                <table class="table">
                    <tbody>
                    <tr>
                        <td>STT</td>
                        <td>${employee.getId()} </td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td>${employee.getName()} </td>
                    </tr>
                    <tr>
                        <td>Birthday</td>
                        <td>${employee.getBirthday()} </td>
                    </tr>
                    <tr>
                        <td>Id card</td>
                        <td>${employee.getIdCard()} </td>
                    </tr>
                    <tr>
                        <td>Salary</td>
                        <td>${employee.getSalary()} </td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td>${employee.getPhone()} </td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>${employee.getEmail()} </td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td>${employee.getAddress()} </td>
                    </tr>
                    <tr>
                        <td>Position</td>
                        <td>
                            <c:forEach items="${positions}" var="position">
                                <c:if test="${position.getId() == employee.getIdPosition()}">
                                    ${position.getName()}
                                </c:if>
                            </c:forEach></td>
                    </tr>
                    <tr>
                        <td>Degree</td>
                        <td>
                            <c:forEach items="${degrees}" var="degree">
                                <c:if test="${degree.getId() == employee.getIdDegree()}">
                                    ${degree.getName()}
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <td>Division</td>
                        <td>
                            <c:forEach items="${divisions}" var="division">
                                <c:if test="${division.getId() == employee.getIdDivision()}">
                                    ${division.getName()}
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="text-right"><a href="/employees" class="btn btn-secondary">Close</a></td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <div class="col-3"></div>
    </div>
</div>
<!--#region javascript-->

<script src="../../bootstrap4/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap4/popper.min.js"></script>
<script src="../../bootstrap4/bootstrap.min.js"></script>
<!--#endregion-->
</body>
</html>
