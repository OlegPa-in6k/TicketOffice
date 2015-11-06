<!DOCTYPE html>
<%@ page import="core.entity.Flights" %>
<%@ page import="java.util.List" %>
<%@ page import="core.entity.City" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel='stylesheet' href='/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css'>

</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Main Menu</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/mvc/managerOffice">Manager Office <span
                        class="sr-only">(current)</span></a></li>
                <li><a href="/mvc/ticketOffice">Ticket Office</a></li>
            </ul>

        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
<table>
    <tr>
        <td>№</td>
        <td>Arrival City</td>
        <td>Seats left</td>
        <td>Departure Date</td>
        </td>
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
    <table border=1>
        <tr>
            <td>Enter count of seats:</td>
            <td><input type="number" size="5" name="seatCount"></td>
        </tr>
        <tr>
            <td>Enter Departure Date:</td>
            <td><input type="text" name="departureDate"></td>
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
