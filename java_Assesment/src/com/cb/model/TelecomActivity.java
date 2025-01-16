package com.cb.model;

public class TelecomActivity {

	private int activityId;
	private Customer customer;
	private Tariff tariff;
	private String timestamp;
	private double value;

	// default constructor
	public TelecomActivity() {
		super();
	}

	// parameterized constructor
	public TelecomActivity(int activityId, Customer customer, Tariff tariff, double value) {
		super();
		this.activityId = activityId;
		this.customer = customer;
		this.tariff = tariff;
//		this.timestamp = timestamp;
		this.value = value;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Tariff getTariff() {
		return tariff;
	}

	public void setTariff(Tariff tariff) {
		this.tariff = tariff;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	// to string
	@Override
	public String toString() {
		return "\nTelecomActivity [activityId=" + activityId + ", customer=" + customer.getCustomerId()
				+ ", Activity Type = " + tariff.getActivityType() + ", Price for (1-min or 1GB or 1-sms)= "
				+ tariff.getRate() + ", timestamp=" + timestamp + ", value=" + value + "]";
	}

}
