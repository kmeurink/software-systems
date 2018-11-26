package ss.week2;
/**
 * 
 * @author kester.meurink
 * Models a three way lamp
 */
public class ThreeWayLamp {
	/*@ invariant setting() == OFF || setting() == LOW ||
	  setting() == MEDIUM || setting() == HIGH;
	 */
	
	//Named constants:
	/**
	 * The setting OFF.
	 */
	public static final int OFF = 0;
	/**
	 * The setting LOW.
	 */
	public static final int LOW = 1;
	/**
	 * The setting MEDIUM.
	 */
	public static final int MEDIUM = 2;
	/**
	 * The setting HIGH.
	 */
	public static final int HIGH = 3;
	
	// Private components
	private int setting; //current setting
	//Constructor:
	/**
	 * Create a new three_way_lamp, initially OFF.
	 */
	//@ ensures setting() == OFF;
	public ThreeWayLamp() {
		setting = OFF;
	}
	
	//Queries:
	
	/**
	 * The current setting.
	 * Returns Three_way_lamp.OFF, Three_way_lamp.LOW, Three_way_lamp.MEDIUM or Three_way_lamp.HIGH
	 */
	/*@ pure */public int setting() {
		return setting;
	}
	//Commands:
	/**
	 * Change to next setting.
	 */
	//@ requires OFF == 0;
	//@ requires LOW == 1;
	//@ requires MEDIUM == 2;
	//@ requires HIGH == 3;
	//@ ensures \old(setting()) == OFF ==> setting() == LOW;
	//@ ensures \old(setting()) == LOW ==> setting() == MEDIUM;
	//@ ensures \old(setting()) == MEDIUM ==> setting() == HIGH;
	//@ ensures \old(setting()) == HIGH ==> setting() == OFF;
	public void changeSetting() {
		assert OFF == 0;
		assert LOW == 1;
		assert MEDIUM == 2;
		assert HIGH == 3;
		
		setting = (setting + 1) % 4;
	}
	
}
