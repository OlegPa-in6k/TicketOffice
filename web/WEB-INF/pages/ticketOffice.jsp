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
    <link rel='stylesheet' href='/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css'>

</head>
<body >
<div><nav class="navbar navbar-inverse navbar-fixed-top">
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
                <li><a href="/mvc/ticketOffice">Ticket Office</a></li>
            </ul>

        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
</div>
<div>
    <div class="col-sm-12 col-lg-4 panel panel-default">
        <div class="panel-heading">Panel heading</div>
        <table class="table table-striped">
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
                <td width="10%"><%=i++%>
                </td>
                <td width="30%"><%=flight.getCity().getCityName()%>
                </td>
                <td width="10%"><%=flight.getEmptySeat()%>
                </td>
                <td width="40%"><%=flight.getDepartureDate()%>
                </td>
                <td width="10%">
                    <form action="/mvc/ticketOffice/buyTicket/<%=flight.getId()%>">
                        <input type="submit" value="Buy">
                    </form>
                </td>
            </tr>
            <%}%>
        </table>
    </div>

    <div class="col-sm-12 col-lg-2">
        You can choose flights by City:
        <table class="table table-striped">
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
    <div >

    </div>
</div>



</body>
</html>
