package ss.additional.week2;

public class Player {
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public String name() {
		return this.name;
	}
	
	public int numberTaken() {
		return 0;
	}
	
	public void takeTurn(Pile pile, int maxOnATurn) {
		int sticksLeft = pile.size();
		
	}
	
}
