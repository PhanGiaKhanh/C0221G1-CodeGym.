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
</head>
<body class="m-2">
<h1 class="mt-3 py-3 pl-5 bg-light text-info">Customers list </h1>
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
                <a class="navbar-brand mr-0" href="#">Customer <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item mr-5 ">
                <a class="navbar-brand mr-0" href="#">Service <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item mr-5 ">
                <a class="navbar-brand mr-0" href="#">Contract <span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>
<!--#endregion-->
<!--#region header-->
<div class="container my-4">
    <div class="row">
        <div class="col-3">
            <a href="/customers?action=create" class="btn btn-primary"><span
                    style="font-size: larger; font-weight: bolder">+</span>
                Create new customer
            </a>
        </div>
        <div class="col-5">
            <%--            <c:if test="${message != null} ">--%>
            <%--                <span class="text-success">${message}</span>--%>
            <%--            </c:if>--%>
        </div>
        <div class="col-4 text-right">
            <form action="/customers?action=search" method="post" class="d-flex">
                <input type="search" class="form-control" placeholder="Search name" name="search">
                <button type="submit" class="btn btn-primary">Search</button>
            </form>
        </div>
    </div>
</div>
<!--#endregion-->

<!--#region table-->
<table class="table table-hover">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Birthday</th>
        <th scope="col">Gender</th>
        <th scope="col">Id card</th>
        <th scope="col">Phone</th>
        <th scope="col">Email</th>
        <th scope="col">Type</th>
        <th scope="col">Address</th>
        <th scope="col">Show</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <th>${customer.getId()}</th>
            <td>${customer.getC_name()}</td>
            <td>${customer.getC_birthday()}</td>
            <td>${customer.getC_gender()}</td>
            <td>${customer.getC_id_card()}</td>
            <td>${customer.getC_phone()}</td>
            <td>${customer.getC_email()}</td>
            <td>${customer.getC_type()}</td>
            <td>${customer.getC_address()}</td>

            <td style="width: 5%">
                <a href="/customers?action=show&id=${customer.getId()}" type="button" class="btn btn-info">Show</a>
            </td>
            <td style="width: 5%">
                <a href="/customers?action=edit&id=${customer.getId()}" type="button" class="btn btn-warning">
                    Edit
                </a>
            </td>
            <td style="width: 5%">
                <!-- Button trigger modal DELETE -->
                <a href="/customers?action=delete?customer=${customer}" type="button" class="id-modal btn btn-danger" data-toggle="modal" data-target="#delete">
                    Delete
                </a>
                <!-- Modal -->
                <div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-body fborder border-secondary rounded">
                                <table class="table">
                                    <tbody>
                                    <tr>
                                        <td>Id</td>
                                        <td>${customer.getId()} </td>
                                    </tr>
                                    <tr>
                                        <td>Name</td>
                                        <td>${customer.getC_name()} </td>
                                    </tr>
                                    <tr>
                                        <td>Birthday</td>
                                        <td>${customer.getC_birthday()} </td>
                                    </tr>
                                    <tr>
                                        <td>Gender</td>
                                        <td>${customer.getC_gender()} </td>
                                    </tr>
                                    <tr>
                                        <td>Id card</td>
                                        <td>${customer.getC_id_card()} </td>
                                    </tr>
                                    <tr>
                                        <td>Phone</td>
                                        <td>${customer.getC_phone()} </td>
                                    </tr>
                                    <tr>
                                        <td>Email</td>
                                        <td>${customer.getC_email()} </td>
                                    </tr>
                                    <tr>
                                        <td>Type customer</td>
                                        <td>${customer.getC_type()} </td>
                                    </tr>
                                    <tr>
                                        <td>Address</td>
                                        <td>${customer.getC_address()} </td>
                                    </tr>
                                    </tbody>
                                </table>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <form action="/customers?action=delete&id=${customer.getId()}" method="post">
                                    <button type="submit    " class="btn btn-danger">Delete</button>
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
<script>
    $(document).on("click", ".id-modal", function () {
    var myBookId = $(this).data('id');
    $(".modal-body #bookId").val( myBookId );
    // As pointed out in comments,
    // it is unnecessary to have to manually call the modal.
    // $('#addBookDialog').modal('show');
    });
</script>
<script src="../../bootstrap4/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap4/popper.min.js"></script>
<script src="../../bootstrap4/bootstrap.min.js"></script>
<!--#endregion-->
</body>
</html>
