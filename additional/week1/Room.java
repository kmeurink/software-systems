package ss.additional.week1;
//Exercise 3.4 and 3.6 Nino and Hosch


/**
 * Represents a room in a maze.
 * @author kester.meurink
 *
 */
public class Room {
	private String description;
	public boolean occupied;
	
	//Constructors:
	/**
	 * Initialises a room in the maze with a description.
	 * The room is initially unoccupied.
	 */
	public Room(String desc) {
		this.description = desc;
		this.occupied = false;
	}
	
	
	//Queries:
	/**
	 * returns the description of the room.
	 * @return
	 */
	public String description() {
		return this.description;
	}
	
	public String toString() {
		return "Room: " + description();
	}
	/**
	 * Is the room occupied.
	 * @return true if there is an explorer in the room.
	 */
	public boolean occupied() {
		return this.occupied;
	}
	
	//Commands:
	/**
	 * An explorer has entered the room.
	 */
	public void enter() {
		this.occupied = true;
	}
	/**
	 * An explorer has left the room.
	 */
	public void exit() {
		this.occupied = false;
	}
	
}
