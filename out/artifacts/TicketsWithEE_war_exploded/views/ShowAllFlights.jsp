<%@ page import="core.entity.Flights" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/3/15
  Time: 3:57 PM
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
  <td><a href="BuyTickets?id=<%=flight.getId()%>"> Buy Ticket </a>  </td>
  </tr>
  <%}%>
</table>

</body>
</html>
