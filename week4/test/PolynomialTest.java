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
    	polynomial1 = new Polynomial(new double[]{1.0, -4.0, 7.0});
    	polynomial2 = new Polynomial(new double[]{1.0, 2.0, -1.0, 1.0});
    	polynomial3 = new Polynomial(new double[]{4.0, 2.0, -2.0, 2.0, 9.0});
    }	

    //Testing the polynomial apply command.
    @Test
    public void testApply1() {
		System.out.println("Start polynomial test1: ");
        assertEquals(4, polynomial1.apply(1), DELTA);
        assertEquals(3, polynomial2.apply(1), DELTA);
        assertEquals(15, polynomial3.apply(1), DELTA);
		System.out.println("End test.");

    }
    /*
     * Is a bit of an excessive test, but allows for testing of the influence of the x argument.
     */
    @Test
    public void testApply2() {
		System.out.println("Start polynomial test2: ");
        assertEquals(3, polynomial1.apply(2), DELTA);
        assertEquals(15, polynomial2.apply(2), DELTA);
        assertEquals(85, polynomial3.apply(2), DELTA);
		System.out.println("End test.");
    }
    
    //Testing the polynomial derivative command.
    @Test
    public void testApplyDer1() {
    	System.out.println("Start derivative test1: ");
    	Integrable polyDer1 = polynomial1.derivative();
    	Integrable polyDer2 = polynomial2.derivative();
    	Integrable polyDer3 = polynomial3.derivative();
   	
        assertEquals(-2, polyDer1.apply(1), DELTA);
        assertEquals(6, polyDer2.apply(1), DELTA);
        assertEquals(20, polyDer3.apply(1), DELTA);
        System.out.println("End test.");
    }
    /*
     * Again a bit of an excessive test, but allows for testing of the influence of the x argument.
     */
    @Test
    public void testApplyDer2() {
    	System.out.println("Start derivative test2: ");
    	Integrable polyDer1 = polynomial1.derivative();
    	Integrable polyDer2 = polynomial2.derivative();
    	Integrable polyDer3 = polynomial3.derivative();
    	
        assertEquals(0, polyDer1.apply(2), DELTA);
        assertEquals(19, polyDer2.apply(2), DELTA);
        assertEquals(146, polyDer3.apply(2), DELTA);
        System.out.println("End test.");
    }

    //Testing the polynomial integral command.
    @Test
    public void testApplyInt1() {
    	System.out.println("Start integral test1: ");
    	Integrable polyInt1 = polynomial1.integral();
    	Integrable polyInt2 = polynomial2.integral();
    	Integrable polyInt3 = polynomial3.integral();
    	
    	double answer1 = ((1.0 / 3.0) - 2.0 + 7.0);
    	double answer2 = ((1.0 / 4.0) + (2.0 / 3.0) - (1.0 / 2.0) + 1.0);
    	double answer3 = ((4.0 / 5.0) + (2.0 / 4.0) - (2.0 / 3.0) + 1.0 + 9.0);
    	
        assertEquals(answer1, polyInt1.apply(1), DELTA);
        assertEquals(answer2, polyInt2.apply(1), DELTA);
        assertEquals(answer3, polyInt3.apply(1), DELTA);
        System.out.println("End test.");
    }
    /*
     * Again a bit of an excessive test, but allows for testing of the influence of the x argument.
     */
    @Test
    public void testApplyInt2() {
    	System.out.println("Start integral test2: ");
    	Integrable polyInt1 = polynomial1.integral();
    	Integrable polyInt2 = polynomial2.integral();
    	Integrable polyInt3 = polynomial3.integral();
    	
    	double answer1 = ((8.0 / 3.0) - 8.0 + 14.0);
    	double answer2 = ((16.0 / 4.0) + (16.0 / 3.0) - (4.0 / 2.0) + 2.0);
    	double answer3 = ((128.0 / 5.0) + (32.0 / 4.0) - (16.0 / 3.0) + (8.0 / 2.0) + 18.0);
    	
        assertEquals(answer1, polyInt1.apply(2), DELTA);
        assertEquals(answer2, polyInt2.apply(2), DELTA);
        assertEquals(answer3, polyInt3.apply(2), DELTA);
        System.out.println("End test.");
    }
}
