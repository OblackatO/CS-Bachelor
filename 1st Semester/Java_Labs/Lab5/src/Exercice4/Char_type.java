package Exercice4;

import java.util.Arrays;

public class Char_type {

	public static void main(String[] args) {
		char[] shortAlphabet = {'a','b','c'};
		
		System.out.print(shortAlphabet[0]);
		System.out.print(shortAlphabet[2]);
		System.out.print(shortAlphabet[1]);
		System.out.print(shortAlphabet[0]);
		
		char[] array2;
		array2 = new char[3];
		
		for(int ti=0;ti<=array2.length-1;ti++) {
			if(ti==3) {
				array2[ti]='d';
			}
			array2[ti] = shortAlphabet[ti];
		}
		
		System.out.println(Arrays.toString(array2));
		System.out.println(Character.getNumericValue(shortAlphabet[0]));
		System.out.println(Character.getNumericValue(array2[0]));
		

	}

}
