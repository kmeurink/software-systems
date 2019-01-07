package ss.additional.week3;
/**
 * Class modelling pieces in a chess game.
 * @author kester.meurink
 *
 */
public abstract class AbstractPiece {
	//Named constants:
	private boolean colorWhite;
	private Square location;
	private String name;
	//Constructors:
	protected AbstractPiece(String name, Square location, boolean white) {
		this.name = name;
		this.location = location;
		this.colorWhite = white;
	}
	
	//Queries:
	/**
	 * Check if the piece is white.
	 * @return true if the piece is white.
	 */
	public boolean isWhite() {
		return this.colorWhite;
	}
	
	/**
	 * return the name of the piece.
	 * @return the name.
	 */
	public String name() {
		return this.name;
	}
	/**
	 * Shows the location of the piece.
	 * Returns null if the piece is not on the board.
	 * @return the location of the piece.
	 */
	public Square location() {
		return this.location;
	}
	
	/**
	 * Checks if the piece can move to the selected position.
	 * @param location - the location the piece want to move to.
	 * @return true if the piece can move to the location.
	 */
	public abstract boolean canMoveTo(Square location);
		
	//Commands:
	/**
	 * Move the piece to the selected position, if it can do so.
	 * Otherwise nothing happens.
	 * @param newLocation the selected position.
	 */
	public void moveTo(Square newLocation) {
		if (canMoveTo(newLocation)) {
			this.location = newLocation;
		}
	}
	
	/**
	 * Removes the piece from the game.
	 */
	public void remove() {
		this.location = null;
	}
	
}
