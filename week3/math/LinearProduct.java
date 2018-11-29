package ss.week3.math;

public class LinearProduct extends Product implements Integrable{
	protected Constant argument1;
	
	public LinearProduct(Constant argument1, Function argument2) {
		super(argument1, argument2);
		this.argument1 = argument1;
	}
	
	/**
	 * Applies the corresponding function to the provided argument.
	 * @param argument - being a double value
	 * @return result of the applied function.
	 */
	
	/**
	 * @return Returns the Function object that is a derivative of the current function.
	 */
	public Function derivative() {
		Function derProd1 = new LinearProduct(this.argument1, this.argument2.derivative());
		return derProd1;
	}

	/**
	 * @return Returns the Function object that is an integral of the current function.
	 */
	@Override
	public Function integral() {
		return null; //new LinearProduct(argument1, argument2.integral());
			}
}
