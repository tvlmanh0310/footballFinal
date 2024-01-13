package com.example.util;

import java.sql.*;

public class ConnectSQL {
//	 private static String DB_URL = "jdbc:mysql://localhost:3306/football_season_management";
//	    private static String USER_NAME = "root";
//	    private static String PASSWORD = "03102003";
	 
	    /**
	     * main
	     * 
	     * @author viettuts.vn
	     * @param args
	     */
	    public static void main(String args[]) {
	    	try (Connection connection = ConnectSQL.getConnection()) {
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	 
	 
	    /**
	     * create connection 
	     * 
	     * @author viettuts.vn
	     * @param dbURL: database's url
	     * @param userName: username is used to login
	     * @param password: password is used to login
	     * @return connection
	     */
	    public static Connection getConnection() {
	        Connection connection = null;
	        String dbURL = "jdbc:mysql://localhost:3306/football_season_management";
	        String userName = "root";
	        String password = "03102003";  		
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection(dbURL, userName, password);
	            System.out.println("connect successfully!");
	        } catch (Exception ex) {
	            System.out.println("connect failure!");
	            ex.printStackTrace();
	        }
	        return connection;
	    }
}
