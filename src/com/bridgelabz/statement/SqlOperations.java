package com.bridgelabz.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.bridgelabz.connection.Employee;
import com.bridgelabz.connection.MySqlConnection;

public class SqlOperations {
	static Connection con = MySqlConnection.getConnection();;
	static Statement st = null;
	static Scanner scanner = new Scanner(System.in);


	public static int insert( Employee emp) {
		int result = 0;
		try {
			System.out.println(emp);
			String query = "insert into employee(ename,email,elocation,ephoneno) values('"
					+ emp.getEname()
					+ "','"
					+ emp.getEmail()
					+ "','"
					+ emp.getElocation() + "','" + emp.getEphoneno() + "')";
			// System.out.println(query);
			st = con.createStatement();
		    result = st.executeUpdate(query);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return result;
	}

	public static int edit(Employee emp, String field, String value) {
		int result=0;
		try {
			st = con.createStatement();
			String query = "update employee set "+field+"='"+value+"' where eid="+emp.getEid();
//			System.out.println(query);
			result = st.executeUpdate(query);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void display(Employee emp) {
		try {
			st = con.createStatement();
			String query = "select * from employee where eid="+emp.getEid();
			
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2)
						+ "\t" + rs.getString(3) + "\t" + rs.getString(4)
						+ "\t" + rs.getString(5));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static int delete(Employee emp) {
		int result=0;
		try {
	
			st = con.createStatement();
			String query = "delete from employee where eid=" + emp.getEid();
			result = st.executeUpdate(query);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void displayAll() {
		try {
			st = con.createStatement();
			String query = "select * from employee";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2)
						+ "\t" + rs.getString(3) + "\t" + rs.getString(4)
						+ "\t" + rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
