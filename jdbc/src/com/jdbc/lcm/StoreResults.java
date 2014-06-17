package com.jdbc.lcm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.LimitExceededException;

public class StoreResults {

	public static void main(String[] args) {
		PreparedStatement pst = null;
		Statement stmt = null;

		LcmCalculator lcmCalculator = new LcmCalculator();

		try {

			Connection conn = DBConfigurationClass.createInstance();

			stmt = conn.createStatement();

			calculateAndSaveResult(pst, stmt, lcmCalculator, conn);

			updateStatus(stmt);

		}

		catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	private static void updateStatus(Statement stmt) throws SQLException {
		String sql = "UPDATE avg_lcm_input SET Status='Processed' ";
		stmt.executeUpdate(sql);
	}

	private static void calculateAndSaveResult(PreparedStatement pst,
			Statement stmt, LcmCalculator lcmCalculator, Connection conn)
			throws SQLException, NegativeNoException, LimitExceededException {
		String sql = "SELECT * FROM avg_lcm_input WHERE Status IS NULL";
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {

			int InputId = rs.getInt("Id");
			int Number = rs.getInt("Number");
			String Status = rs.getString("Status");

			insertResult(conn, pst, lcmCalculator.calculateAverage(Number),
					InputId);

			System.out.print("\n ID: " + InputId);
			System.out.print(",Number: " + Number);
			System.out.print(", Status: " + Status);

		}
		rs.close();
	}

	public static void insertResult(Connection conn, PreparedStatement pst,
			long Result, int InputId) throws SQLException {

		pst = conn
				.prepareStatement("INSERT INTO avg_lcm_result(Result,InputId) VALUES (?,?)");

		pst.setLong(1, Result);
		pst.setInt(2, InputId);
		pst.executeUpdate();
	}

}
