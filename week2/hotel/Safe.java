package ss.week2.hotel;
/**
 * Representing a safe in a hotel, which can be opened with a password.
 * @author kester.meurink
 *
 */
public class Safe {
	private Password currentpassword;
	private boolean active;
	private boolean open;
	
	//@ invariant isActive() == true || isActive() == false;
	//@ invariant isOpen() == true || isOpen() == false;
	
	//public static void main (String[] args) {

	//	Safe safe  = new Safe("12356");

	//}
	
	//Constructor:
	/**
	 * Constructs a safe, initializing a Password object to store a password for the safe.
	 * The safe start closed and inactive. 
	 */
	//@ requires Password.acceptable(password);
	//@ ensures isActive () == false;
	//@ ensures isOpen() == false;
	public Safe(String password) {
		assert Password.acceptable(password);
		this.currentpassword = new Password();
		this.currentpassword.setWord(Password.INITIAL, password);
		this.active = false;
		this.open = false;		
	}
	
	//Queries:
	/**
	 * Shows if the safe is active or not.
	 * @return true If safe is active
	 */
	//@ ensures \result == true || \result == false;
	/*@ pure */public boolean isActive() {
		return this.active;
	}
	
	/**
	 * Shows if the safe is open or not.
	 * @return true If safe is open
	 */
	//@ ensures \result == true || \result == false;
	/*@ pure */public boolean isOpen() {
		return this.open;
	}
	
	/**
	 * Retrieves the Password object.
	 */
	/*@ pure */public Password getPassword() {
		return this.currentpassword;
	}
	
	//Commands:
	/**
	 * Activates the safe if the password is correct.
	 * @param password - password that should be tested
	 */
	//@ requires getPassword().equals(password); 
	//@ ensures isActive() == true;
	public void activate(String password) {
		if (this.currentpassword.testWord(password)) {
			this.active = true;
		}
	}
	
	/**
	 * Closes and deactivates the safe.
	 */
	//@ ensures isActive() == false;
	//@ ensures isOpen() == false;
	public void deactivate() {
		this.open = false;
		this.active = false;
	}
	
	/**
	 * Opens the safe, if the safe is active and the password is correct.
	 * @param password - password that should be tested
	 */
	//@ requires getPassword().equals(password);
	//@ requires isActive() == true;
	//@ ensures isOpen() == true;
	public void open(String password) {
		if (this.currentpassword.testWord(password) && isActive()) {
			this.open = true;
		}
	}
	
	/**
	 * Closes the safe, without changing its activity status.
	 */
	//@ ensures isOpen() == false;
	//@ ensures \old(isActive()) == isActive();
	public void close() {
		this.open = false;
	}
	
	
	
	
}
