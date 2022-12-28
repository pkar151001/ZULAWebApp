<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align:center">View History of Rides</h1>
	<br><br>
	<form action="http://localhost:8080/ZULAWeb3/adminViewCheck" method="POST">
	<div style="text-align:center; margin:0px; padding: 10px;">
	<label> Enter Cab ID </label>
	<input type="number" name="cabID"></input>
	<button type="submit">Click to View</button>
	</div>
	</form>
</body>
</html>