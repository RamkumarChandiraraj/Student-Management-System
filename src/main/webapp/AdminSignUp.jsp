<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student_Management_System</title>
</head>
<body>
	<form action="signUp" method="post">
		<h2>Admin SignUp</h2>
		<input name="AdminName" placeholder="Enter Name:" type="text"><br><br>
		<input name="AdminEmail" placeholder="Enter Email:" type="email"><br><br>
		<input name="AdminPassword" placeholder="Enter password" type="password"><br><br>
		<input type="submit" class="btn" value="SignUp">
	</form>
</body>
</html>