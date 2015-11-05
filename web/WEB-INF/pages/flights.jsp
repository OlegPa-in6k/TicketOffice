<%@ page import="core.entity.Flights" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/4/15
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>
<%--<form action="/mvc/selectSeats" method="get">
  <table border = 1>
    <tr><td>№</td><td>Arrival City</td><td>Seats left</td><td>Departure Date <td> </td></tr>
    <%int i = 1;%>
    <%for (Flights flight : (List<Flights>) request.getAttribute("flights")) {%>
    <tr>
      <td><%=i++%></td>
      <td><%=flight.getCity().getCityName()%></td>
      <td><%=flight.getEmptySeat()%></td>
      <td><%=flight.getDepartureDate()%></td>
      <td><input type="hidden" name="flightId" value="<%=flight.getId()%>"/> </td>
      <td><input type="submit"  value="Buy Ticket"/> </td>
    </tr>
    <%}%>
  </table>
</form>--%>

<table border = 1>
  <tr><td>№</td><td>Arrival City</td><td>Seats left</td><td>Departure Date <td> </td></tr>

  <%int i = 1;%>
  <%for (Flights flight : (List<Flights>) request.getAttribute("flights")) {%>
  <tr>
    <td><%=i++%></td>
    <td><%=flight.getCity().getCityName()%></td>
    <td><%=flight.getEmptySeat()%></td>
    <td><%=flight.getDepartureDate()%></td>
    <%--NOT SURE INT THIS FORM --%>
    <td><form action="/mvc/ticketOffice/buyTicket" >
      <input type="submit" value="Buy">
      <input type="hidden" name="flightId" value="<%=flight.getId()%>"/>
    </form></td>

  </tr>
  <%}%>
</table>

</body>
</html>
