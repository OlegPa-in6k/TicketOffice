<%@ page import="core.entity.City" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 10/30/15
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ticket Office</title>
    <link rel="stylesheet" type="text/css" href="../Style/Style.css">
</head>
<body style="text-align: center">



<form action="/ShowAllFlights" method="get">
    <input type="submit" value="ShowAllFlights"/>
</form>



<form action="/ShowFlightsByCity" method="get">
    <select name="cityName">
        <% for(City city: ( List<City> )request.getAttribute("city")){ %>
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
