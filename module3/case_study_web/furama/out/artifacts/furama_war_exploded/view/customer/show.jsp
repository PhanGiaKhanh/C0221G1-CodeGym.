
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
                        <td>STT </td>
                        <td>${customer.getId()}     </td>
                    </tr>
                    <tr>
                        <td>Name </td>
                        <td>${customer.getName()}   </td>
                    </tr>
                    <tr>
                        <td>Birthday</td>
                        <td>${customer.getBirthday()}    </td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td>${customer.getGender()} </td>
                    </tr>
                    <tr>
                        <td>Id card</td>
                        <td>${customer.getIdCard()}  </td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td>${customer.getPhone()}   </td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>${customer.getEmail()}   </td>
                    </tr>
                    <tr>
                        <td>Type customer</td>
                        <td>${customer.getType()}    </td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td>${customer.getAddress()}    </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="text-right"><a href="/customers" class="btn btn-secondary">Close</a>    </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
        <div class="col-3"></div>
    </div>
</div>
<!--#region javascript-->

<script src="../../bootstrap4/jquery-3.6.0.min.js" ></script>
<script src="../../bootstrap4/popper.min.js" ></script>
<script src="../../bootstrap4/bootstrap.min.js" ></script>
<!--#endregion-->
</body>
</html>
