<%@page import="com.hibernate.test.pojo.RequestRideMapping"%>
<%@page import="java.util.List"%>
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
		<th>Actions</th>
		</tr>
<%ArrayList<Request> allRequests = (ArrayList<Request>)request.getAttribute("allRequests");
for(Request requests : allRequests){
	%><tr>
	<td align="left"><%=requests.getPickupPlace()%> </td>
	<td align="left"> <%=requests.getDestination()%> </td>
	<td align="center"> <%=requests.getStartTime()%></td> 
	<td>
		<input type="button" onclick="showAllRidesFilteredOnDate(<%=requests.getRequest_id()%>);" value="View All Rides"></input>
	</td>
	</tr><%
	if(requests.getRequestRideMappings()!=null && requests.getRequestRideMappings().size()>0){
		List<RequestRideMapping> rrm = requests.getRequestRideMappings();
		for(RequestRideMapping requestRideMapping : rrm){
			%>
			<tr>
				<td colspan="3">&nbsp &nbsp <i><b><%=requestRideMapping.getRide().getRideOwner().getFirstName()%></b>(<b><%=requestRideMapping.getRide().getRideOwner().getEmailAddress() %></b>) will leave for <b><%=requestRideMapping.getRide().getDestination() %></b> from <b><%=requestRideMapping.getRide().getStartPoint() %></b> at <b><%=requestRideMapping.getRide().getStartTime() %></b></i></td>
			</tr>
			<%
		}
	}
} %>
</table>

</body>
<script src="../resources/js/show_ride.js"></script>
</html>