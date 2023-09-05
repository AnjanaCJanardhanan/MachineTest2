package com.nissan.bean;

import java.util.Scanner;

public class CustomerMenu implements DemoTransaction {

	private BankApp obj;
	private Scanner sc;

	public CustomerMenu(BankApp obj, Scanner sc) {
		super();
		this.obj = obj;
		this.sc = sc;
	}

	@Override
	public void implement() {
		Bank ob = new Bank();
		BankApp b5 = new BankApp();
		while (true) {
			System.out.println("\nCustomer Menu:");
			System.out.println("1. Deposit Money");
			System.out.println("2. Withdraw Money");
			System.out.println("3. Show Balance");
			System.out.println("4. Transfer Money");
			System.out.println("5. Return to Main Menu");

			System.out.print("Enter your choice: ");
			int adminChoice = sc.nextInt();
			switch (adminChoice) {
			case 1:
				System.out.println("Enter the amount to be deposited");
				double amt = sc.nextDouble();
				System.out.println("Enter the account number to be withdrawn");
				int accno = sc.nextInt();
				ob.depositMoney(amt,accno);
				break;
			case 2:
				System.out.println("Enter the amount to be withdrawn");
				double amt1 = sc.nextDouble();
				System.out.println("Enter the account number to be withdrawn");
				int accno1 = sc.nextInt();
				ob.withdrawMoney(amt1,accno1);
				break;
			case 3:
				ob.showBalance();
				break;
			case 4:
				System.out.println("Enter the from account number,to account number and amount");
				int accno11=sc.nextInt();
				int accno2=sc.nextInt();
				double amt11=sc.nextDouble();
				b5.transferMoney(accno11,accno2,amt11);
				break;
			case 5:
				return;

			default:
				System.out.println("Invalid choice! Please enter a valid option.");
				break;
			}

		}

	}

}
