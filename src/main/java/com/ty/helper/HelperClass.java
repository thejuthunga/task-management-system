package com.ty.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HelperClass {
	public static EntityManagerFactory factory;
	public static EntityManager manager;
	public static EntityTransaction transaction;
	static {
		factory=Persistence.createEntityManagerFactory("teju");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}
	public static EntityManagerFactory getFactory() {
		return factory;
	}
	public static void setFactory(EntityManagerFactory factory) {
		HelperClass.factory = factory;
	}
	public static EntityManager getManager() {
		return manager;
	}
	public static void setManager(EntityManager manager) {
		HelperClass.manager = manager;
	}
	public static EntityTransaction getTransaction() {
		return transaction;
	}
	public static void setTransaction(EntityTransaction transaction) {
		HelperClass.transaction = transaction;
	}
	
}
