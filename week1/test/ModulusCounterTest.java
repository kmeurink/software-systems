package ss.week1.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ss.week1.ModulusCounter;
import ss.week1.Password;

public class ModulusCounterTest {
	/** Test variables for a ModulusCounter object. */
	private ModulusCounter modulo1;
	private ModulusCounter modulo5;
	private ModulusCounter modulo10;
	
	@Before
	public void setUp() {
		modulo1 = new ModulusCounter(1);
		modulo5 = new ModulusCounter(5);
		modulo10 = new ModulusCounter(10);
	}
	
	/**
	 * Test the method mod.
	 */
    @Test
	public void testmod() {
    	modulo1.mod(1);
    	assertEquals(0,modulo1.answer());
    	modulo1.mod(10);
    	assertEquals(0,modulo1.answer());
    	modulo1.mod(25);
    	assertEquals(0,modulo1.answer());
    	modulo5.mod(5);
    	assertEquals(0,modulo5.answer());
    	modulo5.mod(7);
    	assertEquals(2,modulo5.answer());
    	modulo5.mod(29);
    	assertEquals(4,modulo5.answer());
    	modulo10.mod(10);
    	assertEquals(0,modulo10.answer());
    	modulo10.mod(100);
    	assertEquals(0,modulo10.answer());
    	modulo10.mod(95);
    	assertEquals(5,modulo10.answer());
    }
	
	
	
	}
