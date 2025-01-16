package com.cb.view;

import java.util.Scanner;

import com.cb.model.Customer;

public class CustomerView {

	static Scanner sc = new Scanner(System.in);

	static int customerId;
	static String name, address;
	static long contactNumber;

	// insert
	public static Customer customerView() {

		System.out.println("Enter the Customer Id :");
		customerId = sc.nextInt();

		sc.nextLine();

		System.out.println("Enter the Customer Name :");
		name = sc.nextLine();

		System.out.println("Enter the Customer Address :");
		address = sc.nextLine();

		System.out.println("Enter the Contact Number :");
		contactNumber = sc.nextLong();

		return new Customer(customerId, name, address, contactNumber);

	}
	
	//find
		public static int findCustomerView() {
			System.out.println("Enter Customer id");
			return sc.nextInt();
		}


}
