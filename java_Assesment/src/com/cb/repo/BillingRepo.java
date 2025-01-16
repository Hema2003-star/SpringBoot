package com.cb.repo;

import com.cb.model.Billing;
import com.cb.model.Customer;
import com.cb.model.Tariff;
import com.cb.model.TelecomActivity;
import com.cb.util.DBUtil;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class BillingRepo implements BillingRepoInter {

	// Method to calculate and store the bill for a particular customer
	public Billing calculateAndStoreBill(int customerId) {
		double totalBill = 0;
		String customerName = "";

		try (Connection con = DBUtil.getDBConnection()) {
			if (con == null) {
				System.out.println("Database connection failed");
				return null;
			}

			// Get customer info
			CustomerRepo customerRepo = new CustomerRepo();
			Customer customer = customerRepo.doFindCustomer(customerId);
			if (customer != null) {
				customerName = customer.getName();

				// Fetch all telecom activities related to the customer
				ActivityRepo activityRepo = new ActivityRepo();
				List<TelecomActivity> activities = activityRepo.doFindAllLog();

				// Loop through activities to calculate total bill
				for (TelecomActivity activity : activities) {
					if (activity.getCustomer().getCustomerId() == customerId) {
						// Fetch the tariff rate for the activity type
						TariffRepo tariffRepo = new TariffRepo();
						Tariff tariff = tariffRepo.doFindTariff(activity.getTariff().getActivityType());

						if (tariff != null) {
							double rate = tariff.getRate();
							totalBill += activity.getValue() * rate;
						}
					}
				}

				// Store the billing record
				storeBillInDatabase(customerId, customerName, totalBill);
			}
		} catch (SQLException e) {
			System.err.println("Error calculating and storing bill: " + e.getMessage());
		}

		return new Billing(customerId, customerName, totalBill);
	}

	// Store the billing info in the database
	public void storeBillInDatabase(int customerId, String customerName, double totalBill) {
		String sql = "INSERT INTO h_billing (customer_id, customer_name, total_bill) VALUES (?, ?, ?)";

		try (Connection con = DBUtil.getDBConnection()) {
			if (con == null) {
				System.out.println("Database connection failed");
				return;
			}

			try (PreparedStatement ps = con.prepareStatement(sql)) {
				ps.setInt(1, customerId); // Foreign key for customer_id
				ps.setString(2, customerName);
				ps.setDouble(3, totalBill);

				int rowsAffected = ps.executeUpdate();
				if (rowsAffected > 0) {
					System.out.println("Billing record inserted successfully for Customer ID: " + customerId);
				} else {
					System.out.println("Failed to insert billing record for Customer ID: " + customerId);
				}
			}
		} catch (SQLException e) {
			System.err.println("Error inserting billing record: " + e.getMessage());
		}
	}

	// Method to generate bill for all customers
	public List<Billing> generateBillForAllCustomers() {
	    List<Billing> allBills = new ArrayList<>();

	    try (Connection con = DBUtil.getDBConnection()) {
	        if (con == null) {
	            System.out.println("Database connection failed");
	            return allBills;
	        }

	        // Get all customers
	        CustomerRepo customerRepo = new CustomerRepo();
	        List<Customer> customers = customerRepo.doFindAllCustomer();

	        // Generate bills for each customer
	        for (Customer customer : customers) {
	            Billing billing = calculateBillWithoutStoring(customer.getCustomerId());
	            if (billing != null) {
	                allBills.add(billing);
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("Error generating bills for all customers: " + e.getMessage());
	    }

	    return allBills;
	}


	// without storing calculation for generate all bills

	public Billing calculateBillWithoutStoring(int customerId) {
	    double totalBill = 0;
	    String customerName = "";

	    try (Connection con = DBUtil.getDBConnection()) {
	        if (con == null) {
	            System.out.println("Database connection failed");
	            return null;
	        }

	        // Get customer info
	        CustomerRepo customerRepo = new CustomerRepo();
	        Customer customer = customerRepo.doFindCustomer(customerId);
	        if (customer != null) {
	            customerName = customer.getName();

	            // Fetch all telecom activities related to the customer
	            ActivityRepo activityRepo = new ActivityRepo();
	            List<TelecomActivity> activities = activityRepo.doFindAllLog();

	            // Loop through activities to calculate total bill
	            for (TelecomActivity activity : activities) {
	                if (activity.getCustomer().getCustomerId() == customerId) {
	                    // Fetch the tariff rate for the activity type
	                    TariffRepo tariffRepo = new TariffRepo();
	                    Tariff tariff = tariffRepo.doFindTariff(activity.getTariff().getActivityType());

	                    if (tariff != null) {
	                        double rate = tariff.getRate();
	                        totalBill += activity.getValue() * rate;
	                    }
	                }
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("Error calculating bill: " + e.getMessage());
	    }

	    return new Billing(customerId, customerName, totalBill);
	}

}
