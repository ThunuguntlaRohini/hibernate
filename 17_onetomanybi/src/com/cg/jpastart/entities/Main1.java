package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main1 {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Department d=new Department();
		d=em.find(Department.class, 10);
				System.out.println(d.getName()+d.getEmployees().size());
			for (Employee e : d.getEmployees()) {
				System.out.println(e.getName()+"_"+e.getSalary());
				
			}
				em.getTransaction().commit();
				em.close();
				factory.close();
	}
}
