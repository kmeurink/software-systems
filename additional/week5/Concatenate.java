package ss.additional.week5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class to use a concatenation method.
 * @author kester.meurink
 *
 * @param <E> the chosen element.
 */
//Exercise 22.4
public class Concatenate<E> {
	//Testing if code works.
	public static void main(String[] args) {
		Concatenate test = new Concatenate();
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		for (int i = 1; i < 5; i++) {
			list1.add(i);
		}
		for (int i = 1; i < 5; i++) {
			list1.add(i);
		}
		System.out.println(Concatenate.concatenate(list1, list2));
	}
	
	public Concatenate() {
		
	}
	/**
	 * Method to concatenate two lists of elements.
	 * @param list1 - the first list.
	 * @param list2 - the second list.
	 * @return the concatenated list.
	 */
	public static <E> List<E> concatenate(List<E> list1, List<E> list2) {
		List<E> listConcat = new ArrayList<E>();
		Iterator<E> it1 = list1.iterator();
		while (it1.hasNext()) {
			listConcat.add(it1.next());
		}
		Iterator<E> it2 = list2.iterator();
		while (it2.hasNext()) {
			listConcat.add(it2.next());
		}
		return listConcat;
	}

}
