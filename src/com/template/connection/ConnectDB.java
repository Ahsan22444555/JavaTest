package com.template.connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectDB {
	
	
	
	public Connection connection() {
		
	try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://test.czeovxzgszud.us-east-2.rds.amazonaws.com:3306/Test", "admin", "belal123");
            return con;
	}
	
	catch(Exception e) {
		System.out.println("Hello Down Server! ");
		e.printStackTrace();
	}
	return null;
}
}
