package it.polito.tdp.ufo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public static Connection getConnection() throws SQLException {
			
			String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root&password=nietzsche10+";
			return DriverManager.getConnection(jdbcURL);
			
		}
	

}
