package ss.week3.pw;

/**
 * A basic checker class for testing passwords.
 * @author kester.meurink
 *
 */

public class BasicChecker implements Checker{
	public static final String INITPASS = "Hello12345";
			
	public BasicChecker() {
		
	}
	
	/**
	 * @param pass - password that needs to be checked
	 * @return True if password is acceptable
	 */
	//@ requires pass != null;
	//@ ensures \result == true || \result == false;
	public boolean acceptable(String pass) {
		return Checker.super.acceptable(pass);
	}
	
	/**
	 * Method to generate a new password.
	 * @return the generated password
	 */
	//@ ensures acceptable(generatePassword()) == true;
	@Override
	public String generatePassword() {
		return INITPASS;
	}
	

	public static void main(String[] args) {

		BasicChecker checker = new BasicChecker();

		System.out.println(checker.generatePassword());
		System.out.println(checker.acceptable(checker.generatePassword()));
	}
	
	
}
