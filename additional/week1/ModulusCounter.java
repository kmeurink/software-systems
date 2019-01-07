package ss.additional.week1;
/**
 * 	Model a modulus algorithm.
 * @author kester.meurink
 *
 */
public class ModulusCounter {
	private int max;
	private int mod; //Value of the modulus.
	//Constructor:
	/**
	 * 	Create a new Modulus, specifying the maximal value of the count.
	 * 
	 */
	public ModulusCounter(int max) {
		this.max = max;
		this.mod = 0;
	}
	//Queries:
	/*
	 * Show the answer of the modulus.
	 */
	public int answer() {
		return mod;
	}
	
	public int max() {
		return this.max;
	}
	
	//Commands:
	/**
	 * 	Calculate the remainder of the value entered.
	 * @ensure this.count() == old.count() % max;
	 */
	public void mod(int value) {
		this.mod = value - max * (value / max);
	}
	
	public void reset() {
		this.mod = 0;
	}

}
