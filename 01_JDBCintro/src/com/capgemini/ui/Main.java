package com.capgemini.ui;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.capgemini.business.Customer;
import com.capgemini.db.CustomerDAO;
import com.capgemini.db.CustomerDAOImpl;

public class Main {

	public static void add() throws ClassNotFoundException, SQLException {
		int id = 0;
		String name = null;
		String city = null;
		double amt = 0.0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter id:");
		id = scanner.nextInt();
		System.out.println("enter name:");
		name = scanner.next();
		System.out.println("enter city:");
		city = scanner.next();
		System.out.println("enter out standing amount: ");
		amt = scanner.nextDouble();
		Customer customer = new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setCity(city);
		customer.setOutStandingAmount(amt);
		CustomerDAO dao = new CustomerDAOImpl();
		boolean result = dao.addCustomer(customer);
		if (result == true) {
			System.out.println("record added sucessfully");
		} else {
			System.out.println("not added");
		}
		scanner.close();
	}

	public static void update() throws ClassNotFoundException, SQLException {
		int id = 0;
		String name = null;
		String city = null;
		double amt = 0.0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter id:");
		id = scanner.nextInt();
		System.out.println("enter name:");
		name = scanner.next();
		System.out.println("enter city:");
		city = scanner.next();
		System.out.println("enter out standing amount: ");
		amt = scanner.nextDouble();
		Customer customer = new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setCity(city);
		customer.setOutStandingAmount(amt);
		CustomerDAO dao = new CustomerDAOImpl();
		boolean result = dao.updateCustomer(customer);
		if (result == true) {
			System.out.println("record updated sucessfully");
		} else {
			System.out.println("not updated");
		}
		scanner.close();
	}

	public static void display() throws ClassNotFoundException, SQLException {
		CustomerDAO dao = new CustomerDAOImpl();
		List<Customer> customerList = dao.getAllCustomers();
		// System.out.println(customerList);
		for (Customer customer : customerList) {
			System.out.print("\t" + customer.getId());
			System.out.print("\t" + customer.getName());
			System.out.print("\t" + customer.getCity());
			System.out.println("\t" + customer.getOutStandingAmount());

		}
	}

	public static void remove() throws ClassNotFoundException, SQLException {
		int inp_id = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id to remove");
		inp_id = scanner.nextInt();

		CustomerDAO dao = new CustomerDAOImpl();
		boolean result = dao.removeCustomer(inp_id);
		if (result == true) {
			System.out.println("record deleted sucessfully");
		} else {
			System.out.println("not found");
		}

		scanner.close();

	}

	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		System.out.println("Customer Application");
		System.out.println("....................");
		System.out.println("1.add new customer");
		System.out.println("2.update customer");
		System.out.println("3.display all customers");
		System.out.println("4.delete customer");
		System.out.println("5.exit");
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter choice");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			add();
			break;
		case 2:
			update();
			break;
		case 3:
			display();
			break;
		case 4:
			remove();
			break;
		case 5:
			System.out.println("Thank you");
			System.exit(0);
			break;

		}
		scanner.close();

	}

}
