package ss.additional.week5;

/**
 * Class modelling the insertion sort algorithm
 * @author kester.meurink
 *
 */

public class InsertSort {
	
	
	public InsertSort() {
	}
	//Insertion sort algorithm
	public void sort(int[] array) {
		//For every index starting at i = 1(second element), we check the position.
		for (int i = 1; i < array.length; i++) {
			//Initialise the index before the current i.
			int j = i - 1;
			//Save a copy of the current value at index i, for comparison.
			int temp = array[i];
			//Now for every value before i, the size must be compared.
			//As long as the value before is greater than i, something must be done.
			//If there are multiple index j's before it, this will repeat until every element is compared
			//And switched.
			while (j >= 0 && temp < array[j]) {
				//Switch the two array values, placing the value of the j index at i.
				array[j + 1] = array[j];
				//take one step back, to compare the switched i value, with the new value preceding it.
				j--;
			}
			//Appoint the index i value at the preceding position.
			array[j + 1] = temp;
		}
 
	}
	
    /* A utility function to print array of size n*/
    static void printArray(int arr[]) { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
  
        System.out.println(); 
    } 
  
    // Driver method 
    public static void main(String args[]) 
    {         
        int arr[] = {12, 11, 10, 9, 8, 6, 5, 4, 3, 2, 1}; 
        int arr2[] = {12, 9, 4, 15, 5, 11, 2, 8, 1, 18, 6};
  
        InsertSort ob = new InsertSort();         
        ob.sort(arr);
        ob.sort(arr2);
          
        printArray(arr);
        printArray(arr2);
    }
    //Example insert sort solution
    /*
	for (int i=1; i<this.array.length; ++i) {
		int key = this.array[i]; 
        int j = i-1; 
           Move elements of arr[0..i-1], that are 
           greater than key, to one position ahead 
           of their current position 
        while (j >= 0 && this.array[j] > key) {
        	this.array[j + 1] = this.array[j]; 
            j = j - 1; 
        } 
        this.array[j + 1] = key; 
    }
	*/
}
