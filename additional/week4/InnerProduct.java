package ss.additional.week4;

import java.util.Arrays;

//Exercise 13.4
/**
 * Class allowing for modification of arrays.
 * @author kester.meurink
 *
 */
public class InnerProduct {
	
	public static void main(String[] args) {
		InnerProduct test = new InnerProduct();
		int[] testArray1 = {2, 3, 4, 5};
		int[] testArray2 = {2, 3, 4, 5};
		System.out.println(Arrays.toString(testArray1));
		System.out.println(Arrays.toString(testArray2));
		test.product(testArray1, testArray2);
		System.out.println("Inner product is: " + test.sum());
		
	}
	
	//Named constants:
	private int innerSum = 0;
	
	//Constructors:
	public InnerProduct() {
		
	}
	//Queries:
	public int sum() {
		return this.innerSum;
	}
	
	
	//Commands:
	public void product(int[] array1, int[] array2) {
		int j = 0;
		for (int i = 0; i < array1.length; i++) {
			this.innerSum += array1[i] * array2[j];
			j++;
		}
			
	}
	
}
