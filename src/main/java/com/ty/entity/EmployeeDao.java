package com.ty.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class EmployeeDao{
	
	 static EntityManagerFactory factory = Persistence.createEntityManagerFactory("teju");
	 static EntityManager manager=factory.createEntityManager();
	 static EntityTransaction transaction=manager.getTransaction();
	
	public static Employee saveUser(Employee employee) {
		
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
		
		return employee;
	}
	public static Employee findById(int id) {
		Employee employee = manager.find(Employee.class, id);
		
		return employee;
	}
	public static Employee findUser(String email,String psw) {
		
		String sql="select e from Employee e where e.email=?1 and e.password=?2";
		
		Query query = manager.createQuery(sql);
		query.setParameter(1, email);
		query.setParameter(2, psw);
		if(query != null) {
		List resultList = query.getResultList();
		
		if(resultList != null) {
			System.out.println(resultList.get(0)+"10");
			Employee employee=(Employee)resultList.get(0);
			return employee;
		}else {
			return null;
		}
		}
		return null;
	}
	
	public static List<Employee> findAll() {
		String sql="select e from Employee e where e.role=?1";
		
		Query query = manager.createQuery(sql);
		query.setParameter(1, "employee");
		
		List<Employee> employeeList = query.getResultList();
		
	    return employeeList;
	}
	
}
