<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/26/2021
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/product" method="post">
    <h4>Product description</h4>
    <input type="text" placeholder="Mô tả sản phẩm" name ="description">
    <h4>List price</h4>
    <input type="number" placeholder="Giá sản phẩm" name ="price">
    <h4>Discount percent</h4>
    <input type="number" max="100" name ="percent">
    <br>
    <input type="submit" id="submit" value="Enter">
  </form>
  </body>
</html>
