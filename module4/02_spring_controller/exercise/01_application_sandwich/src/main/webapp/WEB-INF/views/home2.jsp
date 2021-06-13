<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/13/2021
  Time: 12:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>xxxx</td>
        <td>yyyy</td>
    </tr>
    <tr>
        <td>1</td>
        <td><input type="button" value="eidt">
            <input type="button" value="save"></td>
    </tr>
    <tr id="an">
        <td><input type="text" readonly value="1222" id="1"> </td>
        <td><input type="text" readonly value="111" id="2"></td>
    </tr>
</table>
<input type="text" value="hello" id="text1" readonly>
<button onclick="an()">edit</button>
<script>
    function an() {
        document.getElementById("text1").readonly = false;
    }
</script>
</body>
</html>
