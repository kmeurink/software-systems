package ss.additional.week3;

/**
 * General interface for modelling pay.
 * @author kester.meurink
 *
 */
public interface PayCalculator {
	
	/**
	 * Method calculating pay for employee.
	 * @return pay of the employee.
	 */
	public double pay(int hours);

}
