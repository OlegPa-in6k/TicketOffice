<%@ page import="core.entity.City" %>
<%@ page import="persistence.CityDaoImpl" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 10/30/15
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="../Style/Style.css">
</head>
<body style="text-align: center">

<form action="/AddNewFlight" method="post">
  <label>
    <select name="cityName">
      <% for(City city: (List<City>)request.getAttribute("city")){ %>
      <option value=<%=city.getCityName()%>><%=city.getCityName()%></option>
      <%}%>
    </select>
  </label>
  <br>
  <label>
    CounterOfSeats:
    <input type="text" size="5" name="seatCount"/>
  </label>
  <br>
  <label>
    departureDate(yyyy-MM-dd HH:MM:
    <input type="text" size="15" name="departureDate"/>
  </label>
  <input type="submit"   value="Add" />

</form>
</body>
</html>
