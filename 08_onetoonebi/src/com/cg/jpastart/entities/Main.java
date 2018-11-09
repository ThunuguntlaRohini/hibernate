package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();


		Address a = em.find(Address.class, 2);
		System.out.println(a.getCity() +" "+ a.getZipCode()+ " "+a.getStudent().getName());
	
		Student student= em.find(Student.class, 6);
		System.out.println(student.getName() +" "+ student.getAddress().getCity()+" "+ student.getAddress().getZipCode());
	
	}

}
