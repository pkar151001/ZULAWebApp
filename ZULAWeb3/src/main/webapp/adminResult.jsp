<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
th,td
{
	padding:15px;
}
</style>
</head>
<body>
<h1 style="text-align:center"> The Overall History of Rides</h1>
<%@ page import = "java.sql.*,ZULALogins.ZULAFetch.*,java.util.*" %>
<%	
	List<Ride> res=(List<Ride>)request.getAttribute("result");
%>
<table align="center"><tr><th >Cab ID</th><th>Driver Name</th><th>Customer ID</th><th style="padding:15px">Customer Name</th><th style="padding:15px">Source Location</th><th style="padding:15px">Destination Location</th><th style="padding:15px">Fare</th><th style="padding:15px">ZULA Commission</th></tr>
<%
	if(res!=null)
	{
		for (Ride r:res)
		{
			%>
			<tr><td><%=r.getCabId() %></td><td><%=r.getDriverName() %></td><td><%=r.getCustomerId() %></td><td><%=r.getCustomerName() %></td><td><%=r.getSource() %></td><td><%=r.getDest() %></td><td><%=r.getFare() %></td><td><%=r.getComm() %></td></tr>
			<% 
		}
	}
%>
</table>
</body>
</html>