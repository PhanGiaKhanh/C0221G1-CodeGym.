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
            <h2 class="text-white rounded bg-info px-5 py-2 mt-2">Create new employee</h2>
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
                        <label class="col-sm-4 col-form-label">Birthday</label>
                        <div class="col-sm-8">
                            <input type="date" class="form-control" name="birthday">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Id card</label>
                        <div class="col-sm-8">
                            <input type="number" class="form-control" name="card">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Salary</label>
                        <div class="col-sm-8">
                            <input type="number" class="form-control" name="salary">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Phone</label>
                        <div class="col-sm-8">
                            <input type="number" class="form-control" name="phone">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Email</label>
                        <div class="col-sm-8">
                            <input type="email" class="form-control" name="email">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Address</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="address">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Position</label>
                        <div class="col-sm-8">
                            <select name="position">
                                <c:forEach var="position" items="${positions}">
                                    <option value="${position.getId()}">${position.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Degree</label>
                        <div class="col-sm-8">
                            <select name="degree" id="typeService" onchange="serviceType()">
                                <c:forEach var="degree" items="${degrees}">
                                    <option value="${degree.getId()}">${degree.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">Division</label>
                        <div class="col-sm-8">
                            <select name="division">
                                <c:forEach var="division" items="${divisions}">
                                    <option value="${division.getId()}">${division.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4 col-form-label">User Name</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="user">
                        </div>
                    </div>
                    <div class="d-flex justify-content-between mb-2">
                        <a href="/employees" class="btn btn-secondary">Close</a>
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
