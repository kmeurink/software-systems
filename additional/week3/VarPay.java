package ss.additional.week3;

public class VarPay implements PayCalculator {
	private double rate;
	private double overTimeRate;
	private int hourLimit;
	
	public VarPay(double rate, int hourLimit, double overTimeRate) {
		this.rate = rate;
		this.overTimeRate = overTimeRate;
		this.hourLimit = hourLimit;
	}
	/**
	 * Method calculating pay for employee, assuming a variable rate.
	 * @return pay of the employee.
	 */
	public double pay(int hours) {
		double pay;
		if (hours <= hourLimit) {
			pay = hours * rate;
		} else {
			pay = (hourLimit * rate) + (hours % hourLimit) * overTimeRate * rate;
		}
		return pay;
	}
}
