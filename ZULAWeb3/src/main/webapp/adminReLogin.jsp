<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZULA Cabs - Administrator Login</title>
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
	<h1 style="text-align:center">Welcome to Adminstrator`s Portal</h1>
	<h3 style="text-align:center">Login to Manage Rides </h3>
	<br>
	<h4 style="text-align:center">Wrong Username / Password.....<br>Please Re-Enter your Credentials or Register as a New User </h4>
	<br>
	<form action="http://localhost:8080/ZULAWeb3/adminLogin" method="post">
	<div>
	<label> Enter User Name </label>
	<input type="text" name="userName"></input>
	</div>
	<div>
	<label> Enter Password </label>
	<input type="password" name="userPass"></input>
	</div>
	<div>
	<button type="submit">Login</button>
	</div>
	</form>
</body>
</html>