<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZULA Cabs - Reset the data</title>
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
	<h1 style="text-align:center">Data has been transformed back to its original form....</h1>
<%} 
	if(adminLogin.access==0)
	{
%>
<h1 style="text-align:center">Invalid Access !!!<br> Go to Home Page</h1>
<h2 style="text-align:center"><a href="http://localhost:8080/ZULAWeb3/HomeMenu.html">To Home Page......</a></h2>
<%} %>
</body>
</html>