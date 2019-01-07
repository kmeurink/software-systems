package ss.additional.week4;

import java.util.Arrays;

//Exercise 13.3
/**
 * Class allowing for modification of arrays.
 * @author kester.meurink
 *
 */
public class MoveUp {
	
	public static void main(String[] args) {
		MoveUp test = new MoveUp();
		int[] testArray = {0,1,2,3,4,5};
		System.out.println(Arrays.toString(testArray));
		test.move(testArray);
		System.out.println(Arrays.toString(testArray));
	}
	
	//Named constants:
	
	
	//Constructors:
	public MoveUp() {
		
	}
	//Queries:
	
	
	//Commands:
	public void move(int[] array) {
		int temp = array[array.length - 1];
		for (int i = array.length - 2; i >= 0; i = i - 1) {
			array[i + 1] = array[i];
		}
		array[0] = temp;
	}
	
}
