package ss.additional.week5;

import java.util.*;

//Exercise 12.13
/**
 * Class modelling the board for chess.
 * @author kester.meurink
 *
 */

public class ChessBoard {
	List<List<Square>> board;
	public ChessBoard() {
		board = new ArrayList<List<Square>>();
		//Create the full board
		for (int r = 1; r <= 8; r++) {
			//Create a row of the board
			List<Square> row = new ArrayList<Square>();
			for (int c = 1; c <= 8; c++) {
				row.add(new Square(r, c));
			}
			board.add(row);
		}
	}
	
	public Square squareAt(int row, int column) {
		return board.get(row - 1).get(column - 1);
	}
}
