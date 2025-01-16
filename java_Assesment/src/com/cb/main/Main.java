package com.cb.main;

import java.util.Scanner;

import com.cb.model.Customer;
import com.cb.model.Tariff;
import com.cb.model.TelecomActivity;
import com.cb.service.BillingService;
import com.cb.service.CustomerService;
import com.cb.service.TariffService;
import com.cb.service.TelecomService;
import com.cb.view.BillingView;
import com.cb.view.CustomerView;
import com.cb.view.TariffView;
import com.cb.view.TelecomView;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static CustomerService customerService = new CustomerService();
	static TelecomService telecomService = new TelecomService();
	static TariffService tariffService = new TariffService();
	static BillingService billingService = new BillingService();

	// Main method
	public static void main(String[] args) {
		String msg = "";
		String result = "";

		Customer customer;
		TelecomActivity activity;
		Tariff tariff;

		try {
		do {

			System.out.println("\nTelecom Charging and Billing System");
			System.out.println("1. Register a New Customer");
			System.out.println("2. Log Telecom Activity");
			System.out.println("3. Update or View Tariff Rates");
			System.out.println("4. View Customer Details");
			System.out.println("5. View Activity Log for a Customer");
			System.out.println("6. Calculate Final Bill for a Customer");
			System.out.println("7. Generate Bills for All Customers");
			System.out.println("8. Exit Application");

			System.out.println("---------------------");

			System.out.println("Enter your choice :");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				customer = CustomerView.customerView();
				result = customerService.customerValidation(customer);
				System.out.println(result);

				break;

			case 2:
				activity = TelecomView.doinsertTelecom();
				result = telecomService.insertActivityValidation(activity);
				System.out.println(result);

				break;
				
			case 3 :
				System.out.println("1. Update Tariff\n2. View Tariff");
				int option = sc.nextInt();
				if (option == 1) {
					tariff = TariffView.updateTariffView();
					result = tariffService.updateTariffValidation(tariff);
					System.out.println(result);

				}else { 
					result = tariffService.findAllTariffValidation();
					System.out.println(result);
				}
				
				break ;
				
			case 4:
				result = customerService.findAllCustomerValidation();
				System.out.println(result);

				break;
				
			case 5:				
				result = telecomService.findAllActivityValidation();
				System.out.println(result);
				
				break;

			case 6:
				BillingView.generateBillForCustomerView();
				
				break;

			case 7:
				BillingView.generateBillForAllCustomersView();
				
				break;


			case 8:
				System.out.println("Thank You");
				System.exit(0);
				
				break;

			default:
				System.out.println("Invalid choice");

			}
			
			System.out.println("");
			System.out.println(" -------------------------- ");
			System.out.println("Do You Want TO Continue [yes | No ] ");
			msg = sc.next();

			System.out.println("");

		} while (msg.equalsIgnoreCase("Yes"));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
