<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZULA Cabs - Book a Ride </title>
<style>
div
{
	text-align:center;
	margin:0px;
	padding:10px;
}
a
{
  text-decoration:none;
}
</style>
</head>
<body>

<%@page import = "ZULALogins.ZULAVerify.*"%>
<% if(customerLoginCheck.userID!=0)
	{
%>
	<br><br>
	<form action="http://localhost:8080/ZULAWeb3/customerRide" method="post">
	<div>
	<label> Source Location</label>
	<select name="source" id="source">
	<option value="A">A</option>
	<option value="B">B</option>
	<option value="C">C</option>
	<option value="D">D</option>
	<option value="E">E</option>
	<option value="F">F</option>
	<option value="G">G</option>
	<option value="H">H</option>
	</select>
	</div>
	<br><br>
	<div>
	<label> Destination Location</label>
	<select name="destination" id="destination">
	<option value="A">A</option>
	<option value="B">B</option>
	<option value="C">C</option>
	<option value="D">D</option>
	<option value="E">E</option>
	<option value="F">F</option>
	<option value="G">G</option>
	<option value="H">H</option>
	</select>
	</div>
	<div>
	<button type="submit">Register for a Cab</button>
	</div>
	</form>
<%} 
	if(customerLoginCheck.userID==0)
	{
%>
<h1 style="text-align:center">Invalid Access !!!<br> Go to Home Page</h1>
<h2 style="text-align:center"><a href="http://localhost:8080/ZULAWeb3/HomeMenu.html">To Home Page......</a></h2>
<%} %>
</body>
</html>