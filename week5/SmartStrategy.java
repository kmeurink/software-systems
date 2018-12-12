package ss.week5;
import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Mark;

/**
 * Smart strategy for playing tictactoe,
 *  by following a smarter pattern, looking at available squares.
 * @author kester.meurink
 *
 */
public class SmartStrategy implements Strategy {
	private String name;
	
	public SmartStrategy() {
		this.name = "Smart";	
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
		if (b.isEmptyField(4)) {
			return 4;
		}
		//If there is a field guaranteeing a win, select that one.
		for (int i = 0; i < b.DIM * b.DIM; i++) {
			Board a = b.deepCopy();
			if (a.isEmptyField(i)) {
				a.setField(i, m); 
				if (a.hasColumn(m) || a.hasDiagonal(m) || a.hasRow(m)) {
					return i;
				}
			}
		}
		//If there is a field guaranteeing a win for the other mark, select that one.
		for (int i = 0; i < b.DIM * b.DIM; i++) {
			Board a = b.deepCopy();
			if (a.isEmptyField(i)) {
				a.setField(i, m.other()); 
				if (a.hasColumn(m.other()) || a.hasDiagonal(m.other()) || a.hasRow(m.other())) {
					return i;
				}
			}
		}
		//Choose a random field.
		Strategy s = new NaiveStrategy();
		return s.determineMove(b, m);

	}
}