<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/5/2021
  Time: 3:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--#region menu-->
<nav class="navbar navbar-expand-lg  navbar-dark bg-success my-2 pl-5 border border-info  sticky-top">
    <a class="navbar-brand mx-5" href="/index.jsp">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item mr-5">
                <a class="navbar-brand mr-0" href="/employees">Employee <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item  mr-5">
                <a class="navbar-brand mr-0" href="/customers">Customer <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item mr-5 ">
                <a class="navbar-brand mr-0" href="/services">Service <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item mr-5 ">
                <a class="navbar-brand mr-0" href="/contracts?action=create">Contract <span class="sr-only">(current)</span></a>
            </li>

            <li class="nav-item mr-5 ">
                <a class="navbar-brand mr-0" href="/contractDetail?action=create">Contract Detail <span class="sr-only">(current)</span></a>
            </li>

            <li class="nav-item mr-5 ">
                <a class="navbar-brand mr-0" href="/contracts">List <span class="sr-only">(current)</span></a>
            </li>
        </ul>
    </div>
</nav>
<!--#endregion-->

</body>
</html>
