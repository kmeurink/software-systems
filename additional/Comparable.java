package ss.additional;

/**
 * Recommended exercises exercise 9.3
 * @author kester.meurink
 *
 */
/**
 * Compare the dates of two Date object.
 * @author kester.meurink
 *
 */
public class Comparable {
	
	public Comparable() {
		
	}
	/**
	 * Return true if the date of the Date is greater than that of the Date compared.
	 */
	public boolean greaterThan(Comparable other) {
		if (year > other.year) {
			return true;
		} else if (month > other.month) {
			return true;
		} else if (day > other.day) {
			return true
		} else {
		return false;
		}
	}
}
