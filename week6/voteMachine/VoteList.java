package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class for storing all the votes made for the parties.
 * @author kester.meurink
 *
 */
public class VoteList {
	//Named constants:
	Map<String, Integer> voteMap = new HashMap<String, Integer>(); 
	
	
	//Constructor:
	public VoteList() {
		
	}
	
	
	//Queries:
	
	/**
	 * Method for returning the current voting list as a map structure.
	 * @return The current voting map.
	 */
	public Map<String, Integer> getVotes() {
		return voteMap;
	}

	
	//Commands:
	
	/**
	 * Method for adding a vote for a party.
	 * @param vote - the vote for a specific party.
	 */
	public void addVote(String vote) {
		if (voteMap.containsKey(vote)) {
			voteMap.replace(vote, voteMap.get(vote), voteMap.get(vote) + 1);
		} else {
			voteMap.put(vote, 1);
		}
	}

}
