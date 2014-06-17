package com.jdbc.lcm;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) throws SQLException {
		Statement stmt = null;
		Connection conn = DBConfigurationClass.createInstance();

		System.out.println("Creating table in given database...");
		stmt = conn.createStatement();

		String sql1 = "CREATE TABLE avg_lcm_input"
				+ "(InputId INTEGER not NULL IDENTITY(1,1), "
				+ " Number INTEGER not NULL, " + " Status VARCHAR(255), " +

				" PRIMARY KEY ( InputId ))";

		stmt.executeUpdate(sql1);
		System.out.println("Created table  avg_lcm_input");

		String sql2 = "CREATE TABLE avg_lcm_result"
				+ "(ResultId INTEGER not NULL IDENTITY(1,1), "
				+ " Result BIGINT not NULL, " + " InputId INTEGER not NULL, " +

				" PRIMARY KEY ( ResultId),"
				+ "FOREIGN KEY (InputId) REFERENCES avg_lcm_input(InputId))";

		stmt.executeUpdate(sql2);
		System.out.println("Created table  avg_lcm_result");
		System.out.println("Goodbye!");
	}
}
