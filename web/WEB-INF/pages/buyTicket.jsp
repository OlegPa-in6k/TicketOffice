<%@ page import="core.entity.Flights" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/4/15
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

Your Flight:
<table>
    <tr>
        <td>№</td>
        <td>Arrival City</td>
        <td>Seats left</td>
        <td>Departure Date
        <td></td>
    </tr>
    <%Flights flight = (Flights) request.getAttribute("flight");%>
    <tr>
        <td>1</td>
        <td><%=flight.getCity().getCityName()%>
        </td>
        <td><%=flight.getEmptySeat()%>
        </td>
        <td><%=flight.getDepartureDate()%>
        </td>
    </tr>
</table>
<br>

<p>

<form action="/mvc/ticketOffice/buyTicket/<%=flight.getId()%>" method="post">
   Please, enter counter of tickets you need to:
    <input type="number" size="5" name="seatCount"/>
    <input type=submit value="Buy"/>
</form>
</p>


</body>
</html>
