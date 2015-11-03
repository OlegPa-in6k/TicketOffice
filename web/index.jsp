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
  <link rel="stylesheet" type="text/css" href="Style/Style.css">
</head>
<body style="text-align: center">

<br/><br/>

<form action="views/ManagerOffice.jsp" method="post">
  <input type="submit" value="ManagerOffice" />
</form>

<form action="/TicketOffice" method="get">
  <input type="submit" value="TicketOffice" />
</form>

</body>
</html>
