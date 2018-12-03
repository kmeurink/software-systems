package ss.additional;

/**
 * Implementation of the Piece interface to model a rook in chess.
 * @author kester.meurink
 *
 */
public class Rook implements Piece{

	private int row;
	private int col;
	
	public Rook() {
		
	}

		/**
		 * Checks if the Rook can move to the selected square.
		 * @return true if the Rook is allowed to move.
		 */
		/*@ pure*/public boolean canMoveTo(int row, int col) {
			
		}
		
		/**
		 * Moves the Rook to the selected square.
		 */
		//@ requires canMoveTo( row, col) == true;
		public void moveTo(int row, int col) {
			
		}
}
