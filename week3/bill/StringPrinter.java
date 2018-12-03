package ss.week3.bill;

/** 
 * A variation on Printer that first collects all the lines before printing them with a seperate command.
 * @author kester.meurink
 *
 */
public class StringPrinter implements Printer{
	private String totalLines;
	
	/**public static void main(String[] args) {
		Printer pr = new StringPrinter();
		pr.printLine("Text1", 1.00);
		pr.printLine("Other text", -12.1212);
		pr.printLine("Something", 0.20);
	}
	*/
	public StringPrinter() {
		
	}
	
	/**
	 * Send the text and price to the printer using format.
	 * @param text - The name of the item
	 * @param price - The cost of the item
	 */
	//@ requires text != null && price >= 0;
	@Override
	public void printLine(String text, double price) {
		totalLines += this.format(text, price) + "\n";
	//	System.out.println(totalLines);
	}
	
	/**
	 * A method that returns the total string collected using printLine()
	 */
	public String getResult() {
		return totalLines;
	}

}
