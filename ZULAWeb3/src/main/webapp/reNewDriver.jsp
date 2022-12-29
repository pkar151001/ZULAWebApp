<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZULA Cabs - New Cab Registration</title>
<style>
div
{
	text-align:center;
	margin:0px;
	padding: 10px;
}
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
	<h2 style="text-align:center">New Cab Registration Portal</h2>
	<h4 style="text-align:center">The details might have been missed....<br>Please Enter the Details again</h4>
	<form action="http://localhost:8080/ZULAWeb3/newDriver" method="post">
	<div>
	<label> Enter Driver Name </label>
	<input type="text" name="userName"></input>
	</div>
	<div>
	<label> Enter Password </label>
	<input type="password" name="userPass"></input>
	</div>
	<div>
	<label> Enter Age </label>
	<input type="number" name="age"></input>
	</div>
	<div>
	<label> Enter Initial Location </label>
	<select name="init" id="init">
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
	<button type="submit">Get Registered</button>
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