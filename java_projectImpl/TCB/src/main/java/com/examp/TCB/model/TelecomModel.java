package com.examp.TCB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TCB_TelecomActivity")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

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



	// to string
	@Override
	public String toString() {
		return "TelecomModel [activityId=" + activityId + ", customer=" + customer + ", tariff=" + tariff
				+ ", timestamp=" + timestamp + ", value=" + value + "]";
	}

}
