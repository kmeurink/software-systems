package ss.week1;
/**
 * 
 * @author kester.meurink
 * Models a three way lamp
 */
public class ThreeWayLamp {
	
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
	public ThreeWayLamp() {
		setting = OFF;
	}
	
	//Queries:
	
	/**
	 * The current setting.
	 * Returns Three_way_lamp.OFF, Three_way_lamp.LOW, Three_way_lamp.MEDIUM or Three_way_lamp.HIGH
	 */
	public int setting() {
		return setting;
	}
	//Commands:
	/**
	 * Change to next setting.
	 */
	public void changeSetting() {
		setting = (setting + 1) % 4;
	}
	
}
