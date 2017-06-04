package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

private static Connection connection;

public static Connection connectionToDataBase(){
	
	try {
		Class.forName("org.postgresql.Driver");
	 }
	 catch (ClassNotFoundException e){
		 System.err.println("no jdbc driver");
		 e.printStackTrace();
			return null;
	 }
	
	connection = null;
	
	try {
		connection = DriverManager.getConnection(
				"jdbc:postgresql://127.0.0.1:5432/bouldermanager", "postgres",
				"kalandraka2");

	} catch (SQLException e) {
		System.err.println("cannot estabilished connection to Database");
		e.printStackTrace();
		return null;
	}

	if (connection == null) {
		System.err.println("connection failed");
	}
	return connection;
	
}

}
