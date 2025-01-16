package com.cb.model;

public class Tariff {

	private String activityType;
	private double rate;

	// default constructor
	public Tariff() {
		super();
	}

	// parameterized constructor
	public Tariff(String activityType, double rate) {
		super();
		this.activityType = activityType;
		this.rate = rate;
	}

	// Getters and Setters
	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	//to string
	@Override
	public String toString() {
		return "\n Tariff [activityType=" + activityType + ", rate=" + rate + "]";
	}

}
