package ss.additional.week3;

/**
 * Class representing a wizard.
 * @author kester.meurink
 *
 */
public class Wizard extends Explorer {
	//Named constants:
	
	
	//Constructors:
	public Wizard(Room start) {
		super(start);
	}
	
	//Queries:
	
	
	//Commands:
	public void moveTo(Room r) {
		if (r instanceof EnchantedRoom) {
			super.setLocation(r);
		} else {
			super.moveTo(r);
		}
	}
}
