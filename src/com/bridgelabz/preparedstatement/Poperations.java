package com.bridgelabz.preparedstatement;

import java.util.Scanner;

import com.bridgelabz.connection.Employee;

public class Poperations {
	static Employee emp = new Employee();
	static Scanner scanner = new Scanner(System.in);

	public static void insertion() {
		System.out.println("Enter Employee's Name:");
		emp.setEname(scanner.next());
		System.out.println("Enter Employee's Email:");
		emp.setEmail(scanner.next());
		System.out.println("Enter Employee's Location:");
		emp.setElocation(scanner.next());
		System.out.println("Enter Employee's Phone no:");
		emp.setEphoneno(scanner.nextLong());
		// System.out.println(emp);

		int result = SqlQueries.insert(emp);

		if (result == 1) {
			System.out.println("Inserted Successfully!");
		} else {
			System.out.println("Cannot Insert!");
		}
	}

	public static void deletion() {
		System.out.println("Enter Employee's Id to delete:");
		emp.setEid(scanner.nextInt());

		int result = SqlQueries.delete(emp);

		if (result == 1) {
			System.out.println("Successfully Deleted");
		} else {
			System.out.println("Cannot delete, Please try again!");
		}
	}

	public static void selection() {
		System.out.println("1. View All\t2. View Specific");
		int choice = scanner.nextInt();
		if (choice == 1) {
			SqlQueries.displayAll();
		} else if (choice == 2) {
			System.out.println("Enter Employee's Id to view details:");
			emp.setEid(scanner.nextInt());
			SqlQueries.display(emp);
		} else {
			System.out.println("Wrong Choice");
			selection();
		}

	}

	public static void updation() {
		int result = 0;
		System.out.println("Enter Employee's Id to view details:");
		emp.setEid(scanner.nextInt());

		System.out.println("Choose field you want to edit:");
		System.out.println("1. Name\t2. Email\t3. Location\t4. Phone no");
		int field = scanner.nextInt();
		switch (field) {
		case 1:
			System.out.println("Enter new name:");
			result = SqlQueries.edit(emp, "ename", scanner.next());
			break;
		case 2:
			System.out.println("Enter new email:");
			result = SqlQueries.edit(emp, "email", scanner.next());
			break;
		case 3:
			System.out.println("Enter new location:");
			result = SqlQueries.edit(emp, "elocation", scanner.next());
			break;
		case 4:
			System.out.println("Enter new phone no.:");
			result = SqlQueries.edit(emp, "ephoneno", scanner.next());
			break;
		default:
			break;
		}

		if (result == 1) {
			System.out.println("Successfully Updated");
		} else {
			System.out.println("Cannot update, Please try again!");
		}

	}

}
