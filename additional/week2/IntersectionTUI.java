package ss.additional.week2;
import java.util.*;

public class IntersectionTUI {
	
	private static final int CHANGE = 1;
	private static final int EXIT = 0;
	private static final int NO_CHOICE = -1;
	private Intersection intersection;
	private Scanner in;
	
	/**
	* Create a new IntersectionTUI.
	*/
	public IntersectionTUI() {
		this.intersection = new Intersection();
		this.in = new Scanner(System.in);
	}
	/**
	* Start the user interface.
	*/
	public void start() {
		displayIntersection();
		int choice = NO_CHOICE;
		while (choice != EXIT) {
			displayMenu();
			choice = readIntWithPrompt("Enter choice: ");
			executeChoice(choice);
		}
	}
	/**
	* Display the menu.
	*/
	private void displayMenu() {
		System.out.println();
		System.out.println("Change the signals .." + CHANGE);
		System.out.println("Exit ................ " + EXIT);
	}
		/**
		* Execute choice from menu.
		*/
	private void executeChoice(int choice) {
		if (choice == EXIT) {
			System.out.println("Good -bye.");
		} else {
			if (choice == CHANGE) {
				this.intersection.change();
			} else {
				System.out.println(choice + " is not a valid choice.");
			}
			displayIntersection();
		}
	}
		/**
		* Display the current state of the intersection.
		*/
	private void displayIntersection() {
		System.out.println();
		System.out.println("The east -west signal is "
					+ lightString(this.intersection.ewLight()));
		System.out.println("The north -south signal is "
					+ lightString(this.intersection.nsLight()));
	}
		/**
		* String description of a TrafficSignal light.
		*/
	private String lightString(int light) {
		switch (light) {
			case TrafficSignal.GREEN:
				return "green";
			case TrafficSignal.YELLOW:
				return "yellow";
			case TrafficSignal.RED:
				return "red";
			default:
				return "broken";
		}
	}
		/**
		* Read and return an int in response to the specified prompt.
		*/
	private int readIntWithPrompt(String prompt) {
		System.out.print(prompt);
		System.out.flush();
		return this.in.nextInt();
	}
}
