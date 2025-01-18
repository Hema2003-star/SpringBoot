package com.examp.TCB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TCB_TelecomActivity")
public class TelecomModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int activityId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private CustomerModel customer;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "activity_type")
	private TariffModel tariff;
	private String timestamp;
	private double value;

	public TelecomModel() {
		super();
	}

	public TelecomModel(int activityId, CustomerModel customer, TariffModel tariff, String timestamp, double value) {
		super();
		this.activityId = activityId;
		this.customer = customer;
		this.tariff = tariff;
		this.timestamp = timestamp;
		this.value = value;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}

	public TariffModel getTariff() {
		return tariff;
	}

	public void setTariff(TariffModel tariff) {
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

	@Override
	public String toString() {
		return "TelecomModel [activityId=" + activityId + ", customer=" + customer + ", tariff=" + tariff
				+ ", timestamp=" + timestamp + ", value=" + value + "]";
	}

}
