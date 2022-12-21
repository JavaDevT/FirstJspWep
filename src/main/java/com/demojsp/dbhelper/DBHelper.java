package com.demojsp.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBHelper {

	private String url = "jdbc:mysql://localhost:3306/firstwepapp";
	private String username = "root";
	private String password = "1234";
	public String empTable = "employee";

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");// .newInstance();
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Database connected!");
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("connection error= " + e.getMessage() + " " + e.getLocalizedMessage());
		}
		return null;
	}

	public boolean checkTableExits(String tbName, Connection connection) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "SELECT count(*) FROM" + tbName;
			ResultSet resultset = stmt.executeQuery(sql);
			if (resultset.getRow() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("errror" + e.getMessage());
		}

		return false;
	}

	public boolean createTable(String tableName, String query) {
		Connection connection = getConnection();
		if (connection != null) {
			try {
				if (!checkTableExits(tableName, connection)) {
					Statement stmt = connection.createStatement();
					String sql = "CREATE TABLE " + tableName + " " + query;
					System.out.println(sql);

					stmt.executeUpdate(sql);
					System.out.println("Created table in given database");
				} else
					System.out.println("already cretaed table");

			} catch (SQLException e) {
				System.out.println("errror" + e.getMessage());

			}

		}
		return true;
	}

	public boolean insertDataIntoDb() {

		return true;

	}
	public String checkUser(String username,String password) {
		Connection connection = getConnection();
		if (connection != null) {
			
			try {
 					Statement stmt = connection.createStatement();
 					String sql = "SELECT COUNT(UserName) FROM admindetails "
 							+ "WHERE UserName = '"+username+"' AND "
 							+ "Password = '"+password
 							+ "'LIMIT 0, 1";
 	ResultSet resultset = stmt.executeQuery(sql);

 					if(resultset.getRow()>0) {
 						System.out.println("xxxxxxx");

 						return resultset.getString("UserName");
 					}
 					System.out.println("no user");
 //
  
			} catch (SQLException e) {
				System.out.println("errror" + e.getMessage());

			}

		}
		return "";
	}

}
