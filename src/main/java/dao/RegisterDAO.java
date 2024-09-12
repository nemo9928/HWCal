package dao;

import java.sql.Statement;

public class RegisterDAO extends ConnectionDAO{
		
	public int insert(String enterprise, double mWage, double holiday, double bonus) {
		String sql = "INSERT INTO enterprise VALUES('" + enterprise + "', '" + mWage + "','" +
				holiday + "','" + bonus + "')";
		Statement stmt = null;
		int result = 0;
		try {
			connect();
			stmt = con.createStatement();
			result = stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt != null) stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		disconnect();
		return result;
	}
}
