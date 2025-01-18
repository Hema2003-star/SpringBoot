package com.examp.TCB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TCB_Tariff")

public class TariffModel {

	@Id
	private String activityType;
	private double rate;

	public TariffModel() {
		super();
	}

	public TariffModel(String activityType, double rate) {
		super();
		this.activityType = activityType;
		this.rate = rate;
	}

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

	@Override
	public String toString() {
		return "TariffModel [activityType=" + activityType + ", rate=" + rate + "]";
	}

}
