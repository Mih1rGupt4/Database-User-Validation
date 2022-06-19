package util;

import java.sql.*;
public class DataBaseConnection {
	
	//load the driver
	//get the connection
	//creating statement - sql query
	// executing get statement
	//close 	
	private static Connection connect = null;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital","root","test");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return connect;
	}
}