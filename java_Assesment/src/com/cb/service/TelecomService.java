package com.cb.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import com.cb.model.TelecomActivity;
import com.cb.repo.ActivityRepo;
import com.cb.repo.ActivityRepoInter;


public class TelecomService {

	ActivityRepoInter activityRepo = new ActivityRepo();

	// insertvalidation
	public String insertActivityValidation(TelecomActivity activity) {
		String result;

		if (activity == null) {
			result = "activity Object is Null ";
		} else if (activity.getActivityId() == 0 || activity.getCustomer().getCustomerId() == 0
				|| activity.getTariff().getActivityType() == null || activity.getValue() == 0) {
			result = "Invalid activity Data";
		} else {
			LocalDateTime currentDateTime = LocalDateTime.now();
			//System.out.println("TimeStamp : "+currentDateTime);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:MM:SS");
			String timeStamp = currentDateTime.format(formatter);
			
			activity.setTimestamp(timeStamp);

			boolean flag = activityRepo.doInsertLog(activity);
			if (flag) {
				result = "activity Object Saved";
			} else {
				result = "activity Object Not Saved ";
			}
		}
		return result;
	}

	// find method
	public String findActivityValidation(int id) {
		String result = "";

		if (id == 0) {
			result = "Invalid Id";
		} else {
			TelecomActivity activity = activityRepo.doFindLog(id);
			if (activity != null) {
				result = activity.toString();
			} else {
				result = "activity Object not Found";
			}
		}
		return result;

	}

	// find all
	public String findAllActivityValidation() {
		return activityRepo.doFindAllLog().toString();
	}

}