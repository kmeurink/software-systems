package ss.additional.week1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class IntLocationTest {
	/** Test variables for a ModulusCounter object. */
	private IntLocation test;
	
	@Before
	public void setUp() {
		test = new IntLocation();
	}
	
	/**
	 * Test the method mod.
	 */
    @Test
	public void testloc() {
    	test.assignment(0);
    	System.out.println("tens are: " + test.tens() + " ones are: " + test.ones());
    	test.assignment(5);
    	System.out.println("tens are: " + test.tens() + " ones are: " + test.ones());
    	test.assignment(20);
    	System.out.println("tens are: " + test.tens() + " ones are: " + test.ones());
    	test.assignment(51);
    	System.out.println("tens are: " + test.tens() + " ones are: " + test.ones());
    	test.assignment(99);
    	System.out.println("tens are: " + test.tens() + " ones are: " + test.ones());

    }
	
	
	
	}
