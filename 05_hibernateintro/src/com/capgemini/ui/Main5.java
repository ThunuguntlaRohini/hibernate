package com.capgemini.ui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.business.Contact;

public class Main5 {

	public static void main(String[] args) {
	Contact contact1= new Contact(101, "rohini", "9059900989");
	Contact contact2= new Contact(102, "satya", "9247144559");
	Contact contact3= new Contact(103, "sasi", "9248444559");
	
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();
	
	em.getTransaction().begin();
	//em.persist(contact1);//attaches the contact to database 
	//em.persist(contact2);
	//em.persist(contact3);
	contact3.setPhonenumber("9290872464");
	em.merge(contact3);//updates the 3rd phone no
	em.getTransaction().commit();
	em.close();
	emf.close();
	
	Contact contact4= null;
	emf=Persistence.createEntityManagerFactory("JPA-PU");
	em=emf.createEntityManager();
	contact4=em.find(Contact.class, 102);
	contact4.setPhonenumber("9123456789");

	em.merge(contact4);
	
	System.out.println(contact4.equals(contact2));
	em.close();
	emf.close();
	
	}

}
