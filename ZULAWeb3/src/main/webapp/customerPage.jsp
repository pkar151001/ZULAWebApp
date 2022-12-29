<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZULA Cabs -  Customer`s Portal</title>
<style>
div.container {
  text-align: center;
}
ul.List {
  list-style-type: none;
  margin: 0;
  padding: 0;
  width: 200px;
  background-color: #f1f1f1;
  display: inline-block;
  text-align: left;
}
li button{
  display: block;
  color: #000;
  padding: 8px 16px;
  text-decoration: none;
  margin: 0;
  padding: 0;
  border:0;
  width: 200px;
  height: 100px;
}
li button:hover {
  background-color: #555;
  color: white;
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
	<h1 style="text-align:center"> Welcome Customer! </h1>
<br>
<br>
<br>

<div class="container">
<ul class="List">
<li>
    <a href="http://localhost:8080/ZULAWeb3/customerRide.jsp"><button type="submit">Book a Ride</button></a>
</li>
<li>
   <a href="http://localhost:8080/ZULAWeb3/customerView"><button type="submit">View History of Rides</button></a>
</li>
</ul>
</div>
<%} 
	if(customerLoginCheck.userID==0)
	{
%>
<h1 style="text-align:center">Invalid Access !!!<br> Go to Home Page</h1>
<h2 style="text-align:center"><a href="http://localhost:8080/ZULAWeb3/HomeMenu.html">To Home Page......</a></h2>
<%} %>
</body>
</html>