<%@ page import="Core.Entity.City" %>
<%@ page import="Persistance.CityDaoImpl" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 10/30/15
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ticket Office</title>
    <link rel="stylesheet" type="text/css" href="Style/Style.css">
</head>
<body style="text-align: center">
<form action="TicketOffice/ShowAllFlights" method="get">
    <input type="submit" value="ShowAllFlights"/>
</form>


Select by City:
<form action="TicketOffice/ShowAllFlights" method="post">

    <label>
        <select name="cityName">
            <%
                ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                        new String[]{"applicationContext.xml"}, true);
            %>
            <% CityDaoImpl search = (CityDaoImpl) context.getBean("daoCity");%>
            <%for (City city : search.getAll()) { %>
            <option value=<%=city.getCityName()%>><%=city.getCityName()%>
            </option>
            <%}%>
        </select>
    </label>

    <input type="submit" value="Show"/>
</form>

<br>

<form action=/ method=post>

    <input type=submit value="Get to start"/>
</form>

<%--<form action="AddNewFlight" method="post">
  <input type="submit" value="AddNewFlight" />
</form>--%>
</body>
</html>
