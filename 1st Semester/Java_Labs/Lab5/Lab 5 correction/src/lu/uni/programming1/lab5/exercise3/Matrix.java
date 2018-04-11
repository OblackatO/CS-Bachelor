package lu.uni.programming1.lab5.exercise3;

import java.util.Random;

public class Matrix {

	static Random generator = new Random(System.currentTimeMillis());
	
	int[][] values;
	int m;
	int n;
	
	public Matrix(int m, int n) {
		this.m = m;
		this.n = n;
		values = new int[m][n];
	}
	
	public void randomFill() {
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				values[i][j] = generator.nextInt(101);
			}
		}
	}
	
	public void set(int rowIndex, int colIndex, int value) {
		if(rowIndex >= 0 && rowIndex < m && colIndex >= 0 && colIndex < n)
			values[rowIndex][colIndex] = value;
	}
	
	public Matrix transpose() {
		Matrix transpose = new Matrix(n, m);
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				transpose.set(j, i, values[i][j]);
			}
		}
		
		return transpose;
	}
	
	public void print() {
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(values[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Matrix m1 = new Matrix(3, 2);
		m1.randomFill();
		m1.print();
		
		System.out.println();
		
		Matrix m2 = m1.transpose();
		m2.print();
	}
}