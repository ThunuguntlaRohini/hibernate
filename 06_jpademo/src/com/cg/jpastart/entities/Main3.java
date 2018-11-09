package com.cg.jpastart.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main3 {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		
		em.getTransaction().begin();
		Trip trip=em.find(Trip.class, 1);
		SeatInfo seatInfo= new SeatInfo(30, 20, 10);
		trip.setInfo(seatInfo);
		em.merge(trip);
		System.out.println(trip.getInfo());
		em.getTransaction().commit();
		
		em.close();
		factory.close();
	}

}
