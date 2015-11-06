<!DOCTYPE html>
<%@ page import="core.entity.Flights" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/4/15
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border=1>
    <tr>
        <td>№</td>
        <td>Arrival City</td>
        <td>Seats left</td>
        <td>Departure Date
        <td></td>
    </tr>

    <%int i = 1;%>
    <%for (Flights flight : (List<Flights>) request.getAttribute("flights")) {%>
    <tr>
        <td><%=i++%>
        </td>
        <td><%=flight.getCity().getCityName()%>
        </td>
        <td><%=flight.getEmptySeat()%>
        </td>
        <td><%=flight.getDepartureDate()%>
        </td>
        <td>
            <form action="/mvc/managerOffice/flights/delete/<%=flight.getId()%>" method="post">
                <input type="hidden" name="_method" value="DELETE" />
                <input type="submit" value="DELETE">
            </form>
        </td>

    </tr>
    <%}%>
</table>

<p>
    <a href="/mvc/managerOffice">Back</a>
</p>

</body>
</html>
