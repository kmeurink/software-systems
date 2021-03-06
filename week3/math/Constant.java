package ss.week3.math;

public class Constant implements Integrable{

	private double argument;
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
	 * @return Returns the Function object that is an integral of the current function.
	 */
	@Override
	public Integrable integral() {
		
		return new Product(new Constant(this.argument), new Identity());
	}
	
	/**
	 * Returns a readable string representation of the Function.
	 */
	public String toString() {
		return read + this.apply(argument);
	}

}
