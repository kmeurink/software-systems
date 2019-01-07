package ss.additional.week2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
//Exercise 6.5
public class EmployeePayTest {
	private Employee pete;
	private static final double DELTA = 1e-15;

	
	
	@Before
	public void setUp() {
		pete = new Employee();

	}
	
	@Test
	public void testPay0() {
		pete.setHours(0);
		pete.setRate(0);
		assertEquals(0, pete.pay(), DELTA);
	}
	
	@Test
	public void testPaybelow() {
		pete.setHours(30);
		pete.setRate(20);
		assertEquals(600, pete.pay(), DELTA);
	}
	
	@Test
	public void testPayover() {
		pete.setHours(50);
		pete.setRate(20);
		assertEquals(1100, pete.pay(), DELTA);
	}
	
	@Test
	public void testPayBal() {
		pete.setHours(40);
		pete.setRate(20);
		assertEquals(800, pete.pay(), DELTA);
	}

}
