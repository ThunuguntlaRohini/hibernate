package com.cg.jpastart.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;





public class Main {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();

		String myQuery="from Student";
		Query query= em.createQuery(myQuery);
		List<Student> stuList= null;
		stuList=query.getResultList();
		System.out.println(stuList);
		
		em.getTransaction().begin();
		Student student=em.find(Student.class, 2);
		em.getTransaction().commit();
		System.out.println(student);
		em.getTransaction().begin();
		Student student1=em.find(Student.class, 3);
		em.remove(student1);
		em.getTransaction().commit();
		
		
		em.close();
		factory.close();
	}
	

}
