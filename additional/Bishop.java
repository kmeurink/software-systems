package ss.additional;

public class Bishop implements Piece{

	private int currentRow = 5;
	private int currentCol = 4;
	
	public Bishop() {
		
	}

		/**
		 * Checks if the Bishop can move to the selected square.
		 * @return true if the Rook is allowed to move.
		 */
	@Override
	/*@ pure*/public boolean canMoveTo(int row, int col) {
		if (Math.abs(currentRow - row) == Math.abs(currentCol - col) && currentRow != row && currentCol != col) {
		return true;
		} else {
		return false;
		}
	}
		
		/**
		 * Moves the Bishop to the selected square.
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
