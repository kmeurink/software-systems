package ss.additional.week4;

import java.util.Arrays;

//Exercise 13.8
public class Matrix {
	
	public static void main(String[] args) {
		Matrix test = new Matrix(3, 3);
		System.out.println(Arrays.deepToString(test.matrix()));
		test.set(0, 0, 5);
		test.set(0, 1, 5);
		test.set(0, 2, 5);
		test.set(1, 0, 5);
		test.set(1, 1, 5);
		test.set(1, 2, 5);
		System.out.println(Arrays.deepToString(test.matrix()));
	}
	
	//Named constants:
	private int rows;
	private int columns;
	private int[][] elements;
	
	//Constructors:
	/**
	 * Create a matrix with the specified number of rows and columns.
	 * @param rows
	 * @param columns
	 */
	//@requires rows > 0 && columns > 0;
	public Matrix(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		elements = new int[columns][rows];
	}
	
	
	//Queries:
	public int row() {
		return this.rows;
	}
	
	public int col() {
		return this.columns;
	}
	
	public int show(int row, int col) {
		return elements[row][col];
	}
	
	public int[][] matrix() {
		return this.elements;
	}
	
	//Commands:
	public void set(int row, int col, int value) {
		elements[row][col] = value;
	}
	
	//Exercise 13.9
	public Matrix product(Matrix matrix) {
		int n = this.rows;
		int p = this.columns;
		int m = matrix.columns;
		Matrix result = new Matrix(n, m);
		for (int row = 0; row < n; row = row + 1) {
			for (int col = 0; col < m; col = col + 1) {
				result.elements[row ][col] = 0;
				for (int i = 0; i < p; i = i + 1) {
					result.elements[row ][ col] =
							result.elements[row ][col] +
							this.elements[row][i] *
							matrix.elements[i][col ];
				}
			}
		}
		return result;
	}
	
}
