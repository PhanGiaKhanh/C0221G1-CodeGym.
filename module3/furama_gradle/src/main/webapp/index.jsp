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

<!--#region menu-->
<nav class="navbar navbar-expand-lg  navbar-dark bg-success my-2 px-5 border border-info  sticky-top">
    <a class="navbar-brand mx-5" href="#">Home</a>
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
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-primary my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<!--#endregion-->

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
