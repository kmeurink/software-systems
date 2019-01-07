package ss.additional.week3;

/**
 * Class simulating an explorer in a maze.
 * @author kester.meurink
 *
 */
public class Explorer {
	
	//Named constants:
	private Room currentLocation;
	
	//Constructors:
	public Explorer(Room start) {
		this.currentLocation = start;
	}
	
	//Queries:
	/**
	 * Returns the room the explorer is currently in.
	 * @return the room the explorer is in.
	 */
	public Room location() {
		return this.currentLocation;
	}
	
	//Commands:
	/**
	 * Commands the explorer to move to a new room.
	 * @param newLocation - the room the explorer moves to.
	 */
	public void moveTo(Room newLocation) {
		if (currentLocation.connectedTo(newLocation)) {
			this.currentLocation = newLocation;
		}
	}
	
	/**
	 * Command to set the location of the explorer, should only be used for special subtypes.
	 * @param location - the location the explorer moves to.
	 */
	protected void setLocation(Room location) {
		this.currentLocation = location;
	}
	

}
