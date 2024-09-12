package bean;

import java.io.Serializable;

public class EPBean implements Serializable {
	private String name;
	private double mWage;
	private double holiday;
	private double bonus;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getmWage() {
		return mWage;
	}
	public void setmWage(double mWage) {
		this.mWage = mWage;
	}
	public double getHoliday() {
		return holiday;
	}
	public void setHoliday(double holiday) {
		this.holiday = holiday;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	

}
