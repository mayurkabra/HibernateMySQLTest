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
<script>
         $(function() {
            $( "#dialogForRides" ).dialog({
               autoOpen: false,
               title:"Add Rides"
            });
            /*$( "#openDialog" ).click(function() {
               $( "#dialogForRequests" ).dialog( "open" );
            });*/
         });
      </script>
<body>
		<div id="dialogForRides"></div>
		<table>
		<tr>
		<th>Pickup</th>
		<th>Destination</th>
		<th>Pickup Time</th>
		</tr>
<%for(Request requests : (ArrayList<Request>)request.getAttribute("allRequests")){
	%><tr>
	<td align="center"><%=requests.getPickupPlace()%> </td>
	<td align="center"> <%=requests.getDestination()%> </td>
	<td align="center"> <%=requests.getStartTime()%></td> 
	<td>
		<input type="button" onclick="showAllRidesFilteredOnDate(<%=requests.getRequest_id()%>);" value="View All Rides"></input>
		<input type="button" onclick="respondToRequest(28,11, 1);" value="Accept Request"></input> 
		<input type="button" onclick="respondToRequest(28,11, 2);" value="Reject Request"></input>
	</td>
	</tr><%
} %>
</table>
<input type="hidden" id="pageType" value="request"/>
</body>
<script src="../resources/js/show_ride.js"></script>
</html>