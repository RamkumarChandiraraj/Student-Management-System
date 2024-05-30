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

@WebServlet("/viewStudents")
public class GetAllStudents extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession();
		Admin admin=(Admin)session.getAttribute("admin");

		if(admin!=null) {

			List<Student> students=new StudentDao().getAllStudents(admin);

			req.setAttribute("students", students);

			req.getRequestDispatcher("ViewStudents.jsp").forward(req, resp);
		}
		else {
			resp.sendRedirect("AdminLogin.jsp");
		}
	}
}
