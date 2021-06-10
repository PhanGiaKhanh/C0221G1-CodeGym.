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
    <title>Create Product</title>
    <link rel="stylesheet" href="/bootstrap4/bootstrap.min.css">
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
            <h2 class="text-white rounded bg-info px-5 py-2 mt-2">Create new Product</h2>

                <b class="${message == 'Create Fail'? 'text-danger' : 'text-success'}"> ${message}</b>

            <form method="post">
                <table class="table table-borderless">
                    <tbody>

                    <tr style="display: none">
                        <td>Id</td>
                        <td>
<%--                            <div class="text-danger">${mapMsg.get("name")}</div>--%>
                            <input class="form-control" type="text" value="${product.getId()}" name="id">
                        </td>
                    </tr>
                    <tr>
                        <td>Name</td>
                        <td>
<%--                              <div class="text-danger">${mapMsg.get("name")}</div>--%>
                            <input class="form-control" type="text" value="${product.getName()}" name="name"></td>
                    </tr>
                    <tr>
                        <td>Price</td>
                        <td>
<%--                             <div class="text-danger">${mapMsg.get("birthday")}</div>--%>
                            <input class="form-control" type="number" value="${product.getPrice()}" name="price"></td>
                    </tr>
                    <tr>
                        <td>Amount</td>
                        <td>
<%--                            <div class="text-danger">${mapMsg.get("email")}</div>--%>
                            <input class="form-control" type="text" value="${product.getAmount()}" name="amount"></td>
                    </tr>
                    <tr>
                        <td>Color</td>
                        <td>
<%--                            <div class="text-danger">${mapMsg.get("address")}</div>--%>
                            <input class="form-control" type="text" value="${product.getColor()}"  name="color"></td>
                    </tr>
                    <tr>
                        <td>Description</td>
                        <td>
<%--                            <div class="text-danger">${mapMsg.get("point")}</div>--%>
                            <input class="form-control" type="text" value="${product.getDescription()}" name="description"></td>
                    </tr>
                    <tr>
                        <td>Category</td>
                        <td>
                            <select name="c_id" id="">
                                <c:forEach items="${categories}" var="category">
                                    <option value="${category.id}">${category.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-left"><a href="/products" class="btn btn-secondary">Close</a></td>
                        <td class="text-right"><input class="btn btn-success" type="submit" value="Create"></td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <div class="col-3"></div>
    </div>
</div>
<script src="/bootstrap4/jquery-3.6.0.min.js" ></script>
<script src="/bootstrap4/popper.min.js" ></script>
<script src="/bootstrap4/bootstrap.min.css" ></script>

</body>
</html>
