package ss.week6.voteMachine;

import java.util.List;
import java.util.Map;

/**
 * Controller class for the voting machine.
 * @author kester.meurink
 *
 */
public class VoteMachine {
	
	//Main
	public static void main(String[] args) {
		VoteMachine voter = new VoteMachine();
		voter.start();
	}
	//Named Constants:
	PartyList partyList;
	VoteList voteList;
	
	
	//Constructor:
	public VoteMachine() {
		partyList = new PartyList();
		voteList = new VoteList();
	}
	
	//Queries:
	
	/**
	 * Method to retrieve the party list to the machine.
	 * @return the list of parties.
	 */
	public List<String> getParties() {
		return partyList.getParties();
	}
	
	/**
	 * Method to retrieve the vote list to the machine.
	 * @return the map with all votes.
	 */
	public Map<String, Integer> getVotes() {
		return voteList.getVotes();
	}
	
	//Commands:
	
	/**
	 * Method to start the machine, also starting its TUI/GUI.
	 */
	public void start() {
		VoteTUIView view = new VoteTUIView(this);
		view.start();
		
	}
	
	/**
	 * Method for adding a party to the voting machine.
	 * @param party - the party that is added to the machine.
	 */
	public void addParty(String party) {
		partyList.addParty(party);
	}
	
	
	/**
	 * Method for voting for a party to the voting machine.
	 * @param party - the party for which the vote is cast.
	 */
	public void vote(String party) {
		voteList.addVote(party);
	}

}
