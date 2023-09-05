package com.nissan.bean;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;

public class BankApp {

	static Map<Integer, Bank> customerdetails= new HashMap<>();

	/*public BankApp() {
		customerdetails = new HashMap<>();
	}*/

	public void addCustomer(String customerName, String accountType, double balance, double minBalance,
			String mobileNumber, String emailId, long panCard) {
		Bank b1 = new Bank(customerName, accountType, balance, minBalance, mobileNumber, emailId, panCard);
		customerdetails.put(b1.getAccountNo(), b1);
	}

	public void updateCustomer(int accountNo, String newMobileNumber, String newEmailId) {
		Bank b2 = customerdetails.get(accountNo);
		if (b2 != null) {
			b2.setMobileNumber(newMobileNumber);
			b2.setEmailId(newEmailId);
			System.out.println("Customer details updated successfully.");
		} else {
			System.out.println("Account number not found..!!!");
		}
	}

	public void deleteCustomer(int accountNo) {
		if (customerdetails.containsKey(accountNo)) {
			customerdetails.remove(accountNo);
			System.out.println("Customer deleted successfully.");
		} else {
			System.out.println("Account number not found..!!!");
		}
	}

	public void displayAll() {
		for (Bank b3 : customerdetails.values()) {
			System.out.println("Account No: " + b3.getAccountNo());
			System.out.println("Customer Name: " + b3.getCustomerName());
			System.out.println("Account Type: " + b3.getAccountType());
			System.out.println("Balance: " + b3.getBalance());
			System.out.println("Mobile Number: " + b3.getMobileNumber());
			System.out.println("Email Id: " + b3.getEmailId());
			System.out.println("PAN Card: " + b3.getPanCard());
			System.out.println();
		}
	}

	public void displayCustomer(int accountNo) {
		Bank b4 = customerdetails.get(accountNo);
		if (b4 != null) {
			System.out.println("Account No: " + b4.getAccountNo());
			System.out.println("Customer Name: " + b4.getCustomerName());
			System.out.println("Account Type: " + b4.getAccountType());
			System.out.println("Balance: " + b4.getBalance());
			System.out.println("Mobile Number: " + b4.getMobileNumber());
			System.out.println("Email Id: " + b4.getEmailId());
			System.out.println("ATM Pin: " + b4.getAtmPin());
			System.out.println("PAN Card: " + b4.getPanCard());
		} else {
			System.out.println("Account number not found..!!!");
		}
	}

	 public void transferMoney(int fromAccountNo, int toAccountNo, double amount) {
			Bank fromCustomer = customerdetails.get(fromAccountNo);
			Bank toCustomer = customerdetails.get(toAccountNo);

			if (fromCustomer != null && toCustomer != null) {
				double availableBalance = fromCustomer.getBalance() - fromCustomer.getMinBalance();
				if (amount <= availableBalance) {
					fromCustomer.withdrawMoney(amount,fromAccountNo);
					toCustomer.depositMoney(amount,toAccountNo);
					System.out.println("Transferred Amount Successfully");
				} else {
					System.out.println("Insufficient funds..!!!");
				}
			} else {
				System.out.println("Account number not found..!!!");
			}
		}

	// to verify the name
	static String checkName(String name) {
		// TODO Auto-generated method stub
		try {
			// create object for buffered reader
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			// create pattern using regular expression
			Pattern pattern = Pattern.compile("[^A-Za-z ]");
			do {
				// match
				Matcher matcher = pattern.matcher(name);
				boolean finder = matcher.find();
				// find method returns false if string matches the pattern
				if (finder) {
					System.out.println("Name must contain only alphabets please re-enter!");
					name = br.readLine();
				} else if (name.length() > 30) {
					System.out.println("Name must not be longer than 30 letters please re-enter!");
					name = br.readLine();
				} else {
					break;
				}
			} while (true);
		} catch (Exception e) {
			System.out.println(e);
		}
		return name;
	}
	
	//to verify the mobile number
		public String checkMobile(String number) {
			try {
				//create object for buffered reader
				Scanner sc=new Scanner(System.in);
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				//create pattern using regular expression
				Pattern pattern = Pattern.compile("[^0-9]");
				do {
					//match
					Matcher matcher = pattern.matcher(number);
					boolean finder = matcher.find();
					//find method returns false if string matches the pattern
					if(finder) {
						System.out.println("Mobile Number must contain only digits please re-enter!");
						number = sc.next();
					}else if(number.length()>10){
						System.out.println("Mobile Number must not be longer than 10 digits please re-enter!");
						number = br.readLine();
					}else {
						break;
					}
				}while(true);
			}catch(Exception e ) {
				System.out.println(e);
			}
			return number;
		}
		
		//to verify the account number
		private String checkAccountNumber(String accNo) {
			try {
				//create object for buffered reader
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				//create pattern using regular expression
				Pattern pattern = Pattern.compile("[^0-9]");
				do {
					//match
					Matcher matcher = pattern.matcher(accNo);
					boolean finder = matcher.find();
					//find method returns false if string matches the pattern
					if(finder) {
						System.out.println("Account Numbe must contain only digits please re-enter!");
						accNo = br.readLine();
					}else if(accNo.length()>9){
						System.out.println("Account number must not be longer than 9 digits please re-enter!");
						accNo = br.readLine();
					}else {
						break;
					}
				}while(true);
			}catch(Exception e ) {
				System.out.println(e);
			}
			return accNo;
		}
}
