package dao;

import java.sql.ResultSet;
import java.sql.Statement;

import bean.EPBean;
import bean.EPListDTO;
	
public class SearchDAO extends ConnectionDAO{
	public EPListDTO select(String name) {
		EPListDTO dto = new EPListDTO();
		String sql = "";
		if(name.equals("企業検索")) {
			sql = "select * from enterprise";
		}else {
			sql = "select * from enterprise where name like '" + name + "'";
		}
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				EPBean bean = new EPBean();
				bean.setName(rs.getString("name"));
				bean.setmWage(rs.getDouble("monthWage"));
				bean.setHoliday(rs.getDouble("holiday"));
				bean.setBonus(rs.getDouble("bonus"));
				dto.add(bean);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		disconnect();
		return dto;
	}
}
