package ss.week4;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	

	//Constructor:
    public static <E extends Comparable<E>>
           void mergesort(List<E> list) {
    	int low = 0;	
    	int high = list.size() - 1;
    	split(list, low, high);
    		
    	
    	
    }
    
    // Queries:
    
    
    //Commands:
	// TODO: Create a method to initially split the list until only lists of size 1 remain;
    /**
     * Method to split the original list into lists of one element.
     * @param list - The original list.
     */
    public static <E extends Comparable<E>> void split(List<E> list, int low, int high) {
    	if (list.size() > 2) {
        	int mid = (high - low) / 2;
        	split(list, low, mid);
        	split(list, mid + 1, high);
    	}
    	merge(list, low, high);

    }
    /**
     * Method to merge the singular lists in an ordered sequence.
     * @param list - The lists consisting of singular values.
     * @param low - The lowest index of the list.
     * @param high - The highest index of the list.
     */
    public static <E extends Comparable<E>> void merge(List<E> list, int low, int high) {
    	List<E> tempList = new ArrayList<E>();
    	tempList = list;
    	E valueOne = tempList.get(low);
    	E valueTwo = tempList.get(high);
    	int valueFirst = valueOne.compareTo(valueTwo);
       	if (valueFirst < 0 || valueFirst == 0) {
        	list.set(low, valueOne);
        	list.set(high, valueTwo);
        }
    }
}

