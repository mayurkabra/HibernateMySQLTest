<%@page import="java.util.ArrayList"%>
<%@page import="com.hibernate.test.pojo.Ride"%>
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
            $( "#dialogForRequests" ).dialog({
               autoOpen: false,
               title:"Add Requests"
            });
            /*$( "#openDialog" ).click(function() {
               $( "#dialogForRequests" ).dialog( "open" );
            });*/
         });
      </script>
<body>
	<div id="dialogForRequests"></div>
		<table>
		<tr>
		<th>Source</th>
		<th>Destination</th>
		<th>Start Time</th>
		<th>No. of Passengers</th>
		<th>Price per user</th>
		<th>Additional Pickup Points Available</th>
		<th>Price Negotiable</th>
		<th>Actions</th>
		</tr>
<%for(Ride ride : (ArrayList<Ride>)request.getAttribute("userRideList")){
%>	<tr>
		<td align="center"><%=ride.getStartPoint()%> </td>
		<td align="center"> <%=ride.getDestination()%> </td>
		<td align="center"> <%=ride.getStartTime()%></td> 
		<td align="center"> <%=ride.getMaxNoOfPassengers()%></td> 
		<td align="center"> <%=ride.getPricePerUser()%></td> 
<%
	if(ride.isPickupOtherThanStartProvided())
	{
%>
		<td align="center">Yes</td> 
<%
	}
	else{
%>
		<td align="center">No</td>
<%
	}
%>
<%
	if(ride.isPriceNegotiable())
	{
%>
		<td align="center">Yes</td> 
<%
	}
	else{
%>
		<td align="center">No</td>
<%
	}
%>
		<td> 
		<form method="post" action="../rmc/editRide">
			<input type="hidden" id="rideId" name="rideId" value="<%=ride.getRideId() %>"></input>
			<input type="submit" value="Edit Ride">
		</form>
		<input id="openDialog" type="button" onclick="showAllRequestsFilteredOnDate(<%=ride.getRideId()%>);" value="View All Requests"></input>
			<!--  <input type="button" onclick="deleteUsersRide(<%=ride.getRideId()%>);" value="Delete Ride"></input> 
			<input type="button" onclick="viewRideRequests(<%=ride.getRideId()%>);" value="View Requests"></input> 
			<input type="button" onclick="viewAndPostComments(<%=ride.getRideId()%>);" value="View & Post Comments"></input> 			
		--></td>
	</tr><%
} %>
</table>
</body>
<script src="../resources/js/show_ride.js"></script>
<script src="../resources/js/show_request.js"></script>
</html>