<%@page import="com.sms.dto.Admin" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student_Management_System</title>
</head>
<body>
	<%
		Admin admin=(Admin)session.getAttribute("admin");
	if(admin!=null){
	%>
		<form action="saveStudent" method="post">
			<h2>Save Student Data</h2>
			<input name="studentName" placeholder="Enter Student Name: " type="text"> <br><br>
			<input name="studentPhoneNumber" placeholder="Enter Student PhoneNumber: " type="text"> <br><br>
			<input name="studentEmail" placeholder="Enter Student Email: " type="email"> <br><br>
			<input name="studentPercentage" placeholder="Enter Student Percentagre:" type="text"> <br><br>
			<input type="submit" class="btn" value="Save">
		</form>
		<% } else{
			response.sendRedirect("AdminLogin.jsp");
		}%>
</body>
</html>