package ss.week4.hotel;

/**
 * Implementing a priced variant of the original Safe.
 * @author kester.meurink
 *
 */

public class PricedSafe extends ss.week2.hotel.Safe implements ss.week3.bill.Bill.Item {
	
	//Named constants:
	protected double price;
	
	//Constructor:
	/**
	 * Create an instance of the PricedSafe, creating a Safe in the process.
	 * @param price - the cost of the created safe.
	 */
	public PricedSafe(double price) {
		super();
		this.price = price;
	}
	
	
	//Queries:
	
	/**
	 * Return the cost of the safe.
	 */
	public double getAmount() {
		return this.price;
	}
	
	/**
	 * Provide a textual description of the price of the safe.
	 */
	@Override
	public String toString() {
		return "" +  this.price;
	}

	
	//Commands:
	
	
	

}
