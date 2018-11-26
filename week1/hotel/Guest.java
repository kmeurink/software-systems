package ss.week1.hotel;

/**
 * Model a guest in a hotel.
 * @author kester.meurink
 */
public class Guest {

	private java.lang.String name;
	private Room room = null;
	//Constructor
	/**
	 * Creates a <code>Guest</code> with given name, without a room.
	 * @param empty <code>string</code>.
	 */
	public Guest(java.lang.String name) {
		this.name = name;
	}
	
	//Queries
	/**
	 * Returns the name of this <code>Guest</code>.
	 */
	public java.lang.String getName() {
		return name; 
	}
	/**
	 * Returns the <code>Room</code> that is rented by this <code>Guest</code>.
	 * @return the <code>Room</code> this <code>Guest</code> is staying in.
	 *         <code>null</code> if this <code>Guest</code> 
     *         is not currently renting a room.
	 */
	public Room getRoom() {
		return room;
	}
	/**
	 * A string representation of this object.
	 */
	public String toString() {
		return "Guest: " + name;
	}
	
	//Commands
	/**
	 * Rents a Room to this Guest.
	 * This is only possible if this Guest does not already have a Room and 
	 * the Room to be assigned is not already rented.
	 * * Assigns a <code>Room</code> to this <code>Guest</code>.
     * @param the <code>Room</code> assigned to the <code>Guest</code>;
     * @return true if checkin succeeded;
     * false if this <code>Guest</code> already had a <code>Room</code>
     * ,or room already had a <code>Guest</code>.

	 */
	public boolean checkin(Room room) {
		if (room.getGuest() == null) {
			room.setGuest(this);
			this.room = room;
			return true;
		} else {
			return false;
		} 
	}
	/**
	 * Sets the Room of this Guest to null.
	 * Also resets the Guest-reference of the (current) Room.
	 * @return true if this action succeeded;
	 * false if <code>Guest</code> does not have a <code>Room</code> when this method is called
	 */
	public boolean checkout() {
		if (this.getRoom() == null) {
			return false;
		} else {
			room.setGuest(null);
			this.room = null;
			return true;
		}
	}
	
}
