package ss.additional.week5;

import java.util.List;

public class EvenInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Exercise 12.2
	public int evenCount(List<Integer> list) {
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).intValue() % 2 == 0) {
				count++;
			}
		}
		return count;
	}
	
	//Exercise 12.3
	
	
	
	
}
