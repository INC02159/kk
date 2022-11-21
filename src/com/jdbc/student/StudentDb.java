package com.jdbc.student;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentDb {

	private static Connection connection =null;
	private static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		StudentDb studentDb= new StudentDb();
		try{		
//load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		//establish the connection
		String dbURL="jdbc:mysql://localhost:3306/jdbcdb";
		String username="root";
		String password="Apple@123";
		connection = DriverManager.getConnection(dbURL, username, password);
		System.out.println("Enter your choice");
		System.out.println("1:Insert");
		int choice=Integer.parseInt(scanner.nextLine());
		switch(choice)
		{
		case 1:
			studentDb.insertRecord();
			break;
			
			default:
				break;
		}
		
		//execute the query
		//process the result
		//close the connection
		}
		catch(Exception e)
		{
			throw new RuntimeException("something went wrong");
		}
	}
	private void insertRecord()  throws SQLException
	{
		System.out.println("inserting record");
		//create  execute the query
		String sql= "insert into student(roll_no,name,percentage) values('?','?','?')";
		//platform to perform sql query
		//now using prepared statement coz it is compiled once and use multiple times.(dynamic)
		PreparedStatement preparedStatement= connection.prepareStatement(sql);
		preparedStatement.setString(1, "01");
		preparedStatement.setString(2, "Raja");
		preparedStatement.setDouble(2, 90.7);
		
		int rows=preparedStatement.executeUpdate();
		if(rows>0)
		{
			System.out.println("records inserted successfully");
		}
		
	}

}
