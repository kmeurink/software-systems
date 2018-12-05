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
			polynomialTotal += (new Product(new Constant(coefficients[i]), new Exponent(this.coefficients.length -	(i + 1)))).apply(argument);
		}
		return polynomialTotal;
	}
	
	/**
	 * Models the derivative of a polynomial function.
	 */
	public Integrable derivative() {
		double[] polynomialDerivative;
		polynomialDerivative = new double[this.coefficients.length - 1];
		for (int i = 0; i < this.coefficients.length - 1; i++) {
			polynomialDerivative[i] = this.coefficients[i] * (this.coefficients.length - (i + 1));
		}
		return new Polynomial(polynomialDerivative);
	}
	/**
	 * Models the integral of a polynomial function.
	 */
	public Integrable integral() {
		double[] polynomialIntegral;
		polynomialIntegral = new double[this.coefficients.length + 1];
		polynomialIntegral[polynomialIntegral.length - 1] = 0.0;
		for (int i = 0; i < this.coefficients.length; i++) {
			polynomialIntegral[i] = this.coefficients[i] / (double)(polynomialIntegral.length - i - 1);
		}
		return new Polynomial(polynomialIntegral);
	}
}
