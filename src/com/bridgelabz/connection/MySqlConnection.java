package com.bridgelabz.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySqlConnection {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/company", "root", "bridgeit");
			if(con==null){
				System.out.println("Connection problem!");
			}
//			System.out.println("Successfully Connected ");
		} catch (SQLException e) {
			System.out.println("Failed Connection");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found");
			e.printStackTrace();
		}
		return con;
	}
	
}
