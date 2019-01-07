package ss.additional.week5;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

//Exercise 22.6
public class Palindrome2<E> {
	
	//Testing if code works.
	public static void main(String[] args) {
		Palindrome2 test = new Palindrome2();
		
		System.out.println();
	}
	
	public Palindrome2() {
		
	}
	/**
	 * Method to check if a doublylinkedlist is a palindrome.
	 * @return
	 */
	public static <E> boolean palindrome(List<E> list) {
		int size = list.size();
		boolean isPalin = true;
		ListIterator<E> left = list.listIterator();
		ListIterator<E> right = list.listIterator(size);
		while (left.nextIndex() < size / 2 && isPalin) {
			isPalin = left.next() == right.previous();
		}
		
		return isPalin;
	}
}
