<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZULA Cabs - Contributions</title>
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
	<h1 style="text-align:center">View Contribution of Cabs</h1>
	<br><br>
	<form action="http://localhost:8080/ZULAWeb3/adminViewCheck" method="POST">
	<div style="text-align:center; margin:0px; padding: 10px;">
	<label> Enter Cab ID </label>
	<select name="cabID" id="cabID">
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	</select>
	<button type="submit">Click to View</button>
	</div>
	</form>
<%} 
	if(adminLogin.access==0)
	{
%>
<h1 style="text-align:center">Invalid Access !!!<br> Go to Home Page</h1>
<h2 style="text-align:center"><a href="http://localhost:8080/ZULAWeb3/HomeMenu.html">To Home Page......</a></h2>
<%} %>
</body>
</html>