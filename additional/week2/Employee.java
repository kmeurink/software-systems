package ss.additional.week2;
/**
 * 
 * @author kester.meurink
 * Models an employee
 */
public class Employee {
	private int hours; //Hours worked in the week
	private double rate; //hourly pay rate (dollars)
	private final int workingHours = 40; // maximal normal working hours
	private final double overtimeRate = 1.5; //Multiplier for the pay during overtime
	
	
	//Constructor:
	/**
	 * Create a new employee.
	 */
	public Employee() {
		
	}
	
	/**
	 * The employee's pay for the week.
	 * 
	 */
	public double pay() {
		double pay;
		if (hours <= workingHours) {
			pay = hours * rate;
		} else {
			pay = (workingHours * rate) + (hours % workingHours) * overtimeRate * rate;
		}
		return pay;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}
	
	public void setHours(int hours) {
		this.hours = hours;
	}
}
