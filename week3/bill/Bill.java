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
	protected boolean billClosed = false;
	
	public Bill(Printer printer) {
		this.hotelPrinter = printer;
		this.totalSum = 0.0;
	}
	
	/**
	 * Abstraction of the items on the bill.
	 */
	//Interface:
	public static interface Item {
		
		/**
		 * Show the amount of the item.
		 * @return Returns the amount associated with an item.
		 */
		public double getAmount();
		
		public String toString();
		
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
	public void addItem(Bill.Item item) {
		this.hotelPrinter.printLine(item.toString(), item.getAmount());
		totalSum += item.getAmount();
	}
	
	/**	
	 * Sends the sum total of the bill to the printer.
	 */
	public void close() {
		this.hotelPrinter.printLine("Total cost is: ", totalSum);
		billClosed = true;
	}
	
}
