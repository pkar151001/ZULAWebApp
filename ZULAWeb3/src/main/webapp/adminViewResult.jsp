<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contribution of Each Taxi - Results</title>
<style>
a
{
  text-decoration:none;
}
</style>
</head>
<body>
<%@page import = "ZULALogins.*" %>
<% if(adminLogin.access==1)
	{
%>
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
<%} 
	if(adminLogin.access==0)
	{
%>
<h1 style="text-align:center">Invalid Access !!!<br> Go to Home Page</h1>
<h2 style="text-align:center"><a href="http://localhost:8080/ZULAWeb3/HomeMenu.html">To Home Page......</a></h2>
<%} %>
</body>
</html>