package ss.week4;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    // Queries:
    
    
    //Commands:
	
    public static <E extends Comparable<E>>
    void mergesort(List<E> list) {
    	List<E> newList = split(list);
    	list.clear();
    	list.addAll(newList);
    }
	
    /**
     * Method to split the original list into lists of one element.
     * @param list - The original list.
     */
    public static <E extends Comparable<E>> List<E> split(List<E> list) {
    	List<E> resultList = new ArrayList<E>();

    	//Check if the list contains less than two elements, at which point we continue.
    	if (list.size() <= 1) {
    		resultList.addAll(list);
    		return resultList;
    	}
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
     * Method to merge the singular lists in an ordered sequence.
     * @param list - The lists consisting of singular values.
     * @param low - The lowest index of the list.
     * @param high - The highest index of the list.
     */
    public static <E extends Comparable<E>> List<E> merge(List<E> list, List<E> leftList, List<E> rightList) {
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

