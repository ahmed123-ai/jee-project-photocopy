package main;

import java.sql.*;

public class JDBCUtil {

	public static Statement stmt;

	  
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection ctx;
		try {
			ctx = DriverManager.getConnection("jdbc:mysql://localhost:3306/photocopy", "root", "");
	
			  stmt = ((java.sql.Connection) ctx).createStatement();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Statement getStatet() {
		return stmt;
	}

	public static void closeConnection() {
		if (stmt != null) {
			try {
				stmt.close();
				stmt = null; 
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
