<%@ page import="Core.Entity.Flights" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/3/15
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="BuyTickets" method="post">
    <%--<% Flights flight = (Flights) request.getAttribute("flight");%>
    --%><label>
        CounterOfSeats:
        <input type="text" size="5" name="seatCount"/>
    </label>

    <input type=submit value="Buy"/>
</form>
</body>
</html>
