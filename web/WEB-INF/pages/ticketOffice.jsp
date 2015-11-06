<!DOCTYPE html>
<%@ page import="core.entity.City" %>
<%@ page import="java.util.List" %>
<%@ page import="core.entity.Flights" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/4/15
  Time: 12:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ticket Office</title>
    <link rel="stylesheet" type="text/css" href="../Style/Style.css">
</head>
<body style="text-align: center">

<div>
    <div style="float: left">
        <p>
            <a href="/">Back</a>
        </p>
        All available flights:
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
                    <form action="/mvc/ticketOffice/buyTicket/<%=flight.getId()%>">
                        <input type="submit" value="Buy">
                    </form>
                </td>
            </tr>
            <%}%>
        </table>
    </div>
    <div style="float: left">You can choose flights by City:
        <table>
            <tr>
                <td><a href="/mvc/ticketOffice">All Flights</a></td>
            </tr>
            <% for (City city1 : (List<City>) request.getAttribute("cities")) { %>
            <tr>
                <td><a href="/mvc/ticketOffice/flights/<%=city1.getCityName()%>"><%=city1.getCityName()%>
                </a></td>
            </tr>
            <%}%>
        </table>
    </div>
</div>



</body>
</html>
