package ss.additional.week3;
//Exercise 9.8
public class Employee {
	//Named Constants:
	private int hours;
	
	//Constructors:
	public Employee(int hours) {
		this.hours = hours;
	}
	
	//Queries:
	/**
	 * The number of hours the employee has worked.
	 * @return the number of worked hours.
	 */
	public int hours() {
		return this.hours;
	}
	/**
	 * The employee's pay for the current period in dollars. 
	 * @return the pay of the employee.
	 */
	public double pay(PayCalculator calc) {
		return calc.pay(this.hours());
	}
	
	//Commands:
	
	
}
