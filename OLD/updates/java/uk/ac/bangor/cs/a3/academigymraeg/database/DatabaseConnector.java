package uk.ac.bangor.cs.a3.academigymraeg.database;

import java.sql.Connection; 
import java.sql.DriverManager; 

public class DatabaseConnector {

		private static final String URL = "jdbc:mysql://mysql.cs.bangor.ac.uk:3306/lkg24ndq?serverTimezone=Europe/London";
		private static final String USER = "lkg24ndq";
		private static final String PASSWORD = "745314656f";
		
		public static Connection getConnection() {
			try { 
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				return DriverManager.getConnection(URL, USER, PASSWORD);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}

