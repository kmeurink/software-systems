package ss.week4.test;

import org.junit.Before;
import org.junit.Test;

import ss.week3.math.Constant;
import ss.week4.Polynomial;
import ss.week3.math.Integrable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PolynomialTest {
	private Polynomial polynomial1;
	private Polynomial polynomial2;
	private Polynomial polynomial3;
    private static final double DELTA = 1e-15;

	
    @Before
    public void setUp() {
    	polynomial1 = new Polynomial(new double[]{1, -4, 7});
    	polynomial2 = new Polynomial(new double[]{1, 2, -1, 1});
    	polynomial3 = new Polynomial(new double[]{4, 2, -2, 2, 9});
    }	

    //Testing the polynomial apply command.
    @Test
    public void testApply1() {
        assertEquals(4, polynomial1.apply(1), DELTA);
        assertEquals(3, polynomial2.apply(1), DELTA);
        assertEquals(15, polynomial3.apply(1), DELTA);
    }
    /*
     * Is a bit of an excessive test, but allows for testing of the influence of the x argument.
     */
    @Test
    public void testApply2() {
        assertEquals(3, polynomial1.apply(2), DELTA);
        assertEquals(15, polynomial2.apply(2), DELTA);
        assertEquals(85, polynomial3.apply(2), DELTA);
    }
    
    //Testing the polynomial derivative command.
    @Test
    public void testApplyDer1() {
    	Integrable polyDer1 = polynomial1.derivative();
    	Integrable polyDer2 = polynomial2.derivative();
    	Integrable polyDer3 = polynomial3.derivative();
   	
        assertEquals(-2, polyDer1.apply(1), DELTA);
        assertEquals(6, polyDer2.apply(1), DELTA);
        assertEquals(20, polyDer3.apply(1), DELTA);
    }
    /*
     * Again a bit of an excessive test, but allows for testing of the influence of the x argument.
     */
    @Test
    public void testApplyDer2() {
    	Integrable polyDer1 = polynomial1.derivative();
    	Integrable polyDer2 = polynomial2.derivative();
    	Integrable polyDer3 = polynomial3.derivative();
    	
        assertEquals(0, polyDer1.apply(2), DELTA);
        assertEquals(19, polyDer2.apply(2), DELTA);
        assertEquals(146, polyDer3.apply(2), DELTA);
    }

    //Testing the polynomial integral command.
}
