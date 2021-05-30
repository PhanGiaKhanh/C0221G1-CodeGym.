
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
                        <td>${customer.getC_name()}   </td>
                    </tr>
                    <tr>
                        <td>Birthday</td>
                        <td>${customer.getC_birthday()}    </td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td>${customer.getC_gender()} </td>
                    </tr>
                    <tr>
                        <td>Id card</td>
                        <td>${customer.getC_id_card()}  </td>
                    </tr>
                    <tr>
                        <td>Phone</td>
                        <td>${customer.getC_phone()}   </td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>${customer.getC_email()}   </td>
                    </tr>
                    <tr>
                        <td>Type customer</td>
                        <td>${customer.getC_type()}    </td>
                    </tr>
                    <tr>
                        <td>Address</td>
                        <td>${customer.getC_address()}    </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><a href="/customers" class="btn btn-secondary">Back menu list</a>    </td>
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
