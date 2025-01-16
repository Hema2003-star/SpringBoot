package com.cb.view;

import java.util.Scanner;

import com.cb.model.Tariff;

public class TariffView {

	static Scanner sc = new Scanner(System.in);

	static String activityType;
	static double rate;

	// update
	public static Tariff updateTariffView() {

		System.out.println("Enter the activity type");
		activityType = sc.nextLine();

		System.out.println("Enter the rate");
		rate = sc.nextDouble();

		return new Tariff(activityType, rate);
	}

	// find
	public static String findTariffView() {
		System.out.println("Enter activity type");
		return sc.next();
	}

}
