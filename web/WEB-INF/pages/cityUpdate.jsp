<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="core.entity.City" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/5/15
  Time: 10:43 AM
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

<% City city = (City) request.getAttribute("city");%>
Change <%=city.getCityName()%> to:
<form action="/mvc/cities/update/<%=city.getCityId()%>" method="post">
    <input type="text" size="10" value=<%=city.getCityName()%> name="cityName"/>
    <input type="hidden" name="_method" value="PATCH" />
    <input type="submit" name="Change"/>
</form>
</body>
</html>
