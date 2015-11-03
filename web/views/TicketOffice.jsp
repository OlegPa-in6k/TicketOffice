<%@ page import="Core.Entity.City" %>
<%@ page import="Persistance.CityDaoImpl" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
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
123
<table>
    <% for(City cit: ( List<City> )request.getAttribute("city")){ %>
    <tr><td><% cit.getCityName();%></td></tr>
    <%}%>
</table>

<form action="/ShowAllFlights" method="get">
    <input type="submit" value="ShowAllFlights"/>
</form>



<form action="/ShowFlightsByCity" method="get">
    <input type="submit" value="Show Flight By City"/>
</form>

<br>

<form action=/ method=post>

    <input type=submit value="Get to start"/>
</form>

</body>
</html>
