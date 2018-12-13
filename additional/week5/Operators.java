package ss.additional.week5;

import java.util.List;

public class Operators{
	//Exercise 12.11
	public int foldl (OperatorwithIdentity op, List<Integer> list) {
		int apply = op.operate(list.get(0).intValue(), list.get(1).intValue());
		if (list.isEmpty()) {
			return op.identity();
		} else if (list.size() == 1) {
			return list.get(0).intValue();
		} else {
			for (int i = 1; i < list.size(); i++) {
				apply += op.operate(apply, list.get(i+1).intValue()); 
			}
		}
		return apply;
	}
	
	//Exercise 12.12
	//No answers available so not done.
	

}
