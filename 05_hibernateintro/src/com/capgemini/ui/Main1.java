package com.capgemini.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.business.Employee;

public class Main1 {

	public static void main(String[] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em= emf.createEntityManager();
		
		Employee e=null;
		e= em.find(Employee.class, 102);
		System.out.println(e);
		
		em.close();
		emf.close();
	
	}
}
