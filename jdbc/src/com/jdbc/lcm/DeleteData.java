package com.jdbc.lcm;
import java.sql.*; 



public class DeleteData {
	

	public static void main(String[] args) throws SQLException {
		 Connection conn = null;
		 Statement stmt = null; 
         conn= DBConfigurationClass.createInstance();
		 stmt = conn.createStatement(); 
		 deleteResult(stmt);
}

	private static void deleteResult(Statement stmt) throws SQLException {
		String sql1= "DELETE FROM avg_lcm_result";
			stmt.executeUpdate(sql1);
			System.out.println("Deleted everything from avg_lcm_result");
			
			String sql2= "DELETE FROM avg_lcm_input";
			stmt.executeUpdate(sql2);
			 System.out.println("Deleted everything from avg_lcm_input");
	}
}