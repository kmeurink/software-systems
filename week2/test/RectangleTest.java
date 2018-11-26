package ss.week2.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


import ss.week2.Rectangle;

/**
 * Test program for Rectangle.
 * @author Kester Meurink
 */
public class RectangleTest {
	/** Test variable for a <tt>Rectangle</tt>-object. */
    private Rectangle rectangle00;
	/** Test variable for a <tt>Rectangle</tt>-object. */
    private Rectangle rectangle01;
	/** Test variable for a <tt>Rectangle</tt>-object. */
    private Rectangle rectangle10;
	/** Test variable for a <tt>Rectangle</tt>-object. */
    private Rectangle rectangle11;
	/** Test variable for a <tt>Rectangle</tt>-object. */
    private Rectangle rectangle12;
    
    /**
	 * Sets initial variables to a well-defined initial value.
	 * <p>
	 * Assigns a <tt>Rectangle</tt> object to the <tt>rectangle00</tt> instance variable with the
	 * arguments {@code 0,0}, assigns a <tt>Rectangle</tt> object to the <tt>rectangle01</tt>
	 * instance variable with the arguments {@code 0,10}, assigns a <tt>Rectangle</tt> object to
	 * the <tt>rectangle10</tt> instance variable with the
	 * arguments {@code 10,0} and assigns a <tt>Rectangle</tt> object to the <tt>rectangle11</tt>
	 * instance variable with the arguments {@code 10,10}
	 */
    
    @Before
    public void setUp() {
        // initialisation of Rectangle-variables
    	rectangle00 = new Rectangle(0,0);
    	rectangle01 = new Rectangle(0,10);
    	rectangle10 = new Rectangle(10,0);
    	rectangle11 = new Rectangle(10,10);
    	rectangle12 = new Rectangle(4,5);
    }
    
    /**
	 * Tests if the initial condition complies to the specification.
	 */
    @Test
    public void testInitialcondition() {
        assertEquals(0, rectangle00.length());
        assertEquals(0, rectangle00.width()); 
        assertEquals(0, rectangle01.length());
        assertEquals(10, rectangle01.width());
        assertEquals(10, rectangle10.length());
        assertEquals(0, rectangle10.width());
        assertEquals(10, rectangle11.length());
        assertEquals(10, rectangle11.width());
        assertEquals(4, rectangle12.length());
        assertEquals(5, rectangle12.width());
    }
    
    /**
     * Tests calculating area.
     */
    @Test
    public void testArea() {
        assertEquals(0, rectangle00.area());
        assertEquals(0, rectangle01.area()); 
        assertEquals(0, rectangle10.area());
        assertEquals(100, rectangle11.area());
        assertEquals(20, rectangle12.area());
    }

    /**
     * Test calculating perimeter.
     */
    @Test
    public void testPerimeter() {
        assertEquals(20, rectangle01.perimeter());
        assertEquals(20, rectangle10.perimeter()); 
        assertEquals(0, rectangle00.perimeter());
        assertEquals(40, rectangle11.perimeter());
        assertEquals(18, rectangle12.perimeter());

    }

    
}
