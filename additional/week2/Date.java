package ss.additional.week2;
//Used for exercise 6.2

public class Date {
	
	private final int day;
	private final int month;
	private final int year;
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public boolean isLeapYear() {
		boolean aLeapYear;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				aLeapYear = (year % 400 == 0);
			} else {
				aLeapYear = true;
			}
		} else {
			aLeapYear = false;
		}
		return aLeapYear;
	}

}
