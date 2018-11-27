package ss.week3.math;

public class Constant implements Function{

	private double argument;
	private Constant con;
	private String read = "";
	public static void main(String[] args) {
		Print.print(new Constant(2.0));
	}
	
	public Constant(double argument) {
		this.argument = argument;
	}
	
	/**
	 * Applies the corresponding function to the provided argument.
	 * @param argument - being a double value
	 * @return result of the applied function.
	 */
	public double apply(double argument) {
		return this.argument;
	}
	
	/**
	 * @return Returns the Function object that is a derivative of the current function.
	 */
	public Function derivative() {
		Constant con = new Constant(0);
		return con;
	}
	
	/**
	 * Returns a readable string representation of the Function.
	 */
	public String toString() {
		return read + this.apply(argument);
	}

}
