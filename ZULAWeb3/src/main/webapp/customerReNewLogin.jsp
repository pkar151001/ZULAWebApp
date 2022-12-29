<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZULA Cabs - New Registration</title>
<style>
div
{
	text-align:center;
	margin:0px;
	padding: 10px;
}
</style>
</head>
<body>
	<h2 style="text-align:center">New Registration Portal</h2>
	<h4 style="text-align:center">Some details might not be correct or missing....<br>Please fill again...</h4>
	<form action="http://localhost:8080/ZULAWeb3/customerNewLogin" method="post">
	<div>
	<label> Enter User Name </label>
	<input type="text" name="userName"></input>
	</div>
	<div>
	<label> Enter Password </label>
	<input type="password" name="userPass"></input>
	</div>
	<div>
	<label> Re-Enter Password </label>
	<input type="password" name="userPass2"></input>
	</div>
	<div>
	<label> Enter Age </label>
	<input type="number" name="age"></input>
	</div>
	<div>
	<button type="submit">Get Registered</button>
	</div>
	</form>
</body>
</html>