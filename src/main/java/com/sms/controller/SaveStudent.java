package com.sms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.dao.StudentDao;
import com.sms.dto.Admin;
import com.sms.dto.Student;

@WebServlet("/saveStudent")
public class SaveStudent extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException,ServletException {
		HttpSession session=req.getSession();
		Admin admin=(Admin)session.getAttribute("admin");

		if(admin!=null) {
			String name=req.getParameter("studentName");
			Long phoneNumber=Long.parseLong(req.getParameter("studentPhoneNumber"));
			String email=req.getParameter("studentEmail");
			double percentage=Double.parseDouble(req.getParameter("studentPercentage"));

			Student student = new Student();
			student.setStudentName(name);
			student.setPhoneNumber(phoneNumber);
			student.setStudentEmail(email);
			student.setStudentPercentage(percentage);
			student.setAdmin(admin);

			new StudentDao().saveStudent(student);

			List<Student> students=admin.getStudents();
			students.add(student);

			resp.sendRedirect("index.jsp");
		}
		else {
			resp.sendRedirect("AdminLogin.jsp");
		}
	}
}
