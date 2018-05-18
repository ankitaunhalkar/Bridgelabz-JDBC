package com.bridgelabz.batchprocessing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.bridgelabz.connection.MySqlConnection;

public class Application {
Connection con = MySqlConnection.getConnection();

void statement()
{
	try {
		Statement st = con.createStatement();
		String query1 = "update employee set ename = 'mady' where eid=11";
		String query2 = "insert into employee(ename,email,elocation,ephoneno) values('mads','m@gmail.com','mumbai','9874563210')";
		st.addBatch(query2);
		st.addBatch(query1);
		int result[]=st.executeBatch();
		for (int j : result) {
			System.out.println(j);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

void preparestmt()
{
	
	try {
		String query1 = "insert into employee(ename,email,elocation,ephoneno) values(?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query1);
		pst.setString(1, "joey");
		pst.setString(2, "j@gmail.com");
		pst.setString(3, "mumbai");
		pst.setString(4, "9854123670");
		pst.addBatch();
		
		pst.setString(1, "chandler");
		pst.setString(2, "c@gmail.com");
		pst.setString(3, "mumbai");
		pst.setString(4, "9854123670");
		pst.addBatch();
		
		
		int result[]=pst.executeBatch();
		for (int j : result) {
			System.out.println(j);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public static void main(String[] args) {
	Application app = new Application();
	app.statement();
	app.preparestmt();
}
}
