package com.cb.repo;


import com.cb.model.Tariff;
import com.cb.util.DBUtil;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TariffRepo implements TariffRepoInter {

	// Retrieve tariff by activity type (e.g., 'Call', 'SMS', 'Data')
	public Tariff doFindTariff(String activityType) {
		Tariff tariff = null;

		try {

			Connection con = DBUtil.getDBConnection();

			String sql = "SELECT * FROM h_tariff WHERE activity_type = ?";
			PreparedStatement ps;

			ps = con.prepareStatement(sql);

			ps.setString(1, activityType);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				tariff = new Tariff();
				tariff.setActivityType(rs.getString("activity_type"));
				tariff.setRate(rs.getDouble("rate"));
			}

		} catch (SQLException e) {
			System.out.println("Find query not executed");
		}

		return tariff;
	}

	// Update tariff rate
	public boolean doUpdateTariff(Tariff tariff) {
		boolean flag = false;

		try {

			Connection con = DBUtil.getDBConnection();

			String sql = "UPDATE h_tariff SET rate = ? WHERE activity_type = ?";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);

			ps.setDouble(1, tariff.getRate());
			ps.setString(2, tariff.getActivityType());

			int n = ps.executeUpdate();

			if (n == 1)
				flag = true;

		} catch (SQLException e) {
			System.out.println("update query not executed");
		}
		return flag;
	}

	// Insert a new tariff record
	public boolean insertTariff(Tariff tariff) {

		boolean flag = false;

		try {

			Connection con = DBUtil.getDBConnection();

			String sql = "INSERT INTO h_tariff (activity_type, rate) VALUES (?, ?)";

			PreparedStatement ps;
			ps = con.prepareStatement(sql);

			ps.setDouble(1, tariff.getRate());
			ps.setString(2, tariff.getActivityType());

			int n = ps.executeUpdate();

			if (n == 1)
				flag = true;

		} catch (SQLException e) {
			System.out.println("Insert query not executed");
		}
		return flag;
	}
	
	
	
	// do find all
		public List<Tariff> doFindAllTariff() {
			Tariff tariff = null;

			List<Tariff> list = new LinkedList<>();
			try {
				Connection con = DBUtil.getDBConnection();

				String sql = "select * from h_Tariff  ";
				PreparedStatement ps;

				ps = con.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					tariff = new Tariff();
					tariff.setActivityType(rs.getString("activity_type"));
					tariff.setRate(rs.getDouble("rate"));
			

					list.add(tariff);

				}

			} catch (SQLException e) {
				System.out.println("Find query not executed");
			}

			return list;

		}

}
