package Exercice3;

import java.util.Random;
import java.util.Arrays;

class Matrix {
	int[][] M;
	
	Matrix(int l1,int l2) {
		this.M = new int[l1][l2];
	}
	
	static Random generator = new Random(System.currentTimeMillis());
	void randomFill() {
		for(int ti=0;ti<=M.length-1;ti++) {
			for(int ti1=0;ti1<=M[1].length-1;ti1++) {
				int ntf = generator.nextInt(101); //ntf :number to fill
				M[ti][ti1] = ntf;
			}
		}
	}
	
	void set(int i,int j,int value) {
		M[i][j] = value;
	}
	
	void print() {
		for (int ti=0;ti<=M.length-1;ti++) {
			System.out.println(Arrays.toString(M[ti]));
		}
	}
	
	void transpose() {
		//System.out.println(M.length);
		for(int ti=0;ti<=M[0].length-1;ti++) {
			for(int ti1=0;ti1<=M.length-1;ti1++) {
				System.out.print(" "+M[ti1][ti]+" ");
			}
			System.out.println();
		}
	}
		
	
}