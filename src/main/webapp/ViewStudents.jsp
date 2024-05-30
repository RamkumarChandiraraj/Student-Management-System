<%@page import="com.sms.dto.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.sms.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Admin admin=(Admin)session.getAttribute("admin");
	if(admin!=null){
		List<Student> students=(List)request.getAttribute("students");
	%>
	<h1>Students List</h1>
	
	<table border="2">
		<tr>
			<th>Student_Id</th>
			<th>Student_Name</th>
			<th>Student_Email</th>
			<th>Student_Phone</th>
			<th>Student_Percentage</th>
		</tr>
		
		<%for(Student student:students){ %>
		<tr>
			<td><%= student.getStudentId()%></td>
			<td><%= student.getStudentName() %></td>
			<td><%= student.getStudentEmail() %></td>
			<td><%= student.getPhoneNumber() %></td>
			<td><%= student.getStudentPercentage() %></td>
		</tr>
		<% } %>
	</table>
		<div><a href="index.jsp">Home</a></div>
		<%}else{
				response.sendRedirect("AdminLogin.jsp");
		} %>
</body>
</html>