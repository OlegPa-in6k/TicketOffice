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
    <title></title>
</head>
<body>


<% City city = (City) request.getAttribute("city");%>
Change <%=city.getCityName()%> to:
<form action="/mvc/cities/update/<%=city.getCityId()%>" method="post">
    <input type="text" size="10" value=<%=city.getCityName()%> name="cityName"/>
    <input type="hidden" name="_method" value="PATCH" />
    <input type="submit" name="Change"/>
</form>
</body>
</html>
