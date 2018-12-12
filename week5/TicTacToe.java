package ss.week5;
import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Game;
import ss.week4.tictactoe.Mark;
import ss.week4.tictactoe.Player;

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
    	Strategy s;
    	if (args[1].equals("-N")) {
    		s = new NaiveStrategy();
    	} else if (args[1].equals("-S")) {
    		s = new SmartStrategy();
    	} else {
    		s = new NaiveStrategy();
    	}
    	//Strategy s = new NaiveStrategy();
    	Player p1 = new ComputerPlayer(Mark.XX, s);//HumanPlayer(args[0], Mark.XX);
    	Player p2 = new ComputerPlayer(Mark.OO, s);
    	Game game = new Game(p1, p2);
    	game.start();
    }
}
