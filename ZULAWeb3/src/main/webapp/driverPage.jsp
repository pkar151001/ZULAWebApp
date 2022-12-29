<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZULA Cabs - Driver`s Zone</title>
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
<%@ page import = "java.sql.*,ZULALogins.ZULAFetch.*,java.util.*" %>
<%	
	List<Ride> res= (List<Ride>)request.getAttribute("result");
%>
<%
	if(res!=null)
	{
%>		
<h1 style="text-align:center">Driver`s Zone</h1>
<h2 style="text-align:center">View History of Rides</h2>

<table align="center"><tr><th>Customer ID</th><th>Source Location</th><th>Destination Location</th><th>Fare</th><th>ZULA Commission</th></tr>
<% 
		for (Ride r:res)
		{
			%>
			<tr><td><%=r.getCustomerId() %></td><td><%=r.getSource() %></td><td><%=r.getDest() %></td><td><%=r.getFare() %></td><td><%=r.getComm() %></td></tr>
			<% 
		}
	}
%>
</table>
<%
	if(res==null)
	{
%>
	<h1 style="text-align:center">Invalid Access !!!<br> Go to Home Page</h1>
	<h2 style="text-align:center"><a href="http://localhost:8080/ZULAWeb3/HomeMenu.html">To Home Page......</a></h2>
<%
	} 
%>
</body>
</html>