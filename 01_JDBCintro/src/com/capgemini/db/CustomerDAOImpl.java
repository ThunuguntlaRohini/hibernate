package com.capgemini.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.capgemini.business.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public boolean addCustomer(Customer customer) throws SQLException, ClassNotFoundException {
		Connection connection = ConnectionManager.CreateConnection();
		String SQL="insert into Customer values(?,?,?,?)";
		PreparedStatement statement= connection.prepareStatement(SQL);
		statement.setInt(1, customer.getId());
		statement.setString (2, customer.getName());
		statement.setString (3, customer.getCity());
		statement.setDouble(4, customer.getOutStandingAmount());
		int r=statement.executeUpdate();
		if(r>0){
			return true;
		}
				
		return false;
	}

	@Override
	public boolean removeCustomer(int customerId)
			throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionManager.CreateConnection();
		String SQL = "delete from Customer where c_id=?";
		PreparedStatement statement = connection.prepareStatement(SQL);
		statement.setInt(1, customerId);
		int r = statement.executeUpdate();
		if (r > 0)
			return true;
		return false;
	}

	public boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException {
	
		Connection connection = ConnectionManager.CreateConnection();
		String SQL="update  Customer set c_name=?,c_city=?,c_amt=? where c_id=?";
		PreparedStatement statement= connection.prepareStatement(SQL);
		statement.setInt(4, customer.getId());
		statement.setString (1, customer.getName());
		statement.setString (2, customer.getCity());
		statement.setDouble(3, customer.getOutStandingAmount());
		int r=statement.executeUpdate();
		if(r>0){
			return true;
		}
		return false;
	}

	@Override
	public Customer findCustomer(int customerid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
		Connection connection = ConnectionManager.CreateConnection();
		String SQL = "select * from customer";
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(SQL);
		List<Customer> customers = new ArrayList<>();
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String city = rs.getString(3);
			double amt = rs.getDouble(4);
			Customer customer = new Customer();
			customer.setId(id);
			customer.setName(name);
			customer.setCity(city);
			customer.setOutStandingAmount(amt);
			customers.add(customer);
		}
		statement.close();
		rs.close();
		ConnectionManager.closeConnection(connection);

		return customers;
	}

}
