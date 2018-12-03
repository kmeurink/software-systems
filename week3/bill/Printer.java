package ss.week3.bill;

public interface Printer {

	/**
	 * A method that returns a formatted line containing text and price, ending on a newline.
	 * @param text - The name of the item
	 * @param price - The cost of the item
	 * @return A line containing the name and price.
	 */
	//@ requires text != null && price >= 0;
	//@ ensures \result != null;
	default
		public String format(String text, double price) {
		return String.format("%-18s %8.2f \n", text, price);
	}
	
	/**
	 * Send the text and price to the printer using format.
	 * @param text - The name of the item
	 * @param price - The cost of the item
	 */
	//@ requires text != null && price >= 0;
	public void printLine(String text,double price);
	

}
