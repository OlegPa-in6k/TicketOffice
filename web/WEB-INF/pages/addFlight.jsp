<%@ page import="Core.Entity.Flights" %>
<%@ page import="java.util.List" %>
<%@ page import="Core.Entity.City" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/4/15
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border = 1>
  <tr><td>№</td><td>Arrival City</td><td>Seats left</td><td>Departure Date <td> </td></tr>

  <%int i = 1;%>
  <%for (Flights flight : (List<Flights>) request.getAttribute("flights")) {%>
  <tr>
    <td><%=i++%></td>
    <td><%=flight.getCity().getCityName()%></td>
    <td><%=flight.getEmptySeat()%></td>
    <td><%=flight.getDepartureDate()%></td>
  </tr>
  <%}%>
</table>
<br>
<form action="/mvc/addFlight" method="post">
  <select name="cityName">
    <% for(City city: (List<City>)request.getAttribute("cities")){ %>
    <option  value=<%=city.getCityName()%>><%=city.getCityName()%></option>
    <%}%>
  </select>
  Enter SeatCount:
  <input type="number"  size="5" name="seatCount" >
  <input type="datetime"  name="departureDate" >
  <input type="submit" value="Add">
</form>

<form action=/ method=post>
  <input type=submit value="Get to start"/>
</form>

</body>
</html>
