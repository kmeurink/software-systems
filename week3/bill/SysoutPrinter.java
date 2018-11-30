package ss.week3.bill;

/**
 * Implementation of the Printer interface using the default methods.
 * @author kester.meurink
 *
 */
public class SysoutPrinter implements Printer{

	public static void main(String[] args) {
		Printer pr = new SysoutPrinter();
		pr.printLine("Text1", 1.00);
		pr.printLine("Other text", -12.1212);
		pr.printLine("Something", 0.20);
	
	}
	
	public SysoutPrinter() {
		
	}
	
	/**
	 * Send the text and price to the printer using format.
	 * @param text - The name of the item
	 * @param price - The cost of the item
	 */
	//@ requires text != null && price >= 0;
	@Override
	public void printLine(String text, double price) {
		System.out.println(format(text, price));
	}
	

}
