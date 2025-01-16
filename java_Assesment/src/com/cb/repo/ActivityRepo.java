package com.cb.repo;

import com.cb.model.Customer;
import com.cb.model.Tariff;
import com.cb.model.TelecomActivity;
import com.cb.util.DBUtil;

import java.sql.*;

import java.util.LinkedList;
import java.util.List;

public class ActivityRepo implements ActivityRepoInter {
	CustomerRepo customerRepo = new CustomerRepo();
	TariffRepo tariffRepo = new TariffRepo();

	// Log telecom activity to database
	public boolean doInsertLog(TelecomActivity activity) {
		boolean flag = false;

		try {

			Connection con = DBUtil.getDBConnection();

			String sql = "INSERT INTO h_activity (activity_id, customer_id, activity_type, timestamp, value) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, activity.getActivityId());
			ps.setInt(2, activity.getCustomer().getCustomerId());
			ps.setString(3, activity.getTariff().getActivityType());
			ps.setString(4, activity.getTimestamp());
			ps.setDouble(5, activity.getValue());

			int n = ps.executeUpdate();

			if (n == 1)
				flag = true;

		} catch (SQLException e) {
			System.out.println("Insert query not executed");
		}
		return flag;
	}

	// findActivityById
	public TelecomActivity doFindLog(int id) {
		TelecomActivity activity = null;

		try {

			Connection con = DBUtil.getDBConnection();

			String sql = "select * from h_activity where activity_Id = ? ";
			PreparedStatement ps;

			ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				activity = new TelecomActivity();

				activity.setActivityId(rs.getInt("activity_id"));

				int customerId = rs.getInt("customer_id");
				Customer customer = customerRepo.doFindCustomer(customerId);
				activity.setCustomer(customer);

				String activityType = rs.getString("activity_type");
				Tariff tarif = tariffRepo.doFindTariff(activityType);
				activity.setTariff(tarif);

				activity.setTimestamp(rs.getString("timestamp"));
				activity.setValue(rs.getDouble("value"));

			}
		} catch (SQLException e) {
			System.err.println("Find query not executed ");

		}

		return activity;
	}

	// AllActivity
	public List<TelecomActivity> doFindAllLog() {
		TelecomActivity activity = null;

		List<TelecomActivity> list = new LinkedList<>();

		try {

			Connection con = DBUtil.getDBConnection();

			String sql = "select * from h_activity ";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				activity = new TelecomActivity();

				activity.setActivityId(rs.getInt("activity_id"));

				int customerId = rs.getInt("customer_id");
				Customer customer = customerRepo.doFindCustomer(customerId);
				activity.setCustomer(customer);

				String activityType = rs.getString("activity_type");
				Tariff tarif = tariffRepo.doFindTariff(activityType);
				activity.setTariff(tarif);

				activity.setTimestamp(rs.getString("timestamp"));
				activity.setValue(rs.getDouble("value"));

				list.add(activity);
			}
		} catch (SQLException e) {
			System.err.println("Find query not executed ");

		}

		return list;
	}

}
