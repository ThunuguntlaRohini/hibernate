package com.capgemini.ui;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.business.Employee;

public class Main2 {

	public static void main(String[] args) {
		
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em= emf.createEntityManager();
		
		String myQuery="from Employee";
		Query query= em.createQuery(myQuery);
		List<Employee> empList= null;
		empList=query.getResultList();
		System.out.println(empList);
		
	}
}
