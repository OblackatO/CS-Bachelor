package Exercice_2;

import java.util.Scanner;

public class sigma_sum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a=0,i=1,exp_result,total_sum=0;
		
		while(a>0) {
			System.out.println("Enter a number:");
			a = scanner.nextInt();
			scanner.close();
		}
		
		
		exp_result = (a*(a+1))/2;
		System.out.println("Expression result: "+exp_result);
		
		//for 
		for(int e=1; e<=a; e++) {
			total_sum = total_sum + e;
		}
		System.out.println("Result for loop: "+total_sum);
		total_sum = 0;

		//do-while 
		do {
			total_sum = total_sum + i;
			i++;
		} while(i<=a);
		System.out.println("Result do-while loop: "+total_sum);
		total_sum = 0;
		i=0;
		
		//while 
		while(i<=a) {
			total_sum = total_sum + i;
			i++;
		}
		System.out.println("Result while loop: "+total_sum);
		
	}
}
