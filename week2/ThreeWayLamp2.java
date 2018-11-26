package ss.week2;
/**
 * 
 * @author kester.meurink
 * Models a three way lamp
 */
public class ThreeWayLamp2 {
	/*@ invariant setting() == Light.OFF || setting() == Light.LOW ||
	  setting() == Light.MEDIUM || setting() == Light.HIGH;
	 */
	
	//Named constants:
	/**
	 * The setting is OFF, LOW, MEDIUM or HIGH.
	 */
	public enum Light {OFF, LOW, MEDIUM, HIGH}
	
	// Private components
	private Light setting; //current setting
	//Constructor:
	/**
	 * Create a new three_way_lamp, initially OFF.
	 */
	//@ ensures setting() == Light.OFF;
	public ThreeWayLamp2() {
		setting = Light.OFF;
	}
	
	//Queries:
	
	/**
	 * The current setting.
	 * Returns Three_way_lamp.OFF, Three_way_lamp.LOW, Three_way_lamp.MEDIUM or Three_way_lamp.HIGH
	 */
	/*@ pure */public Light setting() {
		return setting;
	}
	//Commands:
	/**
	 * Change to next setting.
	 */

	//@ ensures \old(setting()) == Light.OFF ==> setting() == Light.LOW;
	//@ ensures \old(setting()) == Light.LOW ==> setting() == Light.MEDIUM;
	//@ ensures \old(setting()) == Light.MEDIUM ==> setting() == Light.HIGH;
	//@ ensures \old(setting()) == Light.HIGH ==> setting() == Light.OFF;
	public void changeSetting() {
		switch (setting) {
			case OFF:
				setting = Light.LOW;
				break;
			case LOW:
				setting = Light.MEDIUM;
				break;
			case MEDIUM:	
				setting = Light.HIGH;
				break;
			case HIGH:	
				setting = Light.OFF;
				break;
		}
	}
	
}
