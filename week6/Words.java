package ss.week6;

import java.util.Scanner;

/**
 * Class that asks for a sentence and splits the words.
 * Printing them one by one.
 * @author kester.meurink
 *
 */
public class Words {
	Scanner in = new Scanner(System.in);
	boolean end = false;
	String name;
	
	public Words() {
		System.out.println("Please provide a sentence? ");
		while (!end) {
			name = in.next();
			System.out.print(name + "\n");
			if (name.equals("end")) {
				end = true;
			}
		}
	}
	
	
	
	
	
	public static void main(String[] args) {

		new Words();
	}
}
