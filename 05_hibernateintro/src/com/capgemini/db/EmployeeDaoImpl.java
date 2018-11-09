package com.capgemini.db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.business.Employee;

public class EmployeeDaoImpl implements EmployeeDAO {

	public boolean addEmployee(Employee employee) {
		try {

			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("JPA-PU");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.persist(employee);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public boolean removeEmployee(int id) {

		try {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("JPA-PU");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.find(Employee.class, id);
			em.remove(id);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateEmployee(Employee employee) {
		try {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("JPA-PU");
			EntityManager em = emf.createEntityManager();

			em.getTransaction().begin();
			em.merge(employee);
			em.getTransaction().commit();
			em.close();
			emf.close();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Employee findEmployee(int id) {
		Employee e = null;
		try {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("JPA-PU");
			EntityManager em = emf.createEntityManager();
			e = em.find(Employee.class, id);
			em.close();
			emf.close();
			return e;

		} catch (Exception e1) {
			return e;
		}
	}


	public List<Employee> getAllEmployees() {
		List<Employee> empList = null;
		try {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory("JPA-PU");
			EntityManager em = emf.createEntityManager();

			Query q = em.createNamedQuery("from employee");
			empList = q.getResultList();
			em.close();
			emf.close();
			return empList;
			
		} catch (Exception e) {
			return empList;
		}

	}

}
