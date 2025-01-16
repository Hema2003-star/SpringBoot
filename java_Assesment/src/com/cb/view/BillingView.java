package com.cb.view;

import com.cb.model.Billing;
import com.cb.service.BillingService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BillingView {

    static Scanner sc = new Scanner(System.in);
    static BillingService billingService = new BillingService();

    // View for generating a bill for a specific customer
    public static void generateBillForCustomerView() {
        try {
            System.out.println("Enter Customer ID to generate bill:");
            int customerId = sc.nextInt();
            if (customerId <= 0) {
                System.out.println("Invalid Customer ID. Please enter a positive number.");
                return;
            }
            String result = billingService.generateBillForCustomer(customerId);
            System.out.println(result);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric Customer ID.");
            sc.nextLine();
        }
    }


    // View for generating bills for all customers
    public static void generateBillForAllCustomersView() {
        List<Billing> allBills = billingService.generateBillForAllCustomers();
        if (allBills == null || allBills.isEmpty()) {
            System.out.println("No billing records available.");
            return;
        }
        for (Billing bill : allBills) {
            System.out.println(bill);
        }
    }

}


