<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 11/4/15
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
No current count of Seats on this Flight!
Try another flight:
<form action=/mvc/ticketOffice method=get>
  <input type=submit value="Ticket Office"/>
</form>
<%--Try another seatcount:
<form action=/mvc/buyTicket method=get>
  <%String id = request.getParameter("flightId");%>
  <input type="hidden" name="flightId" value=<%=id%> />
  <input type=submit value="Change seatCount"/>
</form>--%>

</body>
</html>
