package com.jdbc.lcm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {

	public static void main(String[] args) throws SQLException {
		
		insertData(args);

		System.out.println("Data Inserted");
	}

	private static void insertData(String[] args) throws SQLException {
		
		PreparedStatement pst = null;

		Connection conn = DBConfigurationClass.createInstance();
		addMultipleValues(args, pst, conn);
	}

	private static void addMultipleValues(String[] args, PreparedStatement pst,
			Connection conn) throws SQLException {

		for (String value : args) {
			pst = conn
					.prepareStatement("INSERT INTO avg_lcm_input(Number) VALUES (?)");
			pst.setInt(1, Integer.valueOf(value));
			pst.executeUpdate();
		}
	}

	public static void addEntry(PreparedStatement pst, int Number,
			Connection conn) throws SQLException {
		pst = conn
				.prepareStatement("INSERT INTO avg_lcm_input(Number) VALUES (?)");
		pst.setInt(1, Number);
		pst.executeUpdate();
	}
}