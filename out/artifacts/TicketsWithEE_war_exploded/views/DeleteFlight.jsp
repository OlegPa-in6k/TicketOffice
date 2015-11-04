<%@ page import="Core.Entity.Flights" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleg
  Date: 04.11.2015
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="DeleteFlight" method="post">
  <table border = 1>
    <tr><td>№</td><td>Arrival City</td><td>Seats left</td><td>Departure Date <td> </td></tr>

    <%int i = 1;%>
    <%for (Flights flight : (List<Flights>) request.getAttribute("flights")) {%>
    <tr>
      <td><%=i++%></td>
      <td><%=flight.getCity().getCityName()%></td>
      <td><%=flight.getEmptySeat()%></td>
      <td><%=flight.getDepartureDate()%></td>
      <td><input type="hidden" name="flightId" value="<%=flight.getId()%>" /></td>
      <td><input type="submit" value="Delete Flight" /></td>

      </tr>
    <%}%>
  </table>
</form>
</body>
</html>
