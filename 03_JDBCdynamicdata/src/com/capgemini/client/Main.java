package com.capgemini.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
		
		int inp_id=0;
		String inp_name=" ";
		String inp_city=" ";
		double inp_amt=0.0;
		Scanner scanner= new Scanner(System.in);
		System.out.println("enter id:");
		inp_id=scanner.nextInt();
		System.out.println("enter name:");
		inp_name=scanner.next();
		System.out.println("enter city:");
		inp_city=scanner.next();
		System.out.println("enter outStanding Amount:");
		inp_amt=scanner.nextDouble();
		
		Connection connection= CreateConnection();
		System.out.println("connected sucessfully");
		String SQL = "insert into Customer values(?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(SQL);
		statement.setInt(1,inp_id);
		statement.setString(2,inp_name);
		statement.setString(3,inp_city);
		statement.setDouble(4,inp_amt);
		
		int r=statement.executeUpdate();
		System.out.println(r+" rows inserted");
		statement.close();
		connection.close();
		scanner.close();
	}
	public static void updateRecord() throws SQLException, ClassNotFoundException{
		int inp_id=0;
		double inp_amt;
		Scanner scanner= new Scanner(System.in);
		System.out.println("enter id:");
		inp_id=scanner.nextInt();
		System.out.println("enter outStanding Amount:");
		inp_amt=scanner.nextDouble();
		Connection connection= CreateConnection();
		System.out.println("connected sucessfully");
		String SQL = "update Customer set c_amt=c_amt+? where c_id=?";
		PreparedStatement statement = connection.prepareStatement(SQL);
		statement.setInt(2, inp_id);
		statement.setDouble(1, inp_amt);
		int r=statement.executeUpdate();
		System.out.println(r+" row updated");
		statement.close();
		connection.close();
		scanner.close();
		
	}
	public static void deleteRecord() throws SQLException, ClassNotFoundException{
		int inp_id=0;
		Scanner scanner= new Scanner(System.in);
		System.out.println("enter id:");
		inp_id=scanner.nextInt();
		Connection connection= CreateConnection();
		System.out.println("connected sucessfully");
		String SQL = "delete from Customer  where c_id=?";
		PreparedStatement statement = connection.prepareStatement(SQL);
		statement.setInt(1,inp_id);
		int r=statement.executeUpdate();
		System.out.println(r+" row deleted");
		statement.close();
		connection.close();
		scanner.close();
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
	public static void displayOneRecord() throws ClassNotFoundException, SQLException{
		
		int inp_id=0;
		Scanner scanner= new Scanner(System.in);
		System.out.println("enter id:");
		inp_id=scanner.nextInt();
		Connection connection= CreateConnection();
		System.out.println("connected sucessfully");
		String SQL="select  * from  customer where c_id=?";
		PreparedStatement statement = connection.prepareStatement(SQL);
		statement.setInt(1,inp_id);
		ResultSet rs=statement.executeQuery();
		if(rs.next()){
		System.out.print(rs.getInt(1));
		System.out.print("\t"+ rs.getString(2));
		System.out.print("\t"+rs.getString(3));
		System.out.print("\t\t"+rs.getDouble(4));
		}
		rs.close();
		statement.close();
		connection.close();
		scanner.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//insertRecord();
		//updateRecord();
		//deleteRecord();
		//displayAllRecords();
		displayOneRecord();
	}
}
