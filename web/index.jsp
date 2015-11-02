<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 10/29/15
  Time: 2:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Ticket Office</title>
</head>
<body style="text-align: center">
<%--<a href="/QuickServlet">Click here to send GET request</a>
<a href="/ShowFlights">GET Request AllFlights</a>--%>

<br/><br/>

<form action="ManagerOffice.jsp" method="post">
  <input type="submit" value="ManagerOffice" />
</form>

<form action="TicketOffice.jsp" method="post">
  <input type="submit" value="TicketOffice" />
</form>

<%--<form action="QuickServlet" method="post">
  Width: <input type="text" size="5" name="width"/>
  &nbsp;&nbsp;
  Height <input type="text" size="5" name="height"/>
  &nbsp;&nbsp;
  <input type="submit" value="Calculate" />
</form>


<form action="ShowFlights" method="post">
  <input type="submit" value="ShowFlights" />
</form>--%>




</body>
</html>
