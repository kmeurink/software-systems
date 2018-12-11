package ss.week4.tictactoe;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
	
    public static void main(String[] args) {
        // TODO: implement, see P-4.21
    	Game game = new Game(new HumanPlayer(args[0], Mark.OO), new HumanPlayer(args[1], Mark.XX));
    	game.start();
    }
}
