package ss.week3.math;

public class Sum implements Integrable{
	private Function argument1;
	private Function argument2;
	private String read = "";
	private double totalSum;
	
	public static void main(String[] args) {
		Print.print(new Sum(new Constant(2.0), new Identity()));	}
	
	public Sum(Function argument1, Function argument2) {
		this.argument1 = argument1;
		this.argument2 = argument2;
	}
	
	/**
	 * Applies the corresponding function to the provided argument.
	 * @param argument - being a double value
	 * @return result of the applied function.
	 */
	public double apply(double argument) {
		double partSum1 = this.argument1.apply(argument);
		double partSum2 = this.argument2.apply(argument);
		totalSum = partSum1 + partSum2;
		return totalSum;
	}
	
	/**
	 * @return Returns the Function object that is a derivative of the current function.
	 */
	public Function derivative() {
		Function derivative1 = argument1.derivative();
		Function derivative2 = argument2.derivative();
		return new Sum(derivative1, derivative2);
	}
	
	/**
	 * @return Returns the Function object that is an integral of the current function.
	 */
	public Integrable integral() {
		return null;
	}
	
	/**
	 * Returns a readable string representation of the Function.
	 */
	@Override

	public String toString() {

		return this.argument1.toString() + " + " + this.argument2.toString();

	}
}
