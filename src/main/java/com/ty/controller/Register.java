package com.ty.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.entity.Employee;
import com.ty.entity.EmployeeDao;
@WebServlet(value = "/register")
public class Register extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Employee employee = new Employee();
		
		employee.setName(req.getParameter("username"));
		employee.setEmail(req.getParameter("email"));
		employee.setPassword(req.getParameter("psw"));
		employee.setRole(req.getParameter("role"));
		employee.setDesignation(req.getParameter("designation"));
		
		Double sal=Double.parseDouble(req.getParameter("salary")); 
		System.out.println(sal);
		employee.setSalary(sal);
		
		Employee saveEmp = EmployeeDao.saveUser(employee);
		
		if(saveEmp != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
			req.setAttribute("message", "Sussfully Registered");
			dispatcher.include(req, resp);
			RequestDispatcher dispatcher2 = req.getRequestDispatcher("welcome.jsp");
			dispatcher2.include(req, resp);
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
			req.setAttribute("message", "Failed Register try again");
			dispatcher.include(req, resp);
			
			RequestDispatcher dispatcher2 = req.getRequestDispatcher("register.jsp");
			dispatcher2.include(req, resp);
		}
	}
}
