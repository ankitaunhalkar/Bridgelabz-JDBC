package com.bridgelabz.preparedstatement;

import java.util.Scanner;


public class Application {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out
					.println("Enter Choice:\n 1. Insert Employee\t 2. Edit Employee\t 3. View Employee\t 4. Delete Employee\t 5. Exit");
			switch (scanner.nextInt()) {
			case 1:
				Poperations.insertion();
				break;
			case 2:
				Poperations.updation();
				break;
			case 3:
				Poperations.selection();
				break;
			case 4:
				Poperations.deletion();
				break;
			case 5:
				scanner.close();
				System.exit(0);
			}
				
		} while (true);
	}
}
