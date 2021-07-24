package com.vocab.api.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GlobalConnection {    
	// JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://localhost:3306/vocabs_db";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "1111";
    
    static Connection connection;
    
    public static void main(String[] args) {
    	System.out.println("OK");
    	open();
    	close();
    }
    
    public static PreparedStatement getPreparedStatement(String sql) {
    	try {
			return connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
    }
        
    public static boolean open() {
    	try {//STEP 2: Register JDBC driver

        	if(connection != null && !connection.isClosed()) {
                System.out.println("Connected already, no need 2 open...");
        		return true;
        	}
            Class.forName("org.mariadb.jdbc.Driver");
            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");
    	} catch (Exception e) {
    		System.out.println(e.toString());
		}
    	return true;
    }
    
    public static void close() {
    	try {
    		if(connection != null && !connection.isClosed()) {
    			connection.close();
    		}
    		System.out.println("Close connection 2 database! success");
    	} catch (Exception e) {
			// TODO: handle exception
    		System.out.println(e.toString());
		}
    }
}
