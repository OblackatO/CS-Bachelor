package Exercice3;

import java.util.Arrays;
import java.util.Random;

public class test_matrix {

	public static void main(String[] args) {
		int[][] M; //={{1,2,3 }, {4,5,6}};
		
		M = new int[10][20]; // first parenthesis vertical, second horizontal
		
		Random generator = new Random(System.currentTimeMillis());
		
		for(int ti=0;ti<=M[1].length-1;ti++) {
			int rn = generator.nextInt(20);
			M[0][ti] = rn;
		}
		System.out.println(Arrays.toString(M[0]));
		
		
		//System.out.println(M[0][1]);
		//System.out.println(M[1][2]);
		
		
		
		
		
	}

}
