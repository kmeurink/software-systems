package ss.week1;

/**
 * A tester for the class ThreeWayLamp.
 * @author kester.meurink
 *
 */
public class ThreeWayLampTest {
	private ThreeWayLamp signal; //The object to test
	
	/**
	 * Create a ThreeWayLamptest.
	 */
	public ThreeWayLampTest() {
		//Create a signal to test:
		signal = new ThreeWayLamp();
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
