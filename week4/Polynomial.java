package ss.week4;

import ss.week3.math.*;

public class Polynomial implements Integrable {
	
	//Named constants:
	double[] array;
	double polynomialTotal;
	
	//Constructor:
	
	public Polynomial(double[] array) {
		this.array = array;
	}
	
	//Queries:
	
	
	//Commands:
	public double apply(double argument) {
		for (int i = 0; i < this.array.length; i++) {
			polynomialTotal += array[i];
		}
		return polynomialTotal;
	}
	
	
	public Function derivative() {
		return null;
	}
	
	public Integrable integral() {
		return null;
	}
}
