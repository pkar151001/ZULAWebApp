<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZULA Cabs - Customer`s View</title>
<style>
th,td
{
	padding:15px;
}
a
{
  text-decoration:none;
}
</style>
</head>
<body>
<%@page import = "ZULALogins.ZULAVerify.*" %>
<% if(customerLoginCheck.userID!=0)
	{
%>
<h1 style="text-align:center">Customer`s Zone</h1>
<h2 style="text-align:center">View History of Rides</h2>
<%@ page import = "java.sql.*,ZULALogins.ZULAFetch.*,java.util.*" %>
<%	
	List<CustRide> res= (List<CustRide>)request.getAttribute("result");
%>
<table align="center"><tr><th>Cab ID</th><th>Source Location</th><th>Destination Location</th><th>Fare</th></tr>
<%
	if(res!=null)
	{
		for (CustRide r:res)
		{
			%>
			<tr><td><%=r.getCabid() %></td><td><%=r.getSource() %></td><td><%=r.getDestination() %></td><td><%=r.getFare() %></td></tr>
			<% 
		}
	}
%>
</table>
<%} 
	if(customerLoginCheck.userID==0)
	{
%>
<h1 style="text-align:center">Invalid Access !!!<br> Go to Home Page</h1>
<h2 style="text-align:center"><a href="http://localhost:8080/ZULAWeb3/HomeMenu.html">To Home Page......</a></h2>
<%} %>
</body>
</html>