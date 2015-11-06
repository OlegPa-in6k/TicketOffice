<!DOCTYPE html><%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 10/29/15
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='/resources/bootstrap-3.3.5-dist/css/bootstrap.min.css'>
    <link rel='stylesheet' href='/resources/bootstrap-3.3.5-dist/js/bootstrap.min.js'>
    <title>Ticket Office</title>

</head>
<body style="text-align: center" >
<nav class="navbar navbar-inverse navbar-fixed-top">
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

<div class="jumbotron" >
    <h1>Hello, User!</h1>
    <p>Welcome to AirPort! Pls choose section you would like to visit:</p>
    <div class="row">
        <div class="col-sm-12 col-lg-6">
            <a class="btn btn-primary btn-lg" href="/mvc/managerOffice" role="button">Manager Office</a>
        </div>
        <div class="col-sm-12 col-lg-6">
            <a class="btn btn-primary btn-lg" href="/mvc/ticketOffice" role="button">Ticket Office</a>
        </div>
    </div>
</div>
<%--<div class="row">
    <div class="col-xs-6 col-md-3">
        <a href="#" class="thumbnail">
            <img src="/resources/images/OfficePhoto.jpg"  >
        </a>
    </div>
    <div class="col-xs-6 col-md-3">
        <a href="#" class="thumbnail">
            <img src="/resources/images/TicketOffice.jpg"   >
        </a>
    </div>

</div>--%>
<div>
    <div class="col-sm-12 col-lg-6">
        <a href="/mvc/managerOffice">
            <img src="/resources/images/OfficePhoto.jpg" width="100%" height="100%" sizes="100%">
        </a>
    </div>
    <div class="col-sm-12 col-lg-6">
        <a href="/mvc/ticketOffice">
            <img src="/resources/images/TicketOffice.jpg" width="100%" height="100%" sizes="100%">
        </a>
    </div>
</div>





</body>
</html>
