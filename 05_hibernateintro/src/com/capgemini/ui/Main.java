package com.capgemini.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.capgemini.business.Employee;

public class Main {
	public static void main(String[] args) {
		
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em= emf.createEntityManager();
	
	Employee employee = new Employee();
	employee.setEmpid(102);
	employee.setEmpname("Rohit");
	employee.setBasicSalary(7055);
	employee.setEmpGender('M');
	employee.setEmpgrade('A');

	EntityTransaction t = em.getTransaction();
	t.begin();
	
	em.persist(employee);
	t.commit();
	em.close();
	System.out.println("object is stored in db");
	
	}
}