package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
	
		Address address= em.find(Address.class, 2);
		System.out.println(address.getStreet()+"  "+address.getCity()+"  "+address.getState()+"  "+address.getZipCode());
	
		Student student= em.find(Student.class, 7);
		System.out.println(student.getName()+"  "+student.getAddress().getStreet()+" "+ student.getAddress().getCity()+" "+student.getAddress().getState()+"  "+student.getStudentId());
		
		
		
		em.close();
		factory.close();
	}

}
