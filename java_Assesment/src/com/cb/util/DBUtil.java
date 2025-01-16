package com.cb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

		public static Connection getDBConnection() {

			Connection con = null;

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				con = DriverManager.getConnection("jdbc:oracle:thin:@//172.19.0.5:1521/trainingsql.celcom.com", "training",
						"Celcom123");

			} catch (ClassNotFoundException e) {
				System.out.println("Object not found exception ");
			} catch (SQLException e) {
				System.out.println("could not connect with database");
			}
			return con;
		}


}
