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
            padding: 5px !important;
        }

        input {
            box-shadow: 1px 1px #637fff;
        }
    </style>

</head>
<body>
<div class="container">
    <div class="row m-3">
        <div class="col-3"></div>
        <div class="col-6 fborder border-secondary rounded shadow">
            <h2 class="text-white rounded bg-info px-5 py-2 mt-2">Create new contract detail</h2>
            <p class="text-success">
                ${message}
            </p>

            <form method="post">
                <div class="container-fluid">
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Contract id</label>
                        <div class="col-sm-8">
                            <select name="cId" >
                                <c:forEach items="${contractList}" var="contract">
                                    <option value="${contract.getId()}">${contract.getId()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Attach Service</label>
                        <div class="col-sm-8">
                            <select name="aId" >
                                <c:forEach items="${attachList}" var="attachService">
                                    <option value="${attachService.getId()}">${attachService.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Quantity</label>
                        <div class="col-sm-8">
                            <input type="number" class="form-control" name="quantity">
                        </div>
                    </div>
                    <div class="d-flex justify-content-between mb-2">
                        <a href="/contractDetail" class="btn btn-secondary">Close</a>
                        <input class="btn btn-success" type="submit" value="Create">
                    </div>

                </div>
            </form>
        </div>
        <div class="col-3"></div>
    </div>
</div>


<script src="../../bootstrap4/jquery-3.6.0.min.js"></script>
<script src="../../bootstrap4/popper.min.js"></script>
<script src="../../bootstrap4/bootstrap.min.css"></script>
<script>
    function serviceType() {
        let id = document.getElementById("typeService").value;
        if (id == 1) {
            document.getElementById("standard").style.display = "block";
            document.getElementById("description").style.display = "block";
            document.getElementById("pool").style.display = "block";
            document.getElementById("floor").style.display = "block";
        } else if (id == 2) {
            document.getElementById("standard").style.display = "block";
            document.getElementById("description").style.display = "block";
            document.getElementById("floor").style.display = "block";
            document.getElementById("pool").style.display = "none";
        } else if (id == 3) {
            document.getElementById("standard").style.display = "none";
            document.getElementById("description").style.display = "none";
            document.getElementById("pool").style.display = "none";
            document.getElementById("floor").style.display = "none";
        }

    }
</script>
</body>
</html>
