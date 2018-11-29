package ss.week3.math;

public class Exponent implements Integrable{
	
	private Function argument1;
	private Function argument2;
	private double totalExponent;
	private int numeral;
	
	public static void main(String[] args) {
		Print.print(new Exponent(3));	}
	
	public Exponent(int numeral) {
		this.numeral = numeral;
	}
	
	
	/**
	 * Applies the corresponding function to the provided argument.
	 * @param argument - being a double value
	 * @return result of the applied function.
	 */
	public double apply(double argument) {
		if (numeral == 0) {
			return 1;
		} else {
			int i = 1;
			totalExponent = argument;
			while (i < numeral) {
				totalExponent = argument * argument; 
				i = i + 1;
			}
			return totalExponent;
		}
	}
	
	/**
	 * @return Returns the Function object that is a derivative of the current function.
	 */
	public Function derivative() {
		Function partExponent = new Exponent(numeral - 1);
		Constant partConstant = new Constant(numeral);
		
		return new LinearProduct(partConstant, partExponent);
	}

	/**
	 * @return Returns the Function object that is an integral of the current function.
	 */
	public Function integral() {
		return new LinearProduct(new Constant(1/(numeral + 1)), new Exponent(numeral + 1));
	}
	
	@Override

	public String toString() {
		return "x^" + this.numeral;

	}
	
}
