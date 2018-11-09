package com.capgemini.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	public static Connection CreateConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String dbURL = "jdbc:mysql://localhost:3306/demodb";
		String userName = "root";
		String password = "pass";
		Connection connection = DriverManager.getConnection(dbURL, userName,password);
		return connection;
		
	}
	
	public static void insertRecord() throws SQLException, ClassNotFoundException{
		
		Connection connection= CreateConnection();
		System.out.println("connected sucessfully");
		String SQL = "insert into Customer values(5,'ram Trades','hyderabad', 6000)";
		Statement statement = connection.createStatement();
		int r=statement.executeUpdate(SQL);
		System.out.println(r+" rows inserted");
		statement.close();
		connection.close();
		
	}
	public static void updateRecord() throws SQLException, ClassNotFoundException{
		
		Connection connection= CreateConnection();
		System.out.println("connected sucessfully");
		String SQL = "update Customer set c_amt=c_amt+2000 where c_id=1";
		Statement statement = connection.createStatement();
		int r=statement.executeUpdate(SQL);
		System.out.println(r+" row updated");
		statement.close();
		connection.close();
		
	}
	public static void deleteRecord() throws SQLException, ClassNotFoundException{
		
		Connection connection= CreateConnection();
		System.out.println("connected sucessfully");
		String SQL = "delete from Customer  where c_id=5";
		Statement statement = connection.createStatement();
		int r=statement.executeUpdate(SQL);
		System.out.println(r+" row deleted");
		statement.close();
		connection.close();
		
	}
	public static void displayAllRecords() throws ClassNotFoundException, SQLException{
		Connection connection= CreateConnection();
		System.out.println("connected sucessfully");
		String SQL="select  * from  customer";
		Statement statement = connection.createStatement();
		ResultSet rs=statement.executeQuery(SQL);
		while(rs.next()){
		System.out.print(rs.getInt(1));
		System.out.print("\t"+ rs.getString(2));
		System.out.print("\t"+rs.getString(3));
		System.out.println("\t\t"+rs.getString(4));
		}
		rs.close();
		statement.close();
		connection.close();
		
	}
	public static void displayOneRecord(int id) throws ClassNotFoundException, SQLException{
		Connection connection= CreateConnection();
		System.out.println("connected sucessfully");
		String SQL="select  * from  customer where c_id=" +id;
		Statement statement = connection.createStatement();
		ResultSet rs=statement.executeQuery(SQL);
		if(rs.next()){
		System.out.print(rs.getInt(1));
		System.out.print("\t"+ rs.getString(2));
		System.out.print("\t"+rs.getString(3));
		System.out.print("\t\t"+rs.getDouble(4));
		}
		rs.close();
		statement.close();
		connection.close();
		
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//updateRecord();
		//deleteRecord();
		displayAllRecords();
		displayOneRecord(1);
	}
}
