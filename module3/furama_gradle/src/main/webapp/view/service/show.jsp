<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/30/2021
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <h2 class="text-white rounded bg-info px-5 py-3 mt-2">Customer information</h2>
            <form>
                <table class="table">
                    <tbody>
                    <tr>
                        <td>Id</td>
                        <td>${service.getId()} </td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td>${service.getName()} </td>
                    </tr>
                    <tr>
                        <td>Area</td>
                        <td>${service.getArea()} </td>
                    </tr>
                    <tr>
                        <td>Cost</td>
                        <td>${service.getCost()} </td>
                    </tr>
                    <tr>
                        <td>Max People</td>
                        <td>${service.getMaxPeople()} </td>
                    </tr>
                    <tr>
                        <td>Rent Type</td>
                        <td>
                            <c:forEach var="rent" items="${rentList}">--%>
                                <c:if test="${rent.id == service.getRentType()}">
                                    ${rent.name}
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <td>Service Type</td>
                        <td>
                            <c:forEach var="type" items="${typeList}">
                                <c:if test="${type.id == service.getServiceType()}">
                                    ${type.name}
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <td>Standard Roomn</td>
                        <td>${service.getStandardRoom()} </td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>${service.getDescription()} </td>
                    </tr>
                    <tr>
                        <td>Pool Area</td>
                        <td>${service.getPoolArea()} </td>
                    </tr>
                    <tr>
                        <td>Number Of Floor</td>
                        <td>${service.getNumberOfFloor()} </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="text-right"><a href="/services" class="btn btn-secondary">Close</a></td>
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
