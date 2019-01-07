package ss.additional.week5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Exercise 14.8
public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	/**
	 * Method that merges the specified lists.
	 * @param list1
	 * @param list2
	 * @param order
	 * @return
	 */
	// @require list1 and list2 are sorted
	// @ensure merge(list1, list2) is sorted
	public static <E> List<E> merge(List<E> list1, List<E> list2, Comparator<E> order) {
		int e1 = 0;
		int e2 = 0;
		List<E> merged = new ArrayList<E>();
		while (e1 < list1.size() && e2 < list2.size()) {
			if (order.compare(list1.get(e1), list2.get(e2)) <= 0) {
				merged.add(list1.get(e1));
				e1 = e1 + 1;
			} else {
				merged.add(list2.get(e2));
				e2 = e2 + 1;
			}
		}
		while (e1 < list1.size()) {
			merged.add(list1.get(e1));
			e1 = e1 + 1;
		}
		while (e2 < list2.size()) {
			merged.add(list2.get(e2));
			e2 = e2 + 1;
		}
		return merged;
	}

}
