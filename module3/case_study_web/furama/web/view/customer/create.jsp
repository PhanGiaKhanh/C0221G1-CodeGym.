<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/30/2021
  Time: 9:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create customer</title>
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
      </style>

</head>
<body>
<div class="container">
    <div class="row mt-4">
        <div class="col-3"></div>
        <div class="col-6 fborder border-secondary rounded shadow">
            <h2 class="text-white rounded bg-info px-5 py-2 mt-2">Create new customer</h2>
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
                        <td><input class="form-control" type="text" value="" name="name"></td>
                    </tr>
                    <tr>
                        <td>Birthday</td>
                        <td><input class="form-control" type="text" value="" name="birthday"></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
<%--                        <td><input class="form-control" type="text" value="" name="gender"></td>--%>
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
                        <td><input class="form-control" type="number" value=""  name="idCard"></td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td><input class="form-control" type="number" value="" name="phone"></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input class="form-control" type="email" value="" name="email"></td>
                    </tr>
                    <tr>
                        <td>Type customer</td>
                        <td><input class="form-control" type="text" value="" name="typeCustomer"></td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td><input class="form-control" type="text" value="" name="address"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="text-right"><a href="/customers" class="btn btn-secondary mr-2">Close</a><input class="btn btn-success" type="submit" value="Create"></td>
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
<script src="../../bootstrap4/bootstrap.min.css" ></script>

</body>
</html>
