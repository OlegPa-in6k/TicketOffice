<%@ page import="Core.Entity.City" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/4/15
  Time: 12:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Ticket Office</title>
  <link rel="stylesheet" type="text/css" href="../Style/Style.css">
</head>
<body style="text-align: center">

<form action="/mvc/flights" method="get">
  <input type="submit" value="ShowAllFlights"/>
</form>

<form action="/mvc/flights/" method="post">
    <select name="cityName">
    <% for(City city: (List<City>)request.getAttribute("cities")){ %>
    <option value=<%=city.getCityName()%>><%=city.getCityName()%></option>
    <%}%>
    </select>
  <input type="submit" value="Show Flight By City"/>
</form>

<br>

<form action=/ method=post>
  <input type=submit value="Get to start"/>
</form>

</body>
</html>
