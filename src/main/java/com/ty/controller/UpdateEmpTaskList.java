package com.ty.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.Dao.TaskDao;
import com.ty.entity.Employee;
import com.ty.entity.Task;
import com.ty.helper.UpdateEmployeeStatus;
@WebServlet(value = "/updateList")
public class UpdateEmpTaskList extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		System.out.println("10");
		
		Object object = session.getAttribute("employee");
		System.out.println("20");
		Employee e=null;
		if(object != null) {
			e=(Employee)object;
		}
		if(e.getTasks() != null && !e.getTasks().isEmpty()) {
		List<Task> taskList = UpdateEmployeeStatus.taskList(e.getId());
		System.out.println("30");
		
		ServletContext context = getServletContext();
		context.setAttribute("TaskList", taskList);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("EmployeeDashBoar.jsp");
		System.out.println("40");
		dispatcher.forward(req, resp);
		}else {
			System.out.println("50");
			RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
			req.setAttribute("message", "No Task Assigned to This Employee");
			dispatcher.include(req, resp);
			
			System.out.println("60");
			PrintWriter writer = resp.getWriter();
			writer.print("<form action='welcome.jsp' method='post'> <input type='submit' value='Back'></form>");
			
			
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String taskid = req.getParameter("taskid");
		
		int tid = Integer.parseInt(taskid);
		
		Task task = TaskDao.findById(tid);
		
		task.setStatus("Completed");
		task.setCompletedDateTime(java.time.LocalDateTime.now());
		
		Task updateTask = TaskDao.UpdateTask(task);
		
		if(updateTask != null) {
			System.out.println("10");
			
			ServletContext context = getServletContext();
			context.setAttribute("TaskList", updateTask.getEmployee().getTasks());
			resp.sendRedirect("EmployeeDashBoar.jsp");
		}
	}
}
