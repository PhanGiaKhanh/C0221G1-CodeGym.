<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/12/2021
  Time: 8:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Converter</title>
</head>
<body>
<h1>Converter app</h1>
<form action="convert" method="post">
    <table border="1">
        <tr>
            <th>Money</th>
            <th>Money Type</th>
            <th>To Money Type</th>
            <th>Result</th>
        </tr>
        <tr>
            <th><input type="number" name="money"></th>
            <th>
                <select name="moneyType">
                    <option value="1">USD</option>
                    <option value="23000">VN</option>
                </select>
            </th>
            <th>
                <select name="moneyType2">
                    <option value="1">USD</option>
                    <option value="23000">VN</option>
                </select>
            </th>
            <th>
                <input type="submit" value="convert"><input type="numbe" readonly value="${result}">
            </th>
        </tr>
    </table>
</form>
<h2>${result}</h2>
</body>
</html>
