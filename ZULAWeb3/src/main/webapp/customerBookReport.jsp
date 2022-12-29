<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZULA Cabs - Booking Report</title>
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
<h1 align="center"> Booking Successful !!!</h1>
<%@ page import = "java.sql.*,java.util.*,ZULALogins.ZULARegistration.curr,ZULALogins.ZULARegistration.Report" %>
<%	
	Report currReport=(Report)request.getAttribute("result");
	List<curr> init=(List <curr>)request.getAttribute("init");
	List<curr> fin=(List <curr>)request.getAttribute("fin");
%>
<br><br>
<h2 align="center">Current Status of Drivers - Before Booking</h2>
<table align="center">
<tr><th>Cab ID</th><th>Current Location</th><th>Number of Rides performed</th><th>Current Status</th></tr>
<%
	if(init!=null)
	{
		for (curr r:init)
		{
			%>
			<tr><td><%=r.getId() %></td><td><%=r.getCurrloc() %></td><td><%=r.getRides() %></td><td><%=r.getStatus() %></td></tr>
			<% 
		}
	}
%>
</table>
<br><br>
<h2 align="center">Booking Report</h2>
<table align="center">
<tr><td>Customer ID: </td><td><%= currReport.getCustomerId()%></td></tr>
<tr><td>Customer Name: </td><td><%= currReport.getCustomerName()%></td></tr>
<tr><td>Cab ID : </td><td><%= currReport.getCabId()%></td></tr>
<tr><td>Driver Name: </td><td><%= currReport.getDriverName()%></td></tr>
<tr><td>Source: </td><td><%= currReport.getSource()%></td></tr>
<tr><td>Destination: </td><td><%= currReport.getDest()%></td></tr>
<tr><td>Distance (in units): </td><td><%= currReport.getDist()%></td></tr>
<tr><td>Fare (in Rupees): </td><td><%= currReport.getFare()%></td></tr>
</table>
<br><br>
<h2 align="center">Current Status of Drivers - After Booking</h2>
<table align="center">
<tr><th>Cab ID</th><th>Current Location</th><th>Number of Rides performed</th><th>Current Status</th></tr>
<%
	if(fin!=null)
	{
		for (curr r:fin)
		{
			%>
			<tr><td><%=r.getId() %></td><td><%=r.getCurrloc() %></td><td><%=r.getRides() %></td><td><%=r.getStatus() %></td></tr>
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