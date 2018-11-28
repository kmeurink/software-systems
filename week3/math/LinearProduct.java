package ss.week3.math;

public class LinearProduct extends Product{
	private Function argument1;
	private Function argument2;
	private double totalProduct;
	
	public LinearProduct(Function argument1, Function argument2) {
		super(argument1, argument2);
		this.argument1 = argument1;
		this.argument2 = argument2;
	}
	
	/**
	 * Applies the corresponding function to the provided argument.
	 * @param argument - being a double value
	 * @return result of the applied function.
	 */
	public double apply(double argument) {
		double partProduct1 = this.argument1.apply(argument);
		double partProduct2 = this.argument2.apply(argument);
		totalProduct = partProduct1 * partProduct2;
		return totalProduct;
	}
	
	/**
	 * @return Returns the Function object that is a derivative of the current function.
	 */
	public Function derivative() {
		Function derivative1 = argument1.derivative();
		Function derProd1 = new LinearProduct(derivative1, argument2);
		return derProd1;
	}

}
