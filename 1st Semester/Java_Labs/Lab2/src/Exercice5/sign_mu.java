package Exercice5;

import java.util.Scanner;

public class sign_mu {

	public static void main(String[] args) {
		int a,b ; 
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter 1st number:");
		a = scanner.nextInt();
		System.out.println("Enter 2nd number:");
		b = scanner.nextInt();
		int result = (a>0 && b>0) || (a<0 && b<0)  ? 1 : -1; //same thing as using the if statement 
		System.out.println("The result is:"+result);
		
		
	}

}
