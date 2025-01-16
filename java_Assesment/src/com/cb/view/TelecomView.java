package com.cb.view;

import java.util.Scanner;

import com.cb.model.Customer;
import com.cb.model.Tariff;
import com.cb.model.TelecomActivity;

public class TelecomView {

	static Scanner sc = new Scanner(System.in);

	static int activityId, customerId, value;
	static String activityType, timeStamp;

	// insert
	public static TelecomActivity doinsertTelecom() {

		System.out.println("Enter the activity id");
		activityId = sc.nextInt();

		System.out.println("Enter the Customer id");
		customerId = sc.nextInt();

		sc.nextLine();

		System.out.println("Enter the activity type (eg : voiceCall , sms , dataUsage) :");
		activityType = sc.nextLine();


//		System.out.println("Enter the timeStamp");
//		timeStamp = sc.nextLine();

		System.out.println("Enter the value ");
		value = sc.nextInt();

		Customer customer = new Customer();
		customer.setCustomerId(customerId);

		Tariff tariff = new Tariff();
		tariff.setActivityType(activityType);
		return new TelecomActivity(activityId, customer, tariff, value);
	}

	// find
	public static int doFindTelecom() {
		System.out.println("Enter activity id");
		return sc.nextInt();
	}

}
