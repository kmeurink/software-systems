package ss.week2.hotel;
/**
 * Hotel with 2 rooms that guest can check in to using their name.
 * @author kester.meurink
 *
 */
public class Hotel {
	private Guest hotelGuest;
	private Room room101;
	private Room room102;
	private String hotelName;
	private Password hotelPass;
	//Constructors:
	/**
	 * Creates a <code>Hotel</code> with two rooms.
	 */
	public Hotel(String name) {
		this.hotelName = name;
		room101 = new Room(101);
		room102 = new Room(102);
		hotelPass = new Password();
	}
	
	//Queries:
	/**
	 * Return the name of the hotel.
	 */
	public String getName() {
		return this.hotelName;
	}
	
	/**
	 * Returns a <code>Room</code> if there are empty rooms available, 
	 * otherwise it returns <code> null</code>.
	 * @return Room || null;
	 */
	/*@ pure */public Room getFreeRoom() {
		if (room101.getGuest() == null) {
			return room101;
		} else if (room102.getGuest() == null) {
			return room102;
		} else {
			return null;
		}
	}
	
	/**
	 * Returns the <code>Room</code> where the guest with the given name is checked in, 
	 * or <code>null</code> if there is no such room.
	 * @param name - Name of the guest in the room.
	 * @return Room if there is one associated with the guest, otherwise null;
	 */
	/*@ pure */public Room getRoom(String name) {
		if (room101.getGuest() != null && room101.getGuest().getName().equals(name)) {
			return room101;
		} else if (room102.getGuest() != null && room102.getGuest().getName().equals(name)) {
			return room102;
		} else {
			return null;	
		}
	}
	
	/**
	 * Returns the <code>Password</code> used by the hotel.
	 * @return Password of the hotel.
	 */
	/*@ pure */public Password getPassword() {
		return hotelPass;
	}
	

	//Commands:
	/**
	 * The guest is checked into the room; if the password is correct,
	 * there is not already a guest with the same name and there are rooms available.
	 * @param password - The password for checking into the room.
	 * @param name - The name of the guest.
	 */
	//@ requires getPassword().equals(password);
	//@ ensures getRoom(name).getGuest().getName() == name || getRoom(name) == null; 
	public Room checkIn(String password, String name) {
		if (hotelPass.testWord(password) && (getFreeRoom() != null)) {
			if (room101.getGuest() == null || !room101.getGuest().getName().equals(name) 
					&& room102.getGuest() == null || !room102.getGuest().getName().equals(name)) {
				hotelGuest = new Guest(name);
				hotelGuest.checkin(getFreeRoom());
				return hotelGuest.getRoom();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	/**
	 * What is happening here? It fails to run, no matter the implementation.
	 * And if activate is included it also fails to run.
	 * The guest is checked out and the safe in the room is deactivated.
	 * If there is no guest, nothing happens.
	 * @param name - Name of the guest checking out.
	 */
	//@ ensures getRoom(name) == null;
	//@ ensures getRoom(name).getSafe().isActive() == false;
	public void checkOut(String name) {
		if(room101.getGuest() != null && room101.getGuest().getName().equals(name)) {
			room101.getGuest().checkout();
			room101.getSafe().deactivate();
		}
		else if(room102.getGuest() != null && room102.getGuest().getName().equals(name)) {
			room102.getGuest().checkout();
			room102.getSafe().deactivate();
		}
	}
	


/**
 * Returns a textual description of all the rooms,
 *  with the guests in them and the status of the lock.
 */
	public String toString() {

		String read = ""; 
		if (room101.getGuest() != null) {
			read += " Guest in Room1: " + room101.getGuest().getName()
					+ " Safe: " + (room101.getSafe().isActive() ? "active" : "inactive");
		} 
		if (room102.getGuest() != null) {
			read += " Guest in Room2: " + room102.getGuest().getName()
					+ " Safe: " + (room102.getSafe().isActive() ? "active" : "inactive");
		}

		System.out.print(read);

		System.out.flush();		
		return read;
	}
}