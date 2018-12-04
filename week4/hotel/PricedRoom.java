package ss.week4.hotel;


/**
 * Implementing a priced variant of the original Room.
 * @author kester.meurink
 *
 */

public class PricedRoom extends ss.week2.hotel.Room implements ss.week3.bill.Bill.Item {
	
	//Named constants:
	protected PricedSafe hotelSafe;
	protected double roomPrice;
	
	//Constructor:
	/**
	 * Create an instance of the PricedRoom, creating a Room in the process.
	 * @param number - Number of the room.
	 * @param roomPrice - Cost of the created Room.
	 * @param safePrice - Cost of the safe in the room.
	 */
	public PricedRoom(int number, double roomPrice, double safePrice) {
		super(number, new PricedSafe(safePrice));
		this.roomPrice = roomPrice;
	}
	
	//Queries:
	/**
	 * Return the cost of the Room.
	 */
	public double getAmount() {
		return this.roomPrice;
	}
	
	/**
	 * Provide a textual description of the price of the Room.
	 */
	@Override
	public String toString() {
		return "" +  this.roomPrice;
	}
	
	//Commands:
	
	

}
