package ss.additional.week3;

/**
 * Class simulating rooms in a maze.
 * @author kester.meurink
 *
 */
public class Room {
	//Named constants:
	private String description;
	private Room connection1;
	private Room connection2;
	
	//Constructors:
	public Room(String description) {
		this.description = description;
		this.connection1 = null;
		this.connection2 = null;
	}
	
	
	//Queries:
	/**
	 * Shows if this room is connected to the specified room.
	 * @param r - the room that this room might be connected to.
	 * @return true if the room is connected to room r.
	 */
	public boolean connectedTo(Room r) {
		return r.equals(connection1) || r.equals(connection2);
	}
	
	/**
	 * returns the description of the room.
	 * @return the description of the room
	 */
	public String description() {
		return this.description;
	}
	
	//Commands:
	/**
	 * method to connect the room to other rooms in the maze.
	 * Should only be used when maze is constructed.
	 */
	public void connect(Room room1, Room room2) {
		this.connection1 = room1;
		this.connection2 = room2;
		
	}
	

}
