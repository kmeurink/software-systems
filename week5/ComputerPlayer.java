package ss.week5;

import ss.week4.tictactoe.Board;
import ss.week4.tictactoe.Game;
import ss.week4.tictactoe.Mark;
import ss.week4.tictactoe.Player;
/**
 * Class for maintaining a computer player in Tic Tac Toe. Module 2 lab assignment
 */

public class ComputerPlayer extends Player {
	private Strategy strategy;
	
    public ComputerPlayer(Mark mark, Strategy strategy) {
        super(strategy.getName() + "-" + mark.name(), mark);
        this.strategy = strategy;
    }
    
    public ComputerPlayer(Mark mark) {
        super("NaiveStrategy-" + mark, mark);
    }
    
    @Override
	public int determineMove(Board board) {
		return strategy.determineMove(board, this.getMark());
	}
 
	public Strategy inspect() {
		return strategy;
	}

	public void update(Strategy strat) {
		this.strategy = strat;
	}
}
