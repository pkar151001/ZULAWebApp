<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contribution of Each Taxi - Results</title>
</head>
<body>
<h2>Results of Given Request</h2>
<br>
<br>
<%@ page import = "java.sql.*,ZULALogins.ZULAFetch.*,java.util.*" %>
<%	
	adminViewCheck resObj=(adminViewCheck)request.getAttribute("result");
	Total resTotal=resObj.totalObj;
	List<Ride> res= resObj.res;
%>
<p align="center"> Total Fare: <%=resTotal.getTotalFare() %> </p>
<p align="center"> Total Commission: <%=resTotal.getTotalComm() %> </p>
<p align="center"> Total Count: <%=resTotal.getTotalCount() %> </p>
<p align="center"> The Table </p>
<table align="center"><tr><th>Customer ID</th><th>Source Location</th><th>Destination Location</th><th>Fare</th><th>ZULA Commission</th></tr>
<%
	if(res!=null)
	{
		for (Ride r:res)
		{
			%>
			<tr><td><%=r.getCustomerId() %></td><td><%=r.getSource() %></td><td><%=r.getDest() %></td><td><%=r.getFare() %></td><td><%=r.getComm() %></td></tr>
			<% 
		}
	}
%>
</table>
</body>
</html>