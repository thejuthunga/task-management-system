package com.ty.helper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.ty.entity.Task;

public class TaskSorting {
	public static List<Task> sortTask(List<Task> tasks){
		
		Comparator<Task> comparator = new Comparator<Task>() {

			@Override
			public int compare(Task t1, Task t2) {
				if(t1.getStatus().equals("assigned") && !t2.getStatus().equals("assigned")) {
					return -1;
				}else if(!t1.getStatus().equals("assigned") && t2.getStatus().equals("assigned")) {
					return 1;
				}else {
					return 0;
				}
			}
			
			
		};
		
		Collections.sort(tasks, comparator);
		
		
		return tasks;
	}
}
