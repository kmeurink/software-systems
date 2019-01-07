package ss.additional.week5;

import java.util.*;

public class PlayingCard {
	
	public PlayingCard() {
		

	}
	
	public boolean sameSuit(List<PlayingCard> list) {
		boolean same = true;
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).suit() != list.get(i + 1).suit()) {
				same = false;
			}
		}
		return same;
	}

}
