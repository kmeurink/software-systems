package ss.week6;
import java.util.Scanner;
/**
 * Variant of Hello World! asking for the name of the user.
 * @author kester.meurink
 *
 */
public class Hello {
	Scanner in = new Scanner(System.in);
	boolean end = false;
	
	public Hello() {
		//Usage of a boolean to determine if it still needs to check.
		while (!end) {
			System.out.println("What is your name? ");
			String name = in.nextLine();
			if (name.isEmpty()) {
				end = true;
			} else {
				System.out.println("Hello " + name + " ");
			}
		}
	}

	
	public static void main(String[] args) {

		new Hello();
	}

}
