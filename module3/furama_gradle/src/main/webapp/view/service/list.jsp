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
    <div class="navbar-brand h1 text-info"><h1>Services list</h1> </div>
    <div class="navbar-brand mb-0 h1">Nguyễn Văn A</div>
</nav>
<!--#endregion-->
<!--#region menu-->
<nav class="navbar navbar-expand-lg navbar-dark bg-success my-2 px-5 border border-info  sticky-top">
    <a class="navbar-brand mx-5" href="http://localhost:8080">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item mr-5">
                <a class="navbar-brand mr-0" href="#">Employee <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item  mr-5">
                <a class="navbar-brand mr-0" href="/customers">Customer <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item mr-5 ">
                <a class="navbar-brand mr-0" href="/services">Service <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item mr-5 ">
                <a class="navbar-brand mr-0" href="#">Contract <span class="sr-only">(current)</span></a>
            </li>
        </ul>
        <form action="/customers?action=search" method="post" class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search name" aria-label="Search" name="search">
            <button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<!--#endregion-->
<!--#region header-->
<div class="container-fluid">
    <div class="row">
        <div class="col-3">
            <a href="/customers?action=create" class="btn btn-primary"><span
                    style="font-size: larger; font-weight: bolder">+</span>
                Create new customer
            </a>
        </div>
        <div class="col-6">
              <span class="text-success">${message}</span>
        </div>
        <div class="col-3 text-right">
<%--            <form action="/customers?action=search" method="post" class="d-flex">--%>
<%--                <input type="search" class="form-control" placeholder="Search name" name="search">--%>
<%--                <button type="submit" class="btn btn-primary">Search</button>--%>
<%--            </form>--%>
        </div>
    </div>
</div>
<!--#endregion-->
<%--id="tableCustomer" class="table table-striped table-bordered "--%>
<!--#region table-->
<table class="table table-hover my-2" id="tableCustomer">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Area</th>
        <th scope="col">Cost</th>
        <th scope="col">Max people</th>
        <th scope="col">Rent Type</th>
        <th scope="col">Service Type</th>
        <th scope="col">Standard Room</th>
        <th scope="col">Description</th>
        <th scope="col">Pool Area</th>
        <th scope="col">Number Of Floor</th>
        <th scope="col">Show</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="service" items="${services}">
        <tr>
            <th>${service.getId()}</th>
            <td>${service.getName()}</td>
            <td>${service.getArea()}</td>
            <td>${service.getCost()}</td>
            <td>${service.getMaxPeople()}</td>
            <td>${service.getRentType()}</td>
            <td>${service.getServiceType()}</td>
            <td>${service.getStandardRoom()}</td>
            <td>${service.getDescription()}</td>
            <td>${service.getPoolArea()}</td>
            <td>${service.getNumberOfFloor()}</td>

            <td style="width: 5%">
                <a href="/services?action=show&id=${service.getId()}" type="button" class="btn btn-info">Show</a>
            </td>
            <td style="width: 5%">
                <a href="/services?action=edit&id=${service.getId()}" type="button" class="btn btn-warning">
                    Edit
                </a>
            </td>
            <td style="width: 5%">
                <!-- Button trigger modal DELETE -->
                <button  onclick="myFunction(${service.getId()})" type="button" class="click-del btn btn-danger" data-toggle="modal" data-target="#delete">
                    Delete
                </button>
                <!-- Modal -->
                <div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-body fborder border-secondary rounded" class="text">
<%--                                    ${customer.getId()}--%>
<%--                                 Bạn có muốn xóa :   ${customer.getC_name()}--%>
                                 Do you want customer?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <form action="/customers?action=delete" method="post">
                                    <button type="submit" class="btn btn-danger">Delete</button>
                                    <input type="hidden" id="button-del" name="idDel">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!--end model-->
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