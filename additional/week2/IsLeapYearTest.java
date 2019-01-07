package ss.additional.week2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
//Exercise 6.2
/**
 * Class to test the IsLeapYear method.
 * @author kester.meurink
 *
 */
public class IsLeapYearTest {
	private Date year1904;//Divisible by 4, but not 100.
	private Date year1900;//Divisible by 100, and 4, but not 400.
	private Date year1901;////Divisible by neither 100 nor 4.
	private Date year2000;//Divisble by by 100 and 4 and 400.
	
	@Before
	public void setUp() {
		year1904 = new Date(1, 1, 1904);
		year1900 = new Date(1, 1, 1900);
		year1901 = new Date(1, 1, 1901);
		year2000 = new Date(1, 1, 2000);
	}
	
	@Test
	public void yearTest() {
		assertTrue(year1904.isLeapYear());
		assertFalse(year1901.isLeapYear());
		assertFalse(year1900.isLeapYear());
		assertTrue(year2000.isLeapYear());
	}

}
