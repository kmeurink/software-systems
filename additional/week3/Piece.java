package ss.additional.week3;
/**
 * Model the possible methods corresponding with a chess piece.
 * @author kester.meurink
 *
 */
public interface Piece {

	/**
	 * Checks if the chess piece can move to the selected square.
	 * @return true if the chess piece is allowed to move.
	 */
	/*@ pure*/public boolean canMoveTo(int row, int col);
	
	/**
	 * Moves the chess piece to the selected square.
	 */
	//@ requires canMoveTo(row, col) == true;
	public void moveTo(int row, int col);
}
