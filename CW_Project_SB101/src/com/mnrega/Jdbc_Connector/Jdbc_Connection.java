package com.mnrega.Jdbc_Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc_Connection {
	
		
		public static Connection getConnection() {
			
			Connection conn = null;
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Driver not found");
			}
			
			
			String url= "jdbc:mysql://localhost:3306/sb101_cwproject";
			
			try {
				conn = DriverManager.getConnection(url,"root","root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
	}

}
