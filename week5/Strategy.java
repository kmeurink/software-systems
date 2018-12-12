package ss.week5;
import ss.week4.tictactoe.*;

/**
 * 
 * @author kester.meurink
 * Interface for different tictactoe strategies.
 */
public interface Strategy {
	
	/**
	 * Method to return the name given to the strategy.
	 * @return the name of the strategy.
	 */
	public String getName();
	
	/**
	 * Method to determine what the next legal move is that the player makes.
	 * @param b - the board the game is played on.
	 * @param m - the mark assigned to the player.
	 * @return
	 */
	//@ requires b instanceof Board;
	//@ requires m instanceof Mark;
	public int determineMove(Board b, Mark m);

}
