package Exercice_8;

import java.util.Scanner;

public class Fibonacci_sequence {

	public static void main(String[] args) {
		int n,result=0,f=2;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the n term for the Fibonacci sequence:");
		n = scanner.nextInt();
		scanner.close();
		
		while(f<=n) {
			result = (f-1) + (f-2);
			System.out.println("F"+f+" is:"+result);
			f++;
		}

	}

}
