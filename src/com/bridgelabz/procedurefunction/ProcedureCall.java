package com.bridgelabz.procedurefunction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.bridgelabz.connection.MySqlConnection;

public class ProcedureCall {
	Scanner s = new Scanner(System.in);
	Connection con = MySqlConnection.getConnection();
 void callingProcedure()
{
	try {
		System.out.println("Enter id:");
		CallableStatement cst = con.prepareCall("{call selection(?,?)}");
		cst.setInt(1, s.nextInt());
		cst.setString(2, s.next());
		 cst.executeUpdate();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}
	
	public static void main(String[] args) {
		ProcedureCall p = new ProcedureCall();
		p.callingProcedure();

	}

}
