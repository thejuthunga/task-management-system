package com.ty.helper;

import java.util.List;

import com.ty.entity.Employee;
import com.ty.entity.EmployeeDao;
import com.ty.entity.Task;

public class UpdateEmployeeStatus {
	public static List<Task> taskList(int eid){
		Employee byId = EmployeeDao.findById(eid);
		
		List<Task> tasks = byId.getTasks();
		
		
		
		return tasks;
	}
}
