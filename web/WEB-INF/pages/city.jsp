<%@ page import="core.entity.City" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/5/15
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border =1 >
  <tr><td>City Name</td></tr>
  <% for(City city: (List<City>)request.getAttribute("cities")){ %>
  <tr>
    <td><%=city.getCityName()%></td>
    <td><a href="/mvc/managerOffice/city/delete?id=<%=city.getCityId()%>"> Delete </a></td>
    <td><a href="/mvc/managerOffice/city/update?id=<%=city.getCityId()%>"> Edit </a></td>
  </tr>
  <%}%>
</table>
<p>U can add new City:
<form action="/mvc/managerOffice/cities/add" method="post">
  <input type="text" size="10" name="cityName">
  <input type="submit" value="Add">
</form>
</p>

<p>
  <a href="/mvc/managerOffice/addFlight"> Back </a>
</p>

</body>
</html>
