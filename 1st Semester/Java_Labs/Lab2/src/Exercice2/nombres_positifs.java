package Exercice2;

import java.util.Scanner;

public class nombres_positifs {
	
	public static void main(String[] args) {
		int n1,n2,result; 
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("If the program outputs 1 the first number is bigger the the 2nd one, if it outputs 0, the 1st one is smaller then the 2nd one.");
		System.out.println("(>)Enter your first number:");
		n1 = Math.abs(scanner.nextInt());
		System.out.println("(>)Enter your second number:");
		n2 = Math.abs(scanner.nextInt());
		scanner.close();
		
		result = n1/n2; 
		result = Math.min(result,1); // In case of integer == Math.min
		System.out.println(Math.round(result));
		
		
		
		

	}

}
