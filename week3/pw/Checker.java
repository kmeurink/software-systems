package ss.week3.pw;

public interface Checker {
	
	/**
	 * @param pass - password that needs to be checked
	 * @return True if password is acceptable
	 */
	//@ requires pass != null;
	//@ ensures \result == true || \result == false;
	default
		public boolean acceptable(String pass) {
		if (pass.length() < 6 || pass.contains(" ")) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Method to generate a new password.
	 * @return the generated password
	 */
	//@ ensures acceptable(generatePassword()) == true;
	public String generatePassword();
	
	
}
