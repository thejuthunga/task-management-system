package com.ty.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.entity.Employee;
import com.ty.entity.EmployeeDao;
@WebServlet(value = "/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("useremail");
		String psw=req.getParameter("password");
		System.out.println("1");
		Employee employee = EmployeeDao.findUser(email, psw);
		if(employee.getRole().equals("manager") && employee.getEmail().equals(email) && employee.getPassword().equals(psw)) {	
			RequestDispatcher dispatcher2 = req.getRequestDispatcher("ManagerDashBoard.jsp");
			dispatcher2.include(req, resp);
			System.out.println("2");
		
	     }else if(employee.getEmail().equals(email) && employee.getPassword().equals(psw)  ) {
	    	 System.out.println("3");
				HttpSession session = req.getSession();
				session.setAttribute("employee", employee);
				
				resp.sendRedirect("updateList");
		} else {
			System.out.println("4");
			RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
			req.setAttribute("message", "Failed Logged In");
			dispatcher.forward(req, resp);
		}
	}
}
