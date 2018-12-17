package ss.week6;
import java.util.Scanner;
/**
 * Variant of Hello World! asking for the name of the user.
 * @author kester.meurink
 *
 */
public class Hello {
	Scanner in = new Scanner(System.in);
	
	public Hello() {
		System.out.print("What is your name? ");
		String name = in.next();
		System.out.print("Hello " + name);
		System.out.flush();

	}

	
	public static void main(String[] args) {

		new Hello();
	}

}
