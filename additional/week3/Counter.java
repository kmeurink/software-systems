package ss.additional.week3;
//Exercise 11.4
/**
 * Class modelling a counter using composition
 * @author kester.meurink
 *
 */
public class Counter {
	//Named constants:
	private int count;
	private Incrementor delegate;
	//Constructors:
	private Counter() {
		
	}
	
	//Queries:
	/**
	 * Query returning the current count.
	 * @return the current count.
	 */
	public int count() {
		return this.count;
	}
	
	//Commands:
	public static Counter createStandardCounter() {
		Counter c = new Counter();
		c.delegate = new AddOne(c);
		c.count = 0;
		return c;
	}
	
	public static Counter createCellDivisionCounter() {
		Counter c = new Counter();
		c.delegate = new Double(c);
		c.count = 1;
		return c;
	}
	
	/**
	 * Command to increase the count.
	 * 
	 */
	public void increment() {
		delegate.increment();
		
	}
	
	/**
	 * Command to decrease the count.
	 */
	public void decrement() {
		this.count = this.count - 1;
	}

	private interface Incrementor {
		
		/**
		 * Method for incrementing the count in a specific way.
		 */
		public void increment();

	}
	/**
	* An "add one" Incrementor.
	*/
	private static class AddOne implements Incrementor {
	private Counter counter;
	/**
	* Creates an "add one" policy for the specified Counter.
	*/
	private AddOne(Counter theCounter) {
	this.counter = theCounter;
	}
	public void increment () {
	counter.count = counter.count + 1;
	}
	/*@ ensures this.initialValue() == 0; */
	/*@ pure */ public int initialValue () {
	return 0;
	}
	}
	/**
	* A "doubling" Incrementor.
	*/
	private static class Double implements Incrementor {
	private Counter counter;
	/**
	* Creates a "double" policy for the specified Counter.
	*/
	private Double(Counter theCounter) {
	this.counter = theCounter;
	}
	public void increment () {
	counter.count = 2 * counter.count;
	}
	/*@ ensures this.initialValue() == 1; */
	/*@ pure */ public int initialValue () {
	return 1;
	}
	
	}
}