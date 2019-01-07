package ss.additional.week3;

public class FixedPay implements PayCalculator{
	private double rate;
	
	public FixedPay(double rate) {
		this.rate = rate;
	}
	/**
	 * Method calculating pay for employee, assuming a fixed rate.
	 * @return pay of the employee.
	 */
	public double pay(int hours) {
		return (double) hours * rate;
	}
}
