package thanh3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbtractDAO {
	public Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/mon_anh_thanh";
		String user = "root";
		String pass = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static void main(String[] args) {
		int code = (int) Math.floor(((Math.random() * 899999) + 100000));
		System.out.println(code);
	}
	
}
