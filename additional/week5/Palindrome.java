package ss.additional.week5;

//Exercise 19.6
public class Palindrome {
	
	public static void main(String[] args) {
		Palindrome test = new Palindrome();
		System.out.println("Noon is a palindrome");
		System.out.println("This is : " + test.palindrome("noon"));
		System.out.println("Banana is not a palindrome");
		System.out.println("Palindrome test is : " + test.palindrome("banana"));
		System.out.println("redivider is a palindrome");
		System.out.println("Palindrome test is : " + test.palindrome("redivider"));
		System.out.println("redividers is not a palindrome");
		System.out.println("Palindrome test is : " + test.palindrome("redividers"));
	}
	
	//Named constants:
	
	
	//Constructors:
	public Palindrome() {
		
	}
	
	
	//Queries:
	public boolean palindrome(String name) {
		int wordLength = name.length();
		boolean palindromCheck = false;
		if (name.length() > 1) {
			if (name.charAt(0) == name.charAt(wordLength - 1)) {
				palindrome(name.substring(1, name.length() - 1));
				palindromCheck = true;//return true;return name.charAt(0) == name.charAt(wordLength - 1) 
			}
				//	&& palindrome(name.substring(1, name.length() - 1)); 	
		} else {
			palindromCheck = true;
		}
		return palindromCheck;
	}
	
	//Commands:
	
	
	
}
