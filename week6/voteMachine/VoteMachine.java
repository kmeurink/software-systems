package ss.week6.voteMachine;

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
	
	
	//Commands:
	
	/**
	 * Method to start the machine.
	 */
	public void start() {
		
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
