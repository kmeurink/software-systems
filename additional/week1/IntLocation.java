package ss.additional.week1;
/**
 * A class to determine show the seperate digits of a two digit number.
 * @author kester.meurink
 *
 */
public class IntLocation {
	private int tens;
	private int ones;
	
	//Constructors:
	public IntLocation() {
		
	}
	/**
	 * 
	 * @param val
	 */
	//Queries:
	public int tens() {
		return this.tens;
	}
	
	public int ones() {
		return this.ones;
	}
	
	
	//Commands:
	public void assignment(int val) {
		if (val > 9) {
			this.ones = val % 10;
			this.tens = val / 10;
		} else {
			this.ones = val;
			this.tens = 0;
		}
	}

}
