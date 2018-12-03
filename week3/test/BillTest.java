package ss.week3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.week3.bill.Bill;
import ss.week3.bill.StringPrinter;
import ss.week3.bill.SysoutPrinter;

public class BillTest {
	
	/**
	 * Sets initial variables to a well-defined initial value.
	 */
	private Item item1;
	private Item item2;
	private Bill hotelBill;
	private StringPrinter hotelPrinter;
	private static final double DELTA = 1e-15;
	
	/**
	 * Implementation of the Item class following the Bill interface.
	 * @author kester.meurink
	 *
	 */
	public class Item implements Bill.Item {
		
		String text;
		double amount;
		
		public Item(String text, double amount) {
			this.text = text;
			this.amount = amount;
		}
		@Override
		public double getAmount() {
			return amount;
		}
		
		@Override
		public String toString() {
			return text;
		}
		
	}
	/**
	 * Set up the variables required for testing the system.
	 */
	@BeforeEach
	void setUp() {
		hotelPrinter = new StringPrinter();
		hotelBill = new Bill(hotelPrinter);
		String text1 = "Deluxe spa";
		double amount1 = 120.50;
		item1 = new Item(text1, amount1);
		String text2 = "Breakfast";
		double amount2 = 15.00;
		item2 = new Item(text2, amount2);

	}
	
	@Test
	void testItemDescription() {
		assertEquals("Deluxe spa", item1.toString());
		assertEquals("Breakfast", item2.toString());
	}
	@Test
	void testItemAmount() {
		assertEquals(120.5, item1.getAmount(), DELTA);
		assertEquals(15.00, item2.getAmount(), DELTA);
	}
	@Test
	void testBillSystem() {
		assertEquals(0.00, hotelBill.getSum(), DELTA);
		hotelBill.addItem(item1);
		assertEquals(120.50, hotelBill.getSum(), DELTA);
		hotelBill.addItem(item2);
		assertEquals(135.50, hotelBill.getSum(), DELTA);
		System.out.println(hotelBill.getSum());
		hotelBill.close();
	}

}
