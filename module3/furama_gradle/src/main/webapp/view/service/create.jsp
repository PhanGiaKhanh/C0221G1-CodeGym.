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
            <h2 class="text-white rounded bg-info px-5 py-2 mt-2">Create new customer</h2>
            <p class="text-success">
                ${message}
            </p>

            <form method="post">
                <div class="container-fluid">
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Name Service</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="name">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Area</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="area">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Cost</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="cost">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Max people</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="maxPeople">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Rent Type</label>
                        <div class="col-sm-8">
                            <select name="rent">
                                <c:forEach var="rent" items="${rentList}">
                                    <option value="${rent.getId()}">${rent.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Service Type</label>
                        <div class="col-sm-8">
                            <select name="type" id="typeService" onchange="serviceType()">
                                <c:forEach var="type" items="${typeList}">
                                    <option value="${type.getId()}">${type.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div id="standard">
                        <div class="form-group row">
                            <label class="col-sm-4 col-form-label">Standard Room</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="standard">
                            </div>
                        </div>
                    </div>
                    <div id="description">
                        <div class="form-group row">
                            <label class="col-sm-4 col-form-label">Description</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="description">
                            </div>
                        </div>
                    </div>
                    <div id="pool">
                        <div class="form-group row">
                            <label class="col-sm-4 col-form-label">Pool Area</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="pool">
                            </div>
                        </div>
                    </div>
                    <div id="floor">
                        <div class="form-group row">
                            <label class="col-sm-4 col-form-label">Number Of Floor</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="floor">
                            </div>
                        </div>
                    </div>
                    <div class="d-flex justify-content-between">
                        <a href="/services" class="btn btn-secondary">Close</a>
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
