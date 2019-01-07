package ss.additional.week3;

public class Rook115 extends AbstractPiece {
	
	public Rook115(int row, int col, boolean white) {
		super("Rook", new Square(row, col), white);
	}
	
	
	@Override
	public boolean canMoveTo(Square newLocation) {
		if (this.location().row() != newLocation.row() && this.location().col() == newLocation.col()
				|| this.location().col() != newLocation.col()
				&& this.location().row() == newLocation.row()) {
			return true;
		} else {
			return false;
		}
	}
}
