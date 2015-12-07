<%@page import="java.util.ArrayList"%>
<%@page import="com.hibernate.test.pojo.Request"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"></jsp:include>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
		<table>
		<tr>
		<th>Pickup</th>
		<th>Destination</th>
		<th>Pickup Time</th>
		</tr>
<%for(Request requests : (ArrayList<Request>)request.getAttribute("allRequests")){
	%><tr><td align="center"><%=requests.getPickupPlace()%> </td><td align="center"> <%=requests.getDestination()%> </td><td align="center"> <%=requests.getRequestTime()%></td> </tr><%
} %>
</table>
</body>
<script src="../resources/js/show_request.js"></script>
</html>