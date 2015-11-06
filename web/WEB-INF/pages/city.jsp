<!DOCTYPE html>
<%@ page import="core.entity.City" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/5/15
  Time: 9:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel='stylesheet' href='/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css'>

    <title></title>
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
<table border=1>
    <tr>
        <td>City Name</td>
    </tr>
    <% for (City city : (List<City>) request.getAttribute("cities")) { %>
    <tr>
        <td><%=city.getCityName()%>
        </td>
        <td>
            <form action="/mvc/cities/delete/<%=city.getCityId()%>" method="post">
                <input type="hidden" name="_method" value="DELETE" />
                <input type="submit" value="Delete">
            </form>
        </td>
        <td><a href="/mvc/cities/update?id=<%=city.getCityId()%>"> Edit </a></td>
    </tr>
    <%}%>
</table>
<p>If there is no city that you need, you can add it:
<form action="/mvc/cities/add" method="post">
    <input type="text" size="10" name="cityName">
    <input type="submit" value="Add">
</form>
</p>

<p>
    <a href="/mvc/managerOffice"> Back </a>
</p>

</body>
</html>
