<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/30/2021
  Time: 10:16 AM
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
<body class="mx-3">
<!--#region header-->
<h1 class="mt-3 py-3 pl-5 bg-light text-info">Customers list </h1>
<div class="container my-4">
    <div class="row">
        <div class="col-3">

            <!--            Modal CREATE-->
            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#create"><span
                    style="font-size: larger; font-weight: bolder">+</span>
                Create new customer
            </button>
            <!-- Modal -->
            <div class="modal fade" id="create" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h2 class="text-white rounded bg-info px-5 py-2 mt-2">Create new customer</h2>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body fborder border-secondary rounded shadow">
                            <%--                        Create Customer--%>
                            <form action="/customer?action=create" method="post">
                                <table class="table table-borderless">
                                    <tbody>
                                    <tr>
                                        <td>Name</td>
                                        <td><input class="form-control" type="text" value=""
                                                   name="name"></td>
                                    </tr>
                                    <tr>
                                        <td>Birthday</td>
                                        <td><input class="form-control" type="text" value=""
                                                   name="birthday"></td>
                                    </tr>
                                    <tr>
                                        <td>Gender</td>
                                        <td>
                                            <select class="form-control" name="gender" id="">
                                                <option value="Male">Male</option>
                                                <option value="Female">Female</option>
                                                <option value="Other">Other</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Id card</td>
                                        <td><input class="form-control" type="number" value=""
                                                   name="idCard"></td>
                                    </tr>
                                    <tr>
                                        <td>Phone</td>
                                        <td><input class="form-control" type="text" value=""
                                                   name="phone"></td>
                                    </tr>
                                    <tr>
                                        <td>Email</td>
                                        <td><input class="form-control" type="email" value=""
                                                   name="email"></td>
                                    </tr>
                                    <tr>
                                        <td>Type customer</td>
                                        <td><input class="form-control" type="text" value=""
                                                   name="typeCustomer"></td>
                                    </tr>
                                    <tr>
                                        <td>Address</td>
                                        <td><input class="form-control" type="text" value=""
                                                   name="address"></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input class="btn btn-success" type="submit" value="Create new customer">
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

                        </div>

                    </div>
                </div>
            </div>
            <!--end model-->

        </div>
        <div class="col-5">
<%--            <c:if test="${message != null} ">--%>
<%--                <span class="text-success">${message}</span>--%>
<%--            </c:if>--%>
        </div>
        <div class="col-4 text-right">
            <form class="d-flex">
                <input type="search" class="form-control" placeholder="Search name">
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
        <th scope="col">STT</th>
        <th scope="col">Name</th>
        <th scope="col">Birthday</th>
        <th scope="col">Gender</th>
        <th scope="col">Id card</th>
        <th scope="col">Phone</th>
        <th scope="col">Email</th>
        <th scope="col">Type customer</th>
        <th scope="col">Address</th>
        <th scope="col">Show</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <th>${customer.id}</th>
            <td>${customer.c_name}</td>
            <td>${customer.c_birthday}</td>
            <td>${customer.c_gender}</td>
            <td>${customer.c_id_card}</td>
            <td>${customer.c_phone}</td>
            <td>${customer.c_email}</td>
            <td>${customer.c_type}</td>
            <td>${customer.c_addressx}</td>

            <td style="width: 5%">
                <!--            <button type="button" class="btn btn-info">Show</button>-->
                <!-- Button trigger modal SHOW -->
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#show">
                    Show
                </button>
                <!-- Modal -->
                <div class="modal fade" id="show" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h2 class="text-white rounded bg-info px-5 py-3 mt-2">Customer information</h2>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="container">
                                    <div class="row">
                                        <div class="col fborder border-secondary rounded">
                                            <form>
                                                <table class="table">
                                                    <tbody>
                                                    <tr>
                                                        <td>STT</td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Name</td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Birthday</td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Gender</td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Id card</td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Email</td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Type customer</td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Address</td>
                                                        <td></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            </div>
                        </div>
                    </div>
                </div>
                <!--end model-->

            </td>
            <td style="width: 5%">
                <!--            <button type="button" class="btn btn-warning">Edit</button>-->
                <!-- Button trigger modal Edit -->
                <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#edit">
                    Edit
                </button>
                <!-- Modal -->
                <div class="modal fade" id="edit" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h2 class="text-white rounded bg-info px-5 py-2 mt-2">Edit customer</h2>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="container">
                                    <div class="row">
                                        <div class="col fborder border-secondary rounded">
                                            <!-- Edit Customer-->
                                            <form>
                                                <table class="table table-borderless">
                                                    <tbody>
                                                    <tr>
                                                        <td>Name</td>
                                                        <td><input class="form-control" type="text" value=""
                                                                   name="name">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Birthday</td>
                                                        <td><input class="form-control" type="text" value=""
                                                                   name="name">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Gender</td>
                                                        <td><input class="form-control" type="text" value=""
                                                                   name="gender">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Id card</td>
                                                        <td><input class="form-control" type="number" value=""
                                                                   name="card">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Email</td>
                                                        <td><input class="form-control" type="email" value=""
                                                                   name="email">
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Type customer</td>
                                                        <td><input class="form-control" type="text" value=""
                                                                   name="type-customer"></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Address</td>
                                                        <td><input class="form-control" type="text" value=""
                                                                   name="address">
                                                        </td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </form>
                                            <!-- End Edit Customer-->
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <input class="btn btn-warning" type="submit"
                                       value="Edit customer">
                            </div>
                        </div>
                    </div>
                </div>
                <!--end model-->
            </td>
            <td style="width: 5%">
                <!-- Button trigger modal DELETE -->
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#delete">
                    Delete
                </button>
                <!-- Modal -->
                <div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h2 class="text-white rounded bg-info px-5 py-2 mt-2">Delete customer</h2>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="container">
                                    <div class="row">
                                        <div class="col fborder border-secondary rounded">
                                            <form>
                                                <table class="table">
                                                    <tbody>
                                                    <tr>
                                                        <td>STT</td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Name</td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Birthday</td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Gender</td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Id card</td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Email</td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Type customer</td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td>Address</td>
                                                        <td></td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-danger">Delete</button>
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
<!--#endregion-->
</body>
</html>