package ss.week3.pw;

import java.lang.Character;

public class StrongChecker implements Checker{
	public static final String INITPASS = "Hello12345";
	
	public StrongChecker() {
		
	}
	
	/**
	 * @param pass - password that needs to be checked
	 * @return True if password is acceptable
	 */
	//@ requires pass != null;
	//@ ensures \result == true || \result == false;
	public boolean acceptable(String pass) {
		return(Checker.super.acceptable(pass) && Character.isLetter(pass.charAt(0)) && Character.isDigit(pass.charAt(pass.length()-1)));
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

		StrongChecker checker = new StrongChecker();

		System.out.println(checker.generatePassword());
		System.out.println(checker.acceptable(checker.generatePassword()));
	}
	
	
}
