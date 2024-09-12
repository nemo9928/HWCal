package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDAO {
	private String URL = "jdbc:mysql://localhost/enterprisesdb";
	private String USER = "root";
	private String PASS = "pass";
	Connection con = null;
	
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASS);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void disconnect() {
		try {
			if(con != null)con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
