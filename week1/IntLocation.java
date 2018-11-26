package ss.week1;
/**
 * A class to determine show the seperate digits of a two digit number.
 * @author kester.meurink
 *
 */
public class IntLocation {
	private int tens;
	private int ones;
	
	//Constructors:
	/**
	 * 
	 * @param val
	 */
	
	
	public void assignment(int val) {
		while (val > 9) {
			ones = val % 10;
			tens = val / 10;
		}
	}

}
