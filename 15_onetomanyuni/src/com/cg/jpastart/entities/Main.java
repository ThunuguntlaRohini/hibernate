package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Department department= new Department();
		department=em.find(Department.class, 20);
		System.out.println(department);
		em.getTransaction().commit();
		em.close();
		factory.close();
		
	}

}
