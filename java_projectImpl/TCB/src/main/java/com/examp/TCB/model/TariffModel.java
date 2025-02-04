package com.examp.TCB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TCB_Tariff")
@AllArgsConstructor
@NoArgsConstructor
@Getter // This will generate getters for all fields
@Setter // This will generate setters for all fields
public class TariffModel {

	@Id
	private String activityType;
	private double rate;

	// Optional: Custom toString method
	@Override
	public String toString() {
		return "TariffModel [activityType=" + activityType + ", rate=" + rate + "]";
	}
}
