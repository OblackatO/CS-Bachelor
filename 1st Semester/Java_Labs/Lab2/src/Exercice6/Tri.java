package Exercice6;

import java.util.Scanner;

public class Tri {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a,b,c; 
		
		System.out.println("Enter the 1st number:");
		a = scanner.nextInt();
		System.out.println("Enter the 2nd number:");
		b = scanner.nextInt();
		System.out.println("Enter the 3th number:");
		c = scanner.nextInt();
		scanner.close();

		if  ((a>b) && (a>c)) {
			if (b>c) {
				System.out.println(a+" "+b+" "+" "+c);
			}else  {
				System.out.println(a+" "+c+" "+" "+b);
			} }
		
		
		if ((b>a) && (b>c))  { 
			if (a>c)  {
				System.out.println(b+" "+a+" "+" "+c);
			}else  { 
				System.out.println(b+" "+c+" "+" "+a);
			} }
			
		
		if ((c>a) && (c>b))  {
			if (a>b)  {
				System.out.println(c+" "+a+" "+" "+b);
			}else  {
				System.out.println(c+" "+b+" "+" "+a);
			} }
	}
}
			

