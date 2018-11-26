package ss.week2.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.week2.hotel.Safe;

class SafeTest {
	//Create two safe objects.
	private Safe safeinit;
	private Safe safeActive;
	private Safe safeOpen;

	
	/**
	 * Sets initial variables to a well-defined initial value.
	 * Assigns a <tt>Safe</tt> object to the <tt>safe1</tt> instance variable with the
	 * password {@code "123456"} and assigns a <tt>Safe</tt> object to the <tt>safe2</tt>
	 * instance variable with the password {@code "654321"}.
	 */
	@BeforeEach
	void setUp() {
		//Initialisation of the safe-variables
		safeinit = new Safe("123456");
		safeActive = new Safe("123456");
		safeActive.activate("123456");
		safeOpen = new Safe("123456");
		safeOpen.activate("123456");
		safeOpen.open("123456");
	}
	/**
	 * Test if the initial conditions comply to specifications.
	 */
	@Test
	void testInitialcondition() {
		assertFalse(safeinit.isActive());
		assertFalse(safeinit.isOpen());
		//also test that the setUp is handled correctly.(not fully allowed).
		assertTrue(safeActive.isActive());
		assertFalse(safeActive.isOpen());
		assertTrue(safeOpen.isActive());
		assertTrue(safeOpen.isOpen());
	}
	/**
	 * Test activating a safe, using a correct password.
	 */
	@Test
	void testActivateCorrect() {
		safeinit.activate("123456");
		assertTrue(safeinit.isActive());
		safeinit.activate("123456");
		assertTrue(safeinit.isActive());
	}
	/**
	 * Test activating a safe, using a Wrong password.
	 */
	@Test
	void testActivateWrong() {
		safeinit.activate("654321");
		assertFalse(safeinit.isActive());
		safeActive.activate("654321");
		assertTrue(safeActive.isActive());
	}

	/**
	 * Test opening a safe, using a wrong password.
	 */
	@Test
	void testOpenWrong() {
		safeActive.open("654321");
		assertFalse(safeActive.isOpen());
		safeOpen.open("654321");
		assertTrue(safeOpen.isOpen());
		safeinit.open("654321");
		assertFalse(safeinit.isOpen());
	}
	/**
	 * Test opening a safe, using a correct password.
	 */
	@Test
	void testOpenCorrect() {
		safeActive.open("123456");
		assertTrue(safeActive.isOpen());
		safeOpen.open("123456");
		assertTrue(safeOpen.isOpen());
		safeinit.open("123456");
		assertFalse(safeinit.isOpen());
	}
	/**
	 * Test closing a safe.
	 */
	@Test
	void testClose() {
		safeActive.close();
		assertFalse(safeActive.isOpen());
		assertTrue(safeActive.isActive());
		safeOpen.close();
		assertFalse(safeOpen.isOpen());
		assertTrue(safeOpen.isActive());
		safeinit.close();
		assertFalse(safeinit.isOpen());
		assertFalse(safeinit.isActive());
	}
	
	/**
	 * Test deactivating a safe.
	 */
	@Test
	void testDeactive() {
		safeOpen.deactivate();
		assertFalse(safeOpen.isOpen());
		assertFalse(safeOpen.isActive());
		safeActive.deactivate();
		assertFalse(safeActive.isOpen());
		assertFalse(safeActive.isActive());
		safeinit.deactivate();
		assertFalse(safeinit.isOpen());
		assertFalse(safeinit.isActive());
		
	}
}
