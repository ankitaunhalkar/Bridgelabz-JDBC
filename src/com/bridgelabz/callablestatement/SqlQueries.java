package com.bridgelabz.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.bridgelabz.connection.Employee;
import com.bridgelabz.connection.MySqlConnection;

public class SqlQueries {
	static Connection con = MySqlConnection.getConnection();;
	static CallableStatement cst = null;
	static Scanner scanner = new Scanner(System.in);
	public static int insert(Employee emp) {
		int result = 0;
		try {
			cst = con.prepareCall("{call insertion(?,?,?,?)}");

			cst.setString(1, emp.getEname());
			cst.setString(2, emp.getEmail());
			cst.setString(3, emp.getElocation());
			cst.setLong(4, emp.getEphoneno());

			result = cst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static int delete(Employee emp) {
		int result=0;
		try {
	
			cst = con.prepareCall("{call deletion(?)}");
			cst.setInt(1, emp.getEid());
			result = cst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}

	public static void displayAll() {
		try {
			
			String query = "select * from employee";
			ResultSet rs = cst.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2)
						+ "\t" + rs.getString(3) + "\t" + rs.getString(4)
						+ "\t" + rs.getString(5));
			}		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void display(Employee emp) {
		try {
			cst = con.prepareCall("{call output(?,?,?,?,?)}");
			cst.setInt(1, emp.getEid());
			cst.registerOutParameter(1, Types.INTEGER);
			cst.registerOutParameter(2, Types.VARCHAR);
			cst.registerOutParameter(3, Types.VARCHAR);
			cst.registerOutParameter(4, Types.VARCHAR);
			cst.registerOutParameter(5, Types.VARCHAR);			
			cst.execute();
			
			System.out.println(cst.getInt(1)+" "+cst.getString(2)+" "+cst.getString(3)+" "+cst.getString(4)+" "+cst.getString(5));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	public static int edit(Employee emp, String field, String value) {
		int result = 0;
		try {
			cst = con.prepareCall("{call updation(?,?,?)}");
			cst.setInt(1, emp.getEid());
			cst.setString(2, field);
			cst.setString(3, value);
			result = cst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
