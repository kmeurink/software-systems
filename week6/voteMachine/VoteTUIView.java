package ss.week6.voteMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Scanner;

/**
 * UI view for the voting machine system.
 * @author kester.meurink
 *
 */
public class VoteTUIView implements VoteView{
	//Named constants:
	private VoteMachine vm;
	
	//Constructor:
	public VoteTUIView(VoteMachine voteMachine) {
		 this.vm = voteMachine;
	}
	//Queries:
	
	/**
	 * Method to show information about the votes.
	 */
	@Override
	public void showVotes(Map<String, Integer> votes) {
		List<String> parties = new ArrayList<>();
		for (String v : parties) {
			System.out.println(v + " - " + votes.get(v) + "votes" + "\n");
		}
	}
	
	/**
	 * Method to show information about the parties.
	 */
	@Override
	public void showParties(List<String> parties) {
		for (int i = 0; i < parties.size(); i++) {
			System.out.println(parties.get(i) + "\n");
		}
	}
	
	/**
	 * Method to return possible errors.
	 */
	@Override
	public void showError(String message) {
		System.out.println(message);
	}
	
	//Commands:
	
	/**
	 * Method to start a loop asking for input.
	 */
	@Override
	public void start() {
		Scanner in = new Scanner(System.in);
		boolean voting = true;

		while (voting) {
			String prompt;
			System.out.println("Please choose one of the following options: ");
			System.out.println("VOTE [party], ADD PARTY [party], VOTES, PARTIES, EXIT, HELP");
            if (in.hasNextLine()) {
            	prompt = in.next();
            	switch (prompt) {
            		case "VOTE": vm.vote(in.next());
            			break;
            		case "ADD": vm.addParty(in.next());
            			break;
            		case "VOTES": this.showVotes(vm.getVotes());
            			break;
            		case "PARTIES": this.showParties(vm.getParties());
            			break;
            		case "EXIT": voting = false;
            			break;
            		case "HELP": this.showError("Error, something is malfunctioning");
            			break;
            		default:
            			System.out.println("Sorry that's not one of the options");
            	}

            }
			
		}
	}
	/**
	 * Method to update the system.
	 */
	@Override
	public void update(Observable o, Object arg) {
		
	}



}
