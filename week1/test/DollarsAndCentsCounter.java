package ss.week1.test;

/**
 * Models a dollars and cents counter.
 * @author kester.meurink
 */
public class DollarsAndCentsCounter {

	private int dollars; //amount of dollars
	private int cents; //amount of cents
	//Constructor:
	/**
	 * Create a new DollarsAndCentsCounter.
	 */
	public DollarsAndCentsCounter() {
		
	}
	//Queries:
	/**
	 * return the current amount of dollars.
	 * @ensure this.dollars() >= 0
	 */
	public int dollars() {
		return dollars;
	}
	/**
	 * return the current amount of cents.
	 * @ensure this.cents() >= 0 && this.cents() <= 99
	 */
	public int cents() {
		return cents;
	}
		
	//Commands:
	/**
	 * Add dollars and cents to the counter.
	 */
	public void add(int dollars, int cents) {
		
		this.dollars = this.dollars + dollars;
		this.cents = this.cents + cents;
		if (this.cents >= 100) {
			this.cents = (this.cents % 100);
			this.dollars = this.dollars + 1;
		}

	}
	/**
	 * Reset the dollars and cents counter.
	 */
	public void reset() {
		dollars = 0;
		cents = 0;
	}
	
}
