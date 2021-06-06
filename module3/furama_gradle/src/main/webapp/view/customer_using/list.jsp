<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/30/2021
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List</title>

    <link rel="stylesheet" href="../../bootstrap4/bootstrap.min.css">
    <link rel="stylesheet" href="../../bootstrap4/dataTables.bootstrap.min.css">

</head>
<body class="m-2">

<!--#region header-->
<nav class="navbar navbar-light bg-light border border-info ">
    <div class="navbar-brand mb-0 h1 d-flex align-items-center">
        <img class="ml-3 rounded shadow-lg" src="img/logo3.jpg" height="50" width="50"/>
        <div class="ml-2">Furama</div>
    </div>
    <div class="navbar-brand h1 text-info"><h1>Customer using list</h1></div>
    <div class="navbar-brand mb-0 h1">Nguyễn Văn A</div>
</nav>
<!--#endregion-->
<jsp:include page="../../common/hearder.jsp"/>

<!--#region header-->
<div class="container-fluid">
    <div class="row">
        <div class="col-3 p-0">
<%--            <a href="/customer-using?action=create" class="btn btn-primary"><span--%>
<%--                    style="font-size: larger; font-weight: bolder">+</span>--%>
<%--                Create new Employee--%>
<%--            </a>--%>
        </div>
        <div class="col-6">
            <span class="text-success">${message}</span>
        </div>
        <div class="col-3 p-0">
            <form action="/customer-using?action=search" method="post" class="d-flex justify-content-end">
                <input class="form-control" type="search" placeholder="Search name" aria-label="Search"
                       name="search">
                <button class="btn btn-primary  my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </div>
</div>
<!--#endregion-->
<%--id="tableCustomer" class="table table-striped table-bordered "--%>
<!--#region table-->
<table class="table table-hover my-2" id="tableCustomer">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Contract id</th>
        <th scope="col">Start date</th>
        <th scope="col">End date</th>
        <th scope="col">Name</th>
        <th scope="col">Phone</th>
        <th scope="col">Service name</th>
        <th scope="col">Cost</th>
        <th scope="col">Service</th>
        <th scope="col">Attach service</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customerUsings}">
        <tr>
            <th>${customer.contractId}</th>
            <td>${customer.startDate}</td>
            <td>${customer.endDate}</td>
            <td>${customer.name}</td>
            <td>${customer.phone}</td>
            <td>${customer.serviceName}</td>
            <td>${customer.cost}</td>
            <td style="width: 5%" class="d-flex">
                <a href="/contracts?action=edit&id=${customer.contractId}" class="btn btn-warning mr-1">Edit</a>
                <!-- Button trigger modal DELETE -->
                <button onclick="myFunction(${customer.contractId})" type="button"
                        class="click-del btn btn-danger btnDisplay"
                        data-toggle="modal" data-target="#delete">
                    Delete
                </button>
                <!-- Modal -->
                <div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-body fborder border-secondary rounded" class="text">
                                Do you want customer?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <form action="/contracts?action=delete" method="post">
                                    <button type="submit" class="btn btn-danger">Delete</button>
                                    <input type="hidden" id="button-del" name="idDel">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!--end model-->
            </td>
            <td style="width: 5%">
                <ul class="nav nav-pills">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button"
                           aria-haspopup="true" aria-expanded="false">Attach</a>
                        <div class="dropdown-menu">
                            <c:forEach items="${contractDetails}" var="detail">
                                <c:if test="${customer.contractId == detail.contractId}">
                                    <c:forEach items="${attachServices}" var="attach">
                                        <c:if test="${detail.attachServiceID == attach.id}">
                                            <a class="dropdown-item" href="#">${attach.name} - Số
                                                lương: ${detail.quantity}</a>
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </c:forEach>
                        </div>
                    </li>
                </ul>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<!--#endregion-->

<!--#region javascript-->

<script src="../../bootstrap4/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap4/popper.min.js"></script>
<script src="../../bootstrap4/bootstrap.min.js"></script>
<script src="../../bootstrap4/jquery.dataTables.min.js"></script>
<script src="../../bootstrap4/dataTables.bootstrap4.min.js"></script>
<!--#endregion-->

<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 5,
        });
    });

    function myFunction(id) {
        document.getElementById("button-del").value = id;
    }
</script>
</body>
</html>
