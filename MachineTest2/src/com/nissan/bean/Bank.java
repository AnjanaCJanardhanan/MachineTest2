package com.nissan.bean;

import java.util.Random;
import java.util.Scanner;

public class Bank {

	
	private int accountNo;
	private String customerName;
	private String accountType;
	private double balance;
	private double minBalance;
	private String mobileNumber;
	private String emailId;
	private int atmPin;
	private long panCard;

	// constructor
	public Bank(String customerName, String accountType, double balance, double minBalance, String mobileNumber,
			String emailId, long panCard) {
		super();
		this.accountNo = generateAccountNo();
		this.customerName = customerName;
		this.accountType = accountType;
		this.balance = balance;
		this.minBalance = minBalance;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.atmPin = generateATMPin();
		this.panCard = panCard;
	}

	public Bank() {
		// TODO Auto-generated constructor stub
		this.accountNo = 0;
		this.customerName = "NULL";
		this.accountType = "NULL";
		this.balance = 0d;
		this.minBalance = 0d;
		this.mobileNumber = "NULL";
		this.emailId = "NULL";
		this.atmPin = 0;
		this.panCard = 0;
	}

	private int generateAccountNo() {
		Random random = new Random();
		return 100000000 + random.nextInt(900000000);
	}

	private int generateATMPin() {
		Random random = new Random();
		return 1000 + random.nextInt(9000);
	}

	public int getAccountNo() {
		return accountNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getAccountType() {
		return accountType;
	}

	public double getBalance() {
		return balance;
	}

	public double getMinBalance() {
		return minBalance;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public int getAtmPin() {
		return atmPin;
	}

	public long getPanCard() {
		return panCard;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;

	}
	

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void depositMoney(double amount, int accountNo) {
		if (BankApp.customerdetails.containsKey(accountNo)) {
			if (amount > 50000) {
				Scanner scanner = new Scanner(System.in);
				System.out.print("Enter your PAN Card number: ");
				long panCardNumber = Long.parseLong(scanner.nextLine());
				this.panCard = panCardNumber;
			}
			
			double newbalance=this.balance+amount;
			setBalance(newbalance);
		}
	}

	public void withdrawMoney(double amount, int accountNo) {
		if (BankApp.customerdetails.containsKey(accountNo)) {
			double availableBalance = balance - minBalance;
			if (amount > availableBalance) {
				System.out.println("Insufficient funds..!!!");
			} else {
				if (amount > 50000) {
					Scanner scanner = new Scanner(System.in);
					System.out.print("Enter your PAN Card number: ");
					String panCardNumber = scanner.nextLine();
					this.panCard = panCard;
				}
				
				double newbalance=this.balance-amount;
				setBalance(newbalance);
			}
		}
	}

	public void showBalance() {
		// double availableBalance = balance - minBalance;
		System.out.println("Balance=" + this.balance);
	}

}
