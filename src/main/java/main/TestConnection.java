package main;
import java.sql.*;
public class TestConnection {
	public static void main(String[] args) {
		// https://gayerie.dev/docs/jakartaee/javaee_orm/jdbc.html
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 try {
			Connection ctx = DriverManager.getConnection("jdbc:mysql://localhost:3306/photocopy","root","");
			
			Statement stmt = ((java.sql.Connection) ctx).createStatement();
	        String query = "SELECT * FROM users WHERE username =  'admin'";

			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString(1)+" : "+rs.getString(2));
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		 

	}

 

}
