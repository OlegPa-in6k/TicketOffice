<%@ page import="core.entity.Flights" %>
<%@ page import="java.util.List" %>
<%@ page import="core.entity.City" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
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
    </tr>
    <%}%>
</table>
<br>

<form action="/mvc/managerOffice/addFlight/new" method="post">
    <select name="cityName">
        <% for (City city : (List<City>) request.getAttribute("cities")) { %>
        <option value=<%=city.getCityName()%>><%=city.getCityName()%>
        </option>
        <%}%>
    </select>
    Enter SeatCount:
    <input type="number" size="5" name="seatCount">
    <input type="text" name="departureDate">
    <input type="submit" value="Add">
</form>
<br>

<p>
    <a href="/mvc/managerOffice/city">Add New City</a>
</p>

<p>
    <a href="/mvc/managerOffice">Back</a>
</p>
</body>
</html>
