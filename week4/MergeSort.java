package ss.week4;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    // Queries:
    
    
    //Commands:
	/**
	 * Start of the mergesort sorting algorithm.
	 * @param list - the list that is to be sorted.
	 */
    public static <E extends Comparable<E>>
    	void mergesort(List<E> list) {
    	List<E> newList = split(list);
    	list.clear();
    	list.addAll(newList);
    }
	
    /**
     * Method to split the list supplied into lists of half the original length.
     * @param list - The list that should be halved.
     */
    public static <E extends Comparable<E>> List<E> split(List<E> list) {
    	//Initiate the list that will contain the ordered sequence.
    	List<E> resultList = new ArrayList<E>();

    	//Check if the list contains less than two elements, at which point it moves beyond split().
    	if (list.size() <= 1) {
    		resultList.addAll(list);
    		return resultList;
    	}
    	/*
    	 * Determine the index at which the list must be halved 
    	 * and create a left and right half of the list.
    	 * Then recursively call the split() method on both halves.
      	 */
    	int mid = list.size() / 2;
    	List<E> leftList = list.subList(0, mid);
    	List<E> rightList = list.subList(mid, list.size());
    	
    	leftList = split(leftList);
       	rightList = split(rightList);

        //Call the merge method.
       	resultList = merge(list, leftList, rightList);
    	return resultList;
    }
    /**
     * Method to merge the lists into an ordered sequence.
     * @param list - The lists consisting of half the values of the supplied list.
     * @param leftList - The left half of the original list.
     * @param rightList - The right half of the original list.
     */
    public static <E extends Comparable<E>> List<E> merge(List<E> list, 
    		List<E> leftList, List<E> rightList) {
    	List<E> resultList = new ArrayList<E>(leftList.size() + rightList.size());
    	int leftPointer = 0;
    	int rightPointer = 0;
    	int resultPointer = 0;
    	    	
    	while (leftPointer < leftList.size() || rightPointer < rightList.size()) {
    		
    		if (leftPointer  < leftList.size() && rightPointer < rightList.size()) {
    			if (leftList.get(leftPointer).compareTo(rightList.get(rightPointer)) < 0) {
    				resultList.add(resultPointer, leftList.get(leftPointer));
    				resultPointer++;
    				leftPointer++;
    			} else {
    				resultList.add(resultPointer, rightList.get(rightPointer));
    				resultPointer++;
    				rightPointer++;
    			}
    		} else if (leftPointer < leftList.size()) {
    			resultList.add(resultPointer, leftList.get(leftPointer));
				resultPointer++;
				leftPointer++;
    		} else if (rightPointer < rightList.size()) {
    			resultList.add(resultPointer, rightList.get(rightPointer));
				resultPointer++;
				rightPointer++;
    		}
    	}
    	return resultList;
    }
}

