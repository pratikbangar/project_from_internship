package com.jdbc.lcm;
import java.sql.*; 
import java.lang.ClassNotFoundException;

public class StoreResults2  {
	// JDBC driver name and database URL 
	 static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	 static final String DB_URL = "jdbc:sqlserver://172.19.101.121:2301;instanceName=sqlexpress;database=step_pratik_calculator;integratedSecurity=false"; 
	 
	 // Database credentials 
	 static final String USER = "pratik"; 
	 static final String PASS = "pratik"; 
	
	public static void main(String[] args) {
		 Connection conn = null;
		 PreparedStatement pst = null;
		 Statement stmt = null;
		  int temp = 30;
		 LcmCalculator A = new LcmCalculator();
		
		 try{ 
			//STEP 2: Register JDBC driver 
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
			 
			 //STEP 3: Open a connection 
			 
			 conn = DriverManager.getConnection(DB_URL, USER, PASS); 
			 
			 
			 stmt = conn.createStatement(); 
			 
			
			 
			String sql = "SELECT * FROM avg_lcm_input WHERE Status='NULL'"; 
			 ResultSet rs = stmt.executeQuery(sql); 
			 System.out.println("1");
			
			 while(rs.next()){ 
			 //Retrieve by column name 
				 System.out.println("2");
		     int InputId = rs.getInt("Id"); 
			 int Number = rs.getInt("Number"); 
			 String Status = rs.getString("Status");
			 
			 
			 addResult(conn,pst, temp , A.calculateAverage(Number), InputId);
			 temp++;
			 System.out.println("3");
			 
			 sql= "UPDATE avg_lcm_input SET Status='Processed' WHERE Id="+ InputId + "";
		     stmt.executeQuery(sql); 
			 System.out.println("5");
			 
			 
			 //Display values 
			 System.out.println("ID: " + InputId); 
			 System.out.println(",Number: " + Number); 
			 System.out.println(", Status: " + Status); 
			 
			 } 
			 rs.close(); 

			 }
		 
		 catch(ClassNotFoundException e){
			 System.out.println("Error"+ e.getMessage());
		 }
		 catch(SQLException se){ 
			 //Handle errors for JDBC 
			 se.printStackTrace(); 
			 }
		 catch(Exception e){ 
			 //Handle errors for Class.forName 
			 e.printStackTrace(); 
			 }
		 
		 finally{ 
			 //finally block used to close resources 
			 try{ 
				 if(stmt!=null) 
				 conn.close(); 
				 }catch(SQLException se){ 
				 }
			 try{ 
			  if(conn!=null) 
			 conn.close(); 
			 }
			 catch(SQLException se){ 
			 se.printStackTrace(); 
			 }//end finally try 
			 }//end try 
			 System.out.println("Goodbye!"); 
			}//end main 


	public static void addResult(Connection conn, PreparedStatement pst,
			int Id, long Result, int InputId) throws SQLException {
		
		pst = conn.prepareStatement("INSERT INTO avg_lcm_result(Id,Result,InputId) VALUES (?,?,?)");
    	pst.setInt(1, Id);
    	pst.setLong(2, Result);
    	pst.setInt(3, InputId);
    	pst.executeUpdate();
	}

		 }
	


