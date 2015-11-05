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
        <td>Departure Date</td></td>
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

<form action="/mvc/managerOffice/flights/new" method="post">
    <select name="cityName">
        <% for (City city : (List<City>) request.getAttribute("cities")) { %>
        <option value=<%=city.getCityName()%>><%=city.getCityName()%>
        </option>
        <%}%>
    </select>
    <table border = 1>
      <tr><td>Enter count of seats:</td><td> <input type="number" size="5" name="seatCount"></td></tr>
        <tr><td>Enter Departure Date: </td><td><input type="text" name="departureDate"></td></tr>
        <tr><td></td><td></td></tr>
         </tr>
        <input type="submit" value="Add">

    </table>
</form>
<br>

<p>
    <a href="/mvc/cities">Add New City</a>
</p>

<p>
    <a href="/mvc/managerOffice">Back</a>
</p>
</body>
</html>
