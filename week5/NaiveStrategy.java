package ss.week5;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

/**
 * Naive strategy for playing tictactoe, by randomly selecting an empty field.
 * @author kester.meurink
 *
 */
public class NaiveStrategy implements Strategy{
	private String name;
	
	public NaiveStrategy() {
	this.name = "Naive";	
	}
	
	/**
	 * Method to return the name given to the strategy.
	 * @return the name of the strategy.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Method to determine what the next legal move is that the player can make.
	 * @param b - the board the game is played on.
	 * @param m - the mark assigned to the player.
	 * @return
	 */
	//@ requires b instanceof Board;
	//@ requires m instanceof Mark;
	@Override
	public int determineMove(Board b, Mark m) {
		Mark[] fieldChoice = new Mark[9];
		for (int i = 0; i < 9; i++) {
			if (b.isEmptyField(i)) {
				fieldChoice[i] = Mark.EMPTY;
			}
		}
		int randomChoice = (int) Math.floor(Math.random() * 9);
		while (fieldChoice[randomChoice] != Mark.EMPTY) {
			randomChoice = (int) Math.floor(Math.random() * 9);
		}
		return randomChoice;
	}

}
