package Exercice_3;

import java.util.Scanner;

public class moyenne {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a,b=0,c=0,f=0,result;
		
		System.out.println("Enter values:");
		
		while (b==0) {
			a = scanner.nextInt();
			if (a==0) {
				scanner.close();
				break;
			}
			c = a+c; 
			f++;
		
		}
		result = c/f;
		System.out.println("The average is:"+result);
			
		
		
		
		
		
		
		
		
		
		/*for() {
			a = scanner.nextInt();
			b = a+b;
			f++;
			
		}
		b = b/f;
		System.out.println("The average is:"+b);
		scanner.close();*/

	}

}
