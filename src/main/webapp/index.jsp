<%@page import="com.sms.dto.Admin" %>
<html>
<body>
	<% Admin admin=(Admin) session.getAttribute("admin");
		if(admin!=null){
	%>
	<h1>Welcome Admin</h1>
	<h3>You can able to manage Student Data here....!!</h3>
	<div class="a">
		<a href="SaveStudent.jsp">Save_Student</a>
		<a href="ViewStudent.jsp">View_Student</a>
	</div>
	<%}
		else{
			response.sendRedirect("AdminLogin.jsp");
		}%>
		
	<div class="logout"><a href="adminLogout">Logout</a></div>
</body>
</html>
