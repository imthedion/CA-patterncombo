package patternComboCA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSource {
	
	// private strings  to connect to database, its user and password
	private String db = "jdbc:mysql://localhost.com:3306/customer";
	private String un = "CCTstudent";
	private String pw = "pass1234!";
	
	// implementing these methods here will make it accessible to any methods inside
	private Connection connect;
	private Statement state;
	
	public DataSource() {
		
		// constructor creats connection and the statement
		try{
			
			// connects to the databse
			connect = DriverManager.getConnection( db, un, pw ) ;

			// collects statement from the connection
			state = connect.createStatement() ;
			
		}
		catch( SQLException se ){
			System.out.println( "SQL Exception:" ) ;

			// Loop through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;
				
				
				
				
				
				System.out.println(" My apologies if i dont have anything working Amilcar, I still find java difficult :/  ");

				se = se.getNextException() ;
			}
		}
		catch( Exception e ){
			System.out.println( e ) ;
		}
	}
	
	// using the Query Variable, it will insert any statement that we pass in
	public ResultSet select(String query) {
		// Execute the query
		ResultSet rs = null;
		try {
			 rs = state.executeQuery( query ) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
	
	// using the Query Variable, it will insert any statement that we pass in
	public boolean save(String query) {
		
		try {
			
			// doesnt return any values because it is an insert statement
			state.execute( query );
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	// a separated method to end the connection
	public void closing() {
		try {
			state.close();
			connect.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
