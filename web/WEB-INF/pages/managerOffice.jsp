<!DOCTYPE html>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/4/15
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel='stylesheet' href='/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css'>

</head>
<body style="text-align: center">
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

<p>
    <a href="/mvc/managerOffice/flights">Show Flights</a>
</p>
<p>
    <a href="/mvc/managerOffice/flights/delete">Delete Flights</a>
</p>
<%--<form action="/mvc/managerOffice/flights" method="get">
    <input type="submit" value="AddNewFlight"/>
</form>
<br><br>

<form action="/mvc/managerOffice/flights/delete" method="get">
    <input type="submit" value="DeleteFlight"/>
</form>--%>
<br><br>

<p>
    <a href="/">Back</a>
</p>

</body>
</html>
