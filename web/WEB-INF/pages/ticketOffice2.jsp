<%@ page import="core.entity.Flights" %>
<%@ page import="java.util.List" %>
<%@ page import="core.entity.City" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/5/15
  Time: 5:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
Hello!
<table>
    <tr>
        <td>
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
        </td>
        <td>
            You can choose flights by City:
            <table>
                <tr><td><a href="/mvc/ticketOffice">All Flights</a> </td></tr>
                <% for (City city1 : (List<City>) request.getAttribute("cities")) { %>
                <tr><td><a href="/mvc/ticketOffice/flights/<%=city1.getCityName()%>"><%=city1.getCityName()%> </a> </td></tr>
                <%}%>
            </table>


        </td>
    </tr>
</table>




</body>
</html>
