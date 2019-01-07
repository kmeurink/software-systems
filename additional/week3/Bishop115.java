package ss.additional.week3;

public class Bishop115 extends AbstractPiece {
	
	public Bishop115(int row, int col, boolean white) {
		super("Bishop", new Square(row, col), white);
	}
	
	@Override
	public boolean canMoveTo(Square newLocation) {
		if (Math.abs(newLocation.row() - this.location().row()) == Math.abs(newLocation.col() - this.location().col()) && this.location().row() != newLocation.row() && this.location().col() != newLocation.col()) {
			return true;
		} else {
			return false;
		}
	}
}
