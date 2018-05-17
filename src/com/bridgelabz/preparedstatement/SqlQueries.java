package com.bridgelabz.preparedstatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.bridgelabz.connection.Employee;
import com.bridgelabz.connection.MySqlConnection;

public class SqlQueries {

	static Connection con = MySqlConnection.getConnection();;
	static PreparedStatement pst = null;
	static Scanner scanner = new Scanner(System.in);

	public static int insert(Employee emp) {
		int result = 0;
		String query = "insert into employee(ename,email,elocation,ephoneno) values(?,?,?,?)";
		try {
			pst = con.prepareStatement(query);

			pst.setString(1, emp.getEname());
			pst.setString(2, emp.getEmail());
			pst.setString(3, emp.getElocation());
			pst.setLong(4, emp.getEphoneno());

			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static int delete(Employee emp) {
		int result = 0;
		String query = "delete from employee where eid = ?";

		try {
			pst = con.prepareStatement(query);

			pst.setInt(1, emp.getEid());

			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void displayAll() {
		String query = "select * from employee";

		try {
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"
						+ rs.getString(3) + "\t" + rs.getString(4) + "\t"
						+ rs.getString(5));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void display(Employee emp) {
		String query = "select * from employee where eid = ?";
		try {
			pst = con.prepareStatement(query);
			System.out.println(emp.getEid());
			pst.setInt(1, emp.getEid());
			System.out.println(query);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2)
						+ "\t" + rs.getString(3) + "\t" + rs.getString(4)
						+ "\t" + rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static int edit(Employee emp, String field, String value) {
		int result=0;
		String query = "update employee set "+field+" = ? where eid = ?";
		try {
			pst = con.prepareStatement(query);
			
			pst.setString(1, value);
			pst.setInt(2, emp.getEid());
			System.out.println(emp.getEid());
			System.out.println(query);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
