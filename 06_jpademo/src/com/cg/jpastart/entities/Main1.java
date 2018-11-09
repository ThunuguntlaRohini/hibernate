package com.cg.jpastart.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main1 {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();

		String myQuery = "from Student";
		Query query = em.createQuery(myQuery);
		List<Student> stuList = null;
		stuList = query.getResultList();
		System.out.println(stuList);

		em.getTransaction().begin();
		for (Student student2 : stuList) {
			student2.setName(student2.getName().toUpperCase());
			em.merge(student2);
			System.out.println(student2);
		}
		em.getTransaction().commit();

		em.close();
		factory.close();
	}
}
