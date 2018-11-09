package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main2 {

	public static void main(String[] args) {
		
		SeatInfo seatInfo= new SeatInfo(30, 20, 10);
		Trip trip= new Trip();
		trip.setFromCity("chennai");
		trip.setToCity("mumbai");
		trip.setInfo(seatInfo);
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(trip);
		em.getTransaction().commit();
		
		em.close();
		factory.close();
	}

}
