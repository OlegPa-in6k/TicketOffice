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
    <title></title>
</head>
<body>

<form action="/mvc/managerOffice/city/update" method="post">
<input type="text" size="10" name="cityName"/>
  <% City city = (City) request.getAttribute("city");%>
<input type="hidden"  name="id" value="<%=city.getCityId()%>"/>
<input type="submit" name="Change"/>
</form>
</body>
</html>
