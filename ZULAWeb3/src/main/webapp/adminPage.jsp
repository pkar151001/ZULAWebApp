<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZULA Cabs - Administrator`s Zone</title>
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
<h1 style="text-align:center"> Administrator`s Play Ground </h1>
<br>
<br>
<br>
<div class="container">
<ul class="List">
<li>
    <a href="http://localhost:8080/ZULAWeb3/adminViewCheck.jsp"><button type="submit">Check the Contribution of Each Cab</button></a>
</li>
<li>
   <a href="http://localhost:8080/ZULAWeb3/adminResult"><button type="submit">Overall History of Rides</button></a>
</li>
<li>
	<a href="http://localhost:8080/ZULAWeb3/reset"><button type="submit">Reset to Original Data</button></a>
</li>
</ul>
</div>
</body>
</html>