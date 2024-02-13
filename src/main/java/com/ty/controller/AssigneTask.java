package com.ty.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Dao.TaskDao;
import com.ty.entity.Employee;
import com.ty.entity.EmployeeDao;
import com.ty.entity.Task;
@WebServlet(value = "/createtask")
public class AssigneTask extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Task task=new Task();
		
		String description = req.getParameter("description");
		task.setDescription(description);
		
		String status=req.getParameter("status");
		task.setStatus(status);
		
		String id = req.getParameter("employee");
		int eid = Integer.parseInt(id);
		if(eid != 0) {
		Employee employee = EmployeeDao.findById(eid);
		
		task.setEmployee(employee);
		

	    Task saveTask = TaskDao.saveTask(task);
		
		
	    if(saveTask != null) {
	    	RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
	    	req.setAttribute("message", "Successfully Task Created and Assigned ");
	    	dispatcher.include(req, resp);
	    	
	    	RequestDispatcher dispatcher2=req.getRequestDispatcher("task.jsp");
	    	dispatcher2.include(req, resp);
	    	
	    }else{
	    	RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
	    	req.setAttribute("message", "Failed to create task try again!..");
	    	dispatcher.include(req, resp);
	    	
	    	RequestDispatcher dispatcher2=req.getRequestDispatcher("task.jsp");
	    	dispatcher2.include(req, resp);
	    }
		}else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("display.jsp");
	    	req.setAttribute("message", "Failed to create task try again!..");
	    	dispatcher.include(req, resp);
	    	
	    	RequestDispatcher dispatcher2=req.getRequestDispatcher("task.jsp");
	    	dispatcher2.include(req, resp);
		}
	}
}
