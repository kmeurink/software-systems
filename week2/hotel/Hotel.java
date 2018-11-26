package ss.week2.hotel;
/**
 * Hotel with 2 rooms that guest can check in to using their name.
 * @author kester.meurink
 *
 */
public class Hotel {
	private int number;
	private Guest hotelGuest;
	private Safe hotelSafe1;
	private Safe hotelSafe2;
	private Room room101;
	private Room room102;
	private String hotelName;
	private Password hotelPass;
	private Guest guest1;	
	//Constructors:
	/**
	 * Creates a <code>Hotel</code> with two rooms.
	 */
	public Hotel(String name) {
		this.hotelName = name;
		room101 = new Room(101);
		room102 = new Room(102);
		hotelSafe1 = new Safe("123456");
		hotelSafe2 = new Safe("123456");
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
		if (room101.getGuest().getName().equals(name)) {
			return room101;
		} else if (room102.getGuest().getName().equals(name)) {
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
				guest1 = new Guest(name);
				guest1.checkin(getFreeRoom());
				return guest1.getRoom();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	/**
	 * The guest is checked out and the safe in the room is deactivated.
	 * If there is no guest, nothing happens.
	 * @param name - Name of the guest checking out.
	 */
	//@ ensures getRoom(name) == null;
	//@ ensures getRoom(name).getSafe().isActive() == false;
	public void checkOut(String name) {
		if (this.getRoom(name) != null) {
			this.getRoom(name).getSafe().deactivate();
			this.getRoom(name).getGuest().checkout();			
		}
	}


/**
 * Returns a textual description of all the rooms,
 *  with the guests in them and the status of the lock.
 */
	public String toString() {

		String a = "Name: " + this.getName() + "\r"; 

		if (room101.getGuest() != null && room102.getGuest() != null) {

			String b =	"Guests of Room1: " + room101.getGuest().getName() + "\r";

			String c =	"Status of safe: " + room101.getSafe().isActive() + "\r";

			String d =	"Guests of Room2: " + room102.getGuest().getName() + "\r";

			String e =	"Status of safe: " + room102.getSafe().isActive() + "\r";

			return a + b + c + d + e;

		} else if (room101.getGuest() != null || room102.getGuest() != null) {

			if (room101.getGuest() != null) {

				String b =	"Guests of Room1: " + room101.getGuest().getName() + "\r";

				String c =	"Status of safe: " + room101.getSafe().isActive() + "\r";

				return a + b + c;

			} else {
				String d =	"Guests of Room2: " + room102.getGuest().getName() + "\r";

				String e =	"Status of safe: " + room102.getSafe().isActive() + "\r";

				return a + d + e;	
			}
		}

		return a;

	}
}