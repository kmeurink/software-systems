package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for storing all the different electable parties.
 * @author kester.meurink
 *
 */
public class PartyList {
	//Named constants:
	private List<String> partyList = new ArrayList<>();
	
	
	//Constructor:
	public PartyList() {
		
	}
	
	
	//Queries:
	/**
	 * Method for checking if a party is in the list.
	 * @param party - the party that is being checked.
	 * @return true if party is in the list.
	 */
	public boolean hasParty(String party) {
		boolean partyPresent = false;
		for (int i = 0; i < this.partyList.size(); i++) {
			if (this.partyList.get(i).equals(party)) {
				partyPresent = true;
			}
		}
		return partyPresent;
	}
	
	/**
	 * Method for showing all the parties in the list.
	 * @return the current registered parties.
	 */
	public List<String> getParties() {
		return partyList;
	}
	
	//Commands:
	/**
	 * Method for adding a new party to the list.
	 * @param party - the party that is added.
	 */
	public void addParty(String party) {
		if (!hasParty(party)) {
			this.partyList.add(party);
		}
	}
	

}
