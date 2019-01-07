package ss.additional.week3;

//Exercise 11.3
public abstract class AbstractCounter {
	//Named constants:
	private int count;
	//Constructors:
	public AbstractCounter() {
		this.count = 0;
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
	/**
	 * Command to set the count to a specific value.
	 * @param start - the starting count.
	 */
	public void setCount(int start) {
		this.count = start;
	}
	
	/**
	 * Decrease the count by 1.
	 */
	public void decrease() {
		this.count = this.count - 1;
	}

}
