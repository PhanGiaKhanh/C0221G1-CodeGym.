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
    <style>
        .btnDisplay {
            /*display: block;*/
        }
    </style>
</head>
<body class="m-2">

<!--#region header-->
<nav class="navbar navbar-light bg-light border border-info ">
    <div class="navbar-brand mb-0 h1 d-flex align-items-center">
        <img class="ml-3 rounded shadow-lg" src="img/logo3.jpg" height="50" width="50"/>
        <div class="ml-2">Furama</div>
    </div>
    <div class="navbar-brand h1 text-info"><h1>Customers list</h1></div>
    <div class="navbar-brand mb-0 h1">Nguyễn Văn A</div>
</nav>
<!--#endregion-->
<jsp:include page="../../common/hearder.jsp"/>


<!--#region header-->
<div class="container-fluid">
    <div class="row">
        <div class="col-3 p-0">
            <a href="/customers?action=create" class="btn btn-primary"><span
                    style="font-size: larger; font-weight: bolder">+</span>
                Create new customer
            </a>
        </div>
        <div class="col-6">

            <span class="text-success">${message}</span>

        </div>
        <div class="col-3 p-0 text-right">

            <form action="/customers?action=search" method="post" class="d-flex justify-content-end">
                <input class="form-control mr-sm-0" type="search" placeholder="Search name" aria-label="Search"
                       name="search">
                <button class="btn btn-primary my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </div>
</div>
<!--#endregion-->


<a href="/customer-using"  class="btn btn-info mt-2">Customer using service</a>


<!--#region table-->
<table class="table table-hover my-2" id="tableCustomer">
    <thead class="thead-dark">
    <tr>
        <th scope="col">#</th>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Birthday</th>
        <th scope="col">Gender</th>
        <th scope="col">Id card</th>
        <th scope="col">Phone</th>
        <th scope="col">Email</th>
        <th scope="col">Type</th>
        <th scope="col">Address</th>
        <th scope="col">Customer code</th>
        <th scope="col">Action</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customers}" varStatus="loop">
        <tr>
            <th> ${loop.count} </th>
            <th id="id">${customer.getId()}</th>
            <td id="name">${customer.getName()}</td>
            <td id="birthday">${customer.getBirthday()}</td>
            <td id="gender">${customer.getGender()}</td>
            <td>${customer.getIdCard()}</td>
            <td>${customer.getPhone()}</td>
            <td>${customer.getEmail()}</td>
            <td>${customer.getType()}</td>
            <td>${customer.getAddress()}</td>
            <td>${customer.getCode()}</td>

            <td class="d-flex">
                <a href="/customers?action=show&id=${customer.getId()}" type="button" class="btn btn-info">Show</a>
                <a href="/customers?action=edit&id=${customer.getId()}" type="button"
                   class="btn btn-warning mx-1 btnDisplay" style="width: 50px">
                    Edit
                </a>
                <a class="dropdown-toggle btn btn-warning btnNone mx-1 " style="display: none" data-toggle="dropdown"
                   href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    Service</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item btn btn-outline-warning" href="#">Edit service</a>
                    <a class="dropdown-item btn btn-outline-danger" href="#">Delete service</a>
                </div>
                <a class="dropdown-toggle btn btn-success btnNone mx-1" style="display: none" data-toggle="dropdown"
                   href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    Attach</a>
                <div class="dropdown-menu">
                    <a class="dropdown-item " href="#">attach 1</a>
                    <a class="dropdown-item " href="#">attach 2</a>
                </div>
                <!-- Button trigger modal DELETE -->
                <button onclick="myFunction(${customer.getId()})" type="button"
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

    function hideButton() {
        // document.getElementsByClassName("btnDis").classList.toggle("btnDisplay");
        let x = document.getElementsByClassName("btnDisplay");
        for (let i = 0; i < x.length; i++) {
            if (x.item(i).style.display === "none") {
                x.item(i).style.display = "block";
            } else {
                x.item(i).style.display = "none";
            }
        }
        let y = document.getElementsByClassName("btnNone");
        for (let i = 0; i < y.length; i++) {
            if (y.item(i).style.display === "none") {
                y.item(i).style.display = "block";
            } else {
                y.item(i).style.display = "none";
            }
        }
    }
</script>
</body>
</html>
