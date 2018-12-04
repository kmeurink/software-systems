package ss.additional;

/**
 * Implementation of the Piece interface to model a rook in chess.
 * @author kester.meurink
 *
 */
public class Rook implements Piece{

	private int currentRow = 5;
	private int currentCol = 4;
	
	public Rook() {
		
	}

		/**
		 * Checks if the Rook can move to the selected square.
		 * @return true if the Rook is allowed to move.
		 */
		/*@ pure*/public boolean canMoveTo(int row, int col) {
		if (currentRow != row && currentCol == col || currentCol != col && currentRow == row) {
			return true;
		} else {
			return false;
		}
	}
		
		/**
		 * Moves the Rook to the selected square.
		 */
	//@ requires canMoveTo(row, col) == true;
	@Override
	public void moveTo(int row, int col) {
		if (canMoveTo(row, col) == true) {
			this.currentRow = row;
			this.currentCol = col;
		}
	}
}
