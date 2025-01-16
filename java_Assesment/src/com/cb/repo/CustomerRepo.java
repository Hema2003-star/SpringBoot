package com.cb.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.cb.model.Customer;
import com.cb.util.DBUtil;

public class CustomerRepo implements CustomerRepoInter {

	// insert query logic for customer
	public boolean doInsertCustomer(Customer customer) {
		boolean flag = false;

		try {
			Connection con = DBUtil.getDBConnection();

			String sql = "insert into h_customer values(?,?,?,?)";
			PreparedStatement ps;

			ps = con.prepareStatement(sql);

			ps.setInt(1, customer.getCustomerId());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getAddress());
			ps.setLong(4, customer.getContactNumber());

			int n = ps.executeUpdate();

			if (n == 1)
				flag = true;

		} catch (SQLException e) {
			System.out.println("Insert query not executed");
		}
		return flag;

	}

	// find validation
	public Customer doFindCustomer(int id) {
		Customer customer = null;
		try {
			Connection con = DBUtil.getDBConnection();

			String sql = "select * from h_customer where customer_Id = ? ";
			PreparedStatement ps;

			ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getInt("customer_Id"));
				customer.setName(rs.getString("name"));
				customer.setAddress(rs.getString("address"));
				customer.setContactNumber(rs.getLong("contact_Number"));

			}

		} catch (SQLException e) {
			System.out.println("Find query not executed");
		}

		return customer;
	}

	// do find all
	public List<Customer> doFindAllCustomer() {
		Customer customer = null;

		List<Customer> list = new LinkedList<>();
		try {
			Connection con = DBUtil.getDBConnection();

			String sql = "select * from h_customer  ";
			PreparedStatement ps;

			ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getInt("customer_Id"));
				customer.setName(rs.getString("name"));
				customer.setAddress(rs.getString("address"));
				customer.setContactNumber(rs.getLong("contact_Number"));

				list.add(customer);

			}

		} catch (SQLException e) {
			System.out.println("Find query not executed");
		}

		return list;

	}

}
