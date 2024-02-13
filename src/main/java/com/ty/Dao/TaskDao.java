package com.ty.Dao;

import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.ty.entity.Employee;
import com.ty.entity.Task;
import com.ty.helper.HelperClass;

public class TaskDao {
	static EntityManagerFactory factory = HelperClass.factory;
	 static EntityManager manager=factory.createEntityManager();
	static EntityTransaction transaction=manager.getTransaction();
	 
	 public static Task saveTask(Task task) {
		 
		
		 
		 transaction.begin();
		 manager.persist(task);
		 transaction.commit();
		 
		 return task;
	 }
	 
	 public static List<Task> findAll(){
		 
		    String sql="select t from Task t";
		 
			Query query = manager.createQuery(sql);
			
			List<Task> tasks  = query.getResultList();
			
		    return tasks;
	 }
	 
	 public static Task findById(int id) {
		 Task task = manager.find(Task.class, id);
		 
		 return task;
	 }
	
	 public static Task UpdateTask(Task task) {
		 
		 transaction.begin();
		 manager.merge(task);
		 transaction.commit();
		 
		 return task;
		 
	 }
}
