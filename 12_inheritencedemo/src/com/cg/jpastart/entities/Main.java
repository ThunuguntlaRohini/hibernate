package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Employee employee = null;

		employee = em.find(Employee.class, 3);

		System.out.println(employee);
		System.out.println(employee instanceof Employee);
		System.out.println(employee instanceof Manager);
		System.out.println(employee instanceof ContractEmployee);
		
		if(employee instanceof Manager){
			Manager m=(Manager) employee;
			System.out.println(m.getDepartmentName());
			System.out.println(m.getName());
			System.out.println(m.getSalary());
		}
		
		if(employee instanceof ContractEmployee){
		ContractEmployee c= (ContractEmployee) employee;
		System.out.println(c.getDuration());
		System.out.println(c.getName());
		System.out.println(c.getSalary());
			
		}
		if(employee instanceof Employee){
			Employee e= (Employee) employee;
			
			System.out.println(e.getName());
			System.out.println(e.getSalary());
		
				
			}
		
		
		
		em.close();
		factory.close();
		}

}
