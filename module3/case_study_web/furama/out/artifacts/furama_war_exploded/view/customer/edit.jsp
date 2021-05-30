
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
            padding: 5px!important;
        }
        input {
            box-shadow: 1px 1px#637fff;
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
            <h2 class="text-white rounded bg-info px-5 py-2 mt-2">Edit customer <sup><a href="/customers" class="text-primary">x</a></sup></h2>
            <p>
                <c:if test="${message != null} ">
                    <span class="text-success">${message}</span>
                </c:if>
            </p>
            <form method="post">
                <table class="table table-borderless">
                    <tbody>
                    <tr>
                        <td>Name</td>
                        <td><input class="form-control" type="text" value="${customer.getC_name()}" name="name"></td>
                    </tr>
                    <tr>
                        <td>Birthday</td>
                        <td><input class="form-control" type="text" value="${customer.getC_birthday()}" name="birthday"></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td><input class="form-control" type="text" value="${customer.getC_gender()}" name="gender"></td>
                    </tr>
                    <tr>
                        <td>Id card</td>
                        <td><input class="form-control" type="number" value="${customer.getC_id_card()}"  name="card"></td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td><input class="form-control" type="number" value="${customer.getC_phone()}" name="phone"></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input class="form-control" type="email" value="${customer.getC_email()}" name="email"></td>
                    </tr>
                    <tr>
                        <td>Type customer</td>
                        <td><input class="form-control" type="text" value="${customer.getC_type()} " name="type-customer"></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><input class="form-control" type="text" value="${customer.getC_address()}" name="address"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="d-flex justify-content-around"><a href="/customers" class="btn btn-secondary" >Back menu</a><input type="submit" value="Update customer" class="btn btn-warning"></td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <div class="col-3"></div>
    </div>
</div>


<script src="../../bootstrap4/jquery-3.6.0.min.js" ></script>
<script src="../../bootstrap4/popper.min.js" ></script>
<script src="../../bootstrap4/bootstrap.min.js" ></script>
</body>
</html>
