package ss.week3.math;

public class Identity implements Integrable{
	
	private double argument;

	public static void main (String[] args) {

		Print.print(new Identity());

	}
	
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
	
	/**
	 * @return Returns the Function object that is an integral of the current function.
	 */
	public Integrable integral() {
		return new Product(new Constant(0.5), new Exponent(2));
	}
	
	@Override

	public String toString() {

		return "x";

	}
}
