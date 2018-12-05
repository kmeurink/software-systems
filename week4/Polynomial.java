package ss.week4;


import ss.week3.math.Constant;
import ss.week3.math.Exponent;
import ss.week3.math.Integrable;
import ss.week3.math.Product;
import ss.week3.math.Identity;

public class Polynomial implements Integrable {
	
	//Named constants:
	protected double[] coefficients;
	private double polynomialTotal = 0;
	
	//Constructor:
	
	public Polynomial(double[] array) {
		this.coefficients = array;
	}
	
	//Queries:
	
	
	//Commands:
	/**
	 * Solving a polynomial based on the x argument provided.
	 */
	public double apply(double argument) {
		for (int i = 0; i < this.coefficients.length; i++) {
		//	Exponent polyExponent = new Exponent(this.coefficients.length -	(i + 1));
		//	Identity polyIdentity = new Identity();
		//	Constant polyConstant = new Constant(coefficients[i]);
			System.out.println("Size:" + (this.coefficients.length -	(i + 1)));
			polynomialTotal += (new Product(new Constant(coefficients[i]), new Exponent(this.coefficients.length -	(i + 1)))).apply(argument);
			System.out.println("Polynomial value:" + polynomialTotal);
		}
		System.out.println("Final value:" + polynomialTotal);
		return polynomialTotal;
	}
	
	/**
	 * Models the derivative of a polynomial function.
	 */
	public Function derivative() {
		double[] polynomialDerivative;
		for (int i = 0; i < this.array.length; i++) {
			Exponent polyExponentDer = new Exponent(this.array.length - i);
			Identity polyIdentityDer = new Identity();
			Constant polyConstantDer = new Constant(array[i]);
			//polynomialDerivative += polyConstant.derivative() * polyExponent.derivative();
		}
		return null;
	}
	/**
	 * Models the integral of a polynomial function.
	 */
	public Integrable integral() {
		return null;
	}
}
