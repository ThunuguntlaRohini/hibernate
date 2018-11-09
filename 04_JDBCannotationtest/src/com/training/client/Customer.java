package com.training.client;

@Table(name = "Customer")
@Entity
public class Customer {

	@Id
	int id;

	@Column(name = "c_name", size = 25, notNull = true)
	String name;

	@Column(name = "c_city", size = 25, notNull = true)
	String city;

	double outStandingAmount;
}
