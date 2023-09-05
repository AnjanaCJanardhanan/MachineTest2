package com.nissan.app;

import java.util.Scanner;

import com.nissan.bean.Administrator;
import com.nissan.bean.BankApp;
import com.nissan.bean.CustomerMenu;
import com.nissan.bean.DemoTransaction;

public class BankDemo {
	public static void main(String[] args) {
		BankApp obj = new BankApp();
		Scanner sc = new Scanner(System.in);
		try {
		while (true) {
			System.out.println("\nBank Transactions Menu:");
			System.out.println("1. Administrator Menu");
			System.out.println("2. Customer Menu");
			System.out.println("3. Exit");

			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				// Administrator Menu
				DemoTransaction t = new Administrator(obj, sc);
				t.implement();
				break;
			case 2:
				// Administrator Menu
				DemoTransaction t1 = new CustomerMenu(obj, sc);
				t1.implement();
				break;
			case 3:
				System.out.println("Exiting..");
				sc.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice! Please enter a valid option.");
				break;

			}
		}
		}
		catch(Exception e) 
		{
		System.out.println("Invalid Entry");	
		}

		
	
}
}
