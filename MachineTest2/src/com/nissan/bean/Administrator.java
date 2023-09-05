package com.nissan.bean;

import java.util.Scanner;

public class Administrator implements DemoTransaction {

	private BankApp obj;
	private Scanner sc;

	public Administrator(BankApp obj, Scanner sc) {
		super();
		this.obj = obj;
		this.sc = sc;
	}

//Scanner sc = new Scanner(System.in);
	@Override
	public void implement() {
		BankApp obj1 = new BankApp();
		while (true) {
			System.out.println("\nAdministrator Menu:");
			System.out.println("1. Add New Customer");
			System.out.println("2. Update Customer Details");
			System.out.println("3. Delete Customer");
			System.out.println("4. Display All Customers");
			System.out.println("5. Display Customer Details");
			System.out.println("6. Return to Main Menu");

			System.out.print("Enter your choice: ");
			int adminChoice = sc.nextInt();
			switch (adminChoice) {

			case 1:
				System.out.println(
						"Enter the customer name,account type,balance, minimum balance, mobile number,email id and pan number ");
				String name = obj1.checkName(sc.next());
				String acctype = sc.next();
				double bal = sc.nextDouble();
				double minbal = sc.nextDouble();
				String phno = obj1.checkMobile(sc.next());
				String email = sc.next();
				long pan = sc.nextLong();

				obj1.addCustomer(name, acctype, bal, minbal, phno, email, pan);
				break;
			case 2:
				System.out.println("Enter the account number,phone number and email id");
				int accno=sc.nextInt();
				String ph=sc.next();
				String email1=sc.next();
				obj1.updateCustomer(accno,ph,email1);
				break;
			case 3:
				System.out.println("Enter the account number of customer to be deleted");
				int accno1=sc.nextInt();
				obj1.deleteCustomer(accno1);
				break;
			case 4:
				obj1.displayAll();
				break;
			case 5:
				System.out.println("Enter the account number of customer to be displayed");
				int accno2=sc.nextInt();
				obj1.displayCustomer(accno2);
				break;
			case 6:
				return;

			default:
				System.out.println("Invalid choice! Please enter a valid option.");
				break;
			}

		}
	}
}