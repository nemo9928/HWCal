package dao;

import java.sql.Statement;

public class RegisterDAO extends ConnectionDAO{

	public int insert(String enterprise, double mWage, double holiday, double bonus) {
		int result = 0;
		String sql = "INSERT INTO enterprise VALUES (?, ?, ?, ?)";
		connect();
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			stmt.setString(1, enterprise);
			stmt.setDouble(2, mWage);
			stmt.setDouble(3, holiday);
			stmt.setDouble(4, bonus);
			result = stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	
	// public int insert(String enterprise, double mWage, double holiday, double bonus) {
	// 	String sql = "INSERT INTO enterprise VALUES('" + enterprise + "', '" + mWage + "','" +
	// 			holiday + "','" + bonus + "')";
	// 	Statement stmt = null;
	// 	int result = 0;
	// 	try {
	// 		connect();
	// 		stmt = con.createStatement();
	// 		result = stmt.executeUpdate(sql);
	// 	}catch(Exception e) {
	// 		e.printStackTrace();
	// 	}finally {
	// 		try {
	// 			if(stmt != null) stmt.close();
	// 		}catch(Exception e) {
	// 			e.printStackTrace();
	// 		}
	// 	}
	// 	disconnect();
	// 	return result;
	// }
}
