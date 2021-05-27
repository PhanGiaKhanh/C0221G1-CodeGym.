<%@ page import="java.util.List" %>
<%@ page import="customer.Customer" %>
<%@ page import="customer.ClassNew" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/26/2021
  Time: 3:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="Bootstrap4/bootstrap.min.css">
</head>
<body>
<%--<%--%>
<%--    List<Customer> list = ClassNew.add();--%>
<%--    request.setAttribute("customers1", list);--%>
<%--%>--%>
<div class="container   ">
    <table class="table" border="1">
        <thead>
        <tr>
            <th scope="col">STT</th>
            <th scope="col">Tên</th>
            <th scope="col">Ngày Sinh</th>
            <th scope="col">Địa Chỉ</th>
            <th scope="col">Hình Ảnh</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}"  var="customer" varStatus="loop">
            <tr>
                <th>${loop.count}</th>
                <td>${customer.name}</td>
                <td>${customer.dayOfBirth}</td>
                <td>${customer.address}</td>
                <td><img src="${customer.img}" alt="" height="100"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
