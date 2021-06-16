<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/16/2021
  Time: 4:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Welcome to with me</h1>
  <img id="img-of-the-day">
  <script>
    let query = 'https://api.nasa.gov/planetary/apod? api_key = AuWkEbObEvmVdei8r0FMnk0a5z9PBKKw9oingwsd;
    let request = new XMLHttpRequest();
    request.open('GET', query);
    request.onload = function() {
      if (request.status === 200) {
        let response = JSON.parse(request.responseText);
        document.getElementById('img-of-the-day').setAttribute('src', response.url);
      }
    };
    request.send();
  </script>
  </body>
</html>
