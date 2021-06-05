<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/28/2021
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!--    <link rel="stylesheet" href="../bootstrap4/bootstrap.css">-->
    <link rel="stylesheet" href="bootstrap4/bootstrap.min.css">

</head>
<body class="m-2">
<!--#region header-->
<nav class="navbar navbar-light bg-light border border-info ">
    <div class="navbar-brand mb-0 h1 d-flex align-items-center">
        <img class="ml-3 rounded shadow-lg" src="img/logo3.jpg" height="50" width="50"/>
        <div class="ml-2">Furama</div>
    </div>
    <div class="navbar-brand h1 text-info"><h1>Welcome to Furama</h1> </div>
    <div class="navbar-brand mb-0 h1">Nguyễn Văn A</div>
</nav>
<!--#endregion-->

<jsp:include page="common/hearder.jsp"/>

<!--#region main-->
<div class="container-fluid">
    <div class="row "  style="box-sizing: border-box">
        <div class="col-3 p-0 bg-light ">
            <ul class="border m-0 border-info" style="height: 500px; list-style: none">
                <li class="mt-5">Item one</li>
                <li class="mt-5">Item two</li>
                <li class="mt-5">Item three</li>
            </ul>
        </div>
        <div class="col-9 border border-info border-left-0" style="height: 500px "></div>
    </div>
</div>
<!--#endregion-->

<!--#region footer-->
<div class="pt-4  bg-light text-center mt-2 border border-info" style="height: 69px">
    hello
</div>
<!--#endregion-->


<script src="bootstrap4/jquery-3.6.0.min.js"></script>
<script src="bootstrap4/popper.min.js"></script>
<script src="bootstrap4/bootstrap.min.js"></script>
</body>
</html>
