<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student_Management_System</title>
</head>
<body>
	<form action="adminLogin" method="post">
	<h2>Admin Login</h2>
		<input name="adminEmail" placeholder="Enter Your Email" type="email"><br><br>
		<input name="adminPassword" placeholder="Enter Your Password" 
			type="password"><br><br>
		<input type="submit" class="btn" value="Login">
	</form>
</body>
</html>