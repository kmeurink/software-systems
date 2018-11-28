package ss.week3.math;

public class Identity implements Function{
	
	private double argument;

	public Identity() {	
	}
	
	
	/**
	 * Applies the corresponding function to the provided argument.
	 * @param argument - being a double value
	 * @return result of the applied function.
	 */
	public double apply(double argument) {
		return argument;
	}
	
	/**
	 * @return Returns the Function object that is a derivative of the current function.
	 */
	public Function derivative() {
		Constant con = new Constant(1);
		return con;
	}
	
}
