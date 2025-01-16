package com.cb.model;

public class Billing {

    private int customerId;
    private String customerName;
    private double totalBill;

    // Default constructor
    public Billing() {}

    // Parameterized constructor
    public Billing(int customerId, String customerName, double totalBill) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.totalBill = totalBill;
    }

    // Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    @Override
    public String toString() {
        return "\n Billing [customerId=" + customerId + ", customerName=" + customerName + ", totalBill=" + totalBill + "]";
    }
}
