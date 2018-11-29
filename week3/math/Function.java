package ss.week3.math;

public interface Function{
	
	/**
	 * Applies the corresponding function to the provided argument.
	 * @param argument - being a double value
	 * @return result of the applied function.
	 */
	public double apply(double argument);
	
	/**
	 * @return Returns the Function object that is a derivative of the current function.
	 */
	public Function derivative();
	
	/**
	 * Returns a readable string representation of the Function.
	 */
	public String toString();
}
