package ss.week2;

public class Rectangle {
    private int length;
    private int width;
    //@ private invariant length >= 0;
    //@ private invariant width >= 0;
    /**
     * Create a new Rectangle with the specified length and width.
     */
    //@ requires length > 0 && width > 0;
    public Rectangle(int length, int width) {
    	assert length >= 0 && width >= 0; //Assume length and width must be positive.
    	this.length = length;
    	this.width = width;
    }
    
    /**
     * The length of this Rectangle.
     */
    //always return a positive value
    //@ ensures \result >=0;
    /*@ pure */public int length() {
    	assert length >= 0;
    	return length;
    }

    /**
     * The width of this Rectangle.
     */
    //@ ensures \result >=0;
    //always return a positive value
    /*@ pure */public int width() {
    	assert width >= 0;
    	return width;
    }

    /**
     * The area of this Rectangle.
     */
    //@ ensures \result == length() * width();
    //always return a positive value
    public int area() {
    	assert length >= 0 && width >= 0;
    	return length * width;
    }

    /**
     * The perimeter of this Rectangle.
     */
    //@ ensures \result == (2 * length()) + (2 * width());
    //always return a positive value	
    public int perimeter() {
    	assert length >= 0 && width >= 0;
    	return (2 * length) + (2 * width);
    }
}
