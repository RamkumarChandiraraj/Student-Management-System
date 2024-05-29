package com.sms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sms.dao.AdminDao;
import com.sms.dto.Admin;

public class AdminLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		String email=req.getParameter("adminEmail");
		String password=req.getParameter("adminPassword");

		Admin admin=new AdminDao().adminLogin(email, password);

		if(admin!=null)
		{
			HttpSession session=req.getSession();
			session.setAttribute("admin", admin);
			req.getRequestDispatcher("index.jsp").forward(req, res);
		}
		else {
			res.sendRedirect("AdminSignUp.jsp");
		}
	}
}
