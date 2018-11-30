package ss.week3.bill;

import ss.week3.math.Function;

/**
 * Creating a bill for a room in the hotel.
 * @author kester.meurink
 *
 */
public class Bill {
	
	//Constants:
	protected Printer hotelPrinter;
	private double totalSum;
	
	public Bill(Printer printer) {
		this.hotelPrinter = printer;
	}
	
	/**
	 * Abstraction of the items on the bill.
	 */
	//Interface:
	public interface Item {
		
		/**
		 * Show the description of the item
		 * @return the description of the item.
		 */
		public String getDescription();
		
		/**
		 * Show the price associated with the item.
		 * @return Returns the prices associated with an item.
		 */
		public double getPrice();
		
	}
	
	//Queries:
	/**
	 * Returns the current sum total of the Bill.
	 * @return totalSum - the total cost of the bill.
	 */
	public double getSum() {
		return this.totalSum;
	}
	
	//Commands:
	
	/**
	 * Adds an item to this Bill.
	 * The item is sent to the printer,and the amount is added to the sum of the Bill
	 * @param item - An item to be billed.
	 */
	public void addItem(Item item) {
		this.hotelPrinter.printLine(item.getDescription(), item.getPrice());
		totalSum += item.getPrice();
	}
	
	/**
	 * Sends the sum total of the bill to the printer.
	 */
	public void close() {
		this.hotelPrinter.printLine("Total cost is:", totalSum); 
	}
}
