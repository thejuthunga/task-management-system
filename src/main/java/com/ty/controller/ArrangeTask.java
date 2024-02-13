package com.ty.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.Dao.TaskDao;
import com.ty.entity.Task;
import com.ty.helper.TaskSorting;
@WebServlet(value = "/arrange")
public class ArrangeTask extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Task> tasks = TaskDao.findAll();
		List<Task> sortedTaskList = TaskSorting.sortTask(tasks);
		req.setAttribute("taskList", sortedTaskList);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("viewTask.jsp");
		dispatcher.forward(req, resp);
	}
}
