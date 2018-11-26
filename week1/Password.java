package ss.week1;
/**
 * Representation of a password. Lab exercise Software systems
 * @author kester.meurink
 *
 */
public class Password {
	public static final java.lang.String INITIAL = "banana";
	private java.lang.String pass;
	//Constructor:
	/**
	 * Constructs a Password with the initial word provided in INITIAL.
	 */
	public Password() {
		pass = INITIAL;
	}
	
	//Queries:
	/**
	 * Test if a given string is an acceptable password. 
	 * Not acceptable: A word with less than 6 characters 
	 * or a word that contains a space.
	 * @param suggestion - Word that should be tested
	 * @return true If suggestion is acceptable
	 */
	public boolean acceptable(java.lang.String suggestion) {
		if (suggestion.length() < 6 || suggestion.contains(" ")) {
			return false;
		} else {
			return true;
		}
	}
	
	//Commands:
	/**
	 * Tests if a given word is equal to the current password.
	 * @param test - Word that should be tested
	 * @return true If test is equal to the current password
	 */
	public boolean testWord(java.lang.String test) {
		return test.equals(pass);
		
	}
	/**
	 * Changes this password.
	 * @param oldpass The current password
	 * @param newpass The new password
	 * @return true if old is equal to thecurrent password
	 *  and that newpass is an acceptable password
	 */
	public boolean setWord(java.lang.String oldpass,
            java.lang.String newpass) {
		if (testWord(oldpass)) {
			if (acceptable(newpass)) {
				pass = newpass;
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}		
	}

	
	
}
