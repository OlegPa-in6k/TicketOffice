<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/4/15
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
  <link rel="stylesheet" type="text/css" href="../Style/Style.css">
</head>
<body style="text-align: center">

<form action="/mvc/managerOffice/addFlight" method="get">
  <input type="submit" value="AddNewFlight" />
</form>
<br><br>

<form action="/mvc/flights/delete" method="get">
  <input type="submit" value="DeleteFlight" />
</form>
<br><br>

<p>
  <a href="/">Back</a>
</p>

</body>
</html>
