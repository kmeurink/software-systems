package ss.week2.test;

import ss.week2.ThreeWayLamp2;

/**
 * A tester for the class ThreeWayLamp.
 * @author kester.meurink
 *
 */
public class ThreeWayLampTest {
	private ThreeWayLamp2 signal; //The object to test
	
	/**
	 * Create a ThreeWayLamptest.
	 */
	public ThreeWayLampTest() {
		//Create a signal to test:
		signal = new ThreeWayLamp2();
	}
	
	/**
	 * Run the test.
	 */
	public void runTest() {
		testInitialState();
		testChange();
	}
	
	/**
	 * Test the ThreeWayLamp initial state.
	 */
	private void testInitialState() {
		System.out.println("testinitialstate: ");
		System.out.println("Initial light: " + signal.setting());
	}
	
	/**
	 * Test the method changeSetting.
	 */
	private void testChange() {
		System.out.println("testChange:");
		System.out.println("Starting setting: " + signal.setting());
		signal.changeSetting();
		System.out.println("After 1 change: " + signal.setting());
		signal.changeSetting();
		System.out.println("After 2 changes: " + signal.setting());
		signal.changeSetting();
		System.out.println("After 3 changes: " + signal.setting());
		signal.changeSetting();
		System.out.println("After 4 changes: " + signal.setting());
	}
}
