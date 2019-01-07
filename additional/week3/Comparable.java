package ss.additional.week3;

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
		if (other instanceof Date) {
			Date otherDate = (Date) other;
			if (Date.year() > otherDate.year) {
				return true;
			} else if (Date.year() == otherDate.year()) {
				if (Date.month() > otherDate.month) {
					return true;
			} else if (Date.month() == otherDate.month()) {
				if (Date.day() > otherDate.day) {
					return true
			} else {
				return false;
			}
		} else {
			return false;
		}
			} else {
				return false;
			}
		} else {
			return false;
		}
		} else {
			return false;
		}
}
