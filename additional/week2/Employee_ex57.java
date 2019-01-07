package ss.additional.week2;
/**
 * 
 * @author kester.meurink
 * Models an employee
 */
public class Employee_ex57 {
	private final int workingHours = 40; // maximal normal working hours
	private final double overtimeRate = 1.5; //Multiplier for the pay during overtime
	
	
	//Constructor:
	/**
	 * Create a new employee.
	 */
	public Employee_ex57() {
		
	}
	//Exercise 5.7
	/**
	 * The employee's pay for the week, given the hours worked during the week 
	 * and the pay rate in dollars per hour.
	 * 
	 */
	//@requires hours >= 0 && hours <= 80;
	//@requires rate >= 5 && rate <= 200;
	//@ensures \result >= 0;
	public double pay(int hours, double rate) {
		double pay;
		if (hours <= workingHours) {
			pay = hours * rate;
		} else {
			pay = (workingHours * rate) + (hours % workingHours) * overtimeRate * rate;
		}
		return pay;
	}
}
