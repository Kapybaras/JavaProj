package uk.ac.bangor.cs.a3.academigymraeg.database;

import java.sql.Connection;

public class DatabaseTest {

		public static void main(String[] args) {
			Connection conn = DatabaseConnector.getConnection();
			
			
			if (conn != null) {
				System.out.println("connected to the database");
			} else {
				System.out.println("Connection failed");
			}
		}
	}