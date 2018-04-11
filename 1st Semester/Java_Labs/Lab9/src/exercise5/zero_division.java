package exercise5;

import java.util.Scanner;

public class zero_division {

	public static double divide_doubles(double n1, double n2) throws DivisionZeroException {
		
		if(n1==0) {
			throw new DivisionZeroException("Cannot divide by 0.");
		}
		
		return n1/n2;
	}
	
	public static void main(String[] args) {
		
		double n1,n2;
		boolean executed = false;
		
		/*
		 * I do not understand why I am getting an exception here, because the program should sleep while 
		 * I do not input a number but it tries to scan.nextDouble() instead
		 * Try to run it with first number 0, otherwise works fine. 
		 */
		
		while(!(executed)) {
			try {
			
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter a number:");
				n1 = scanner.nextDouble();
				System.out.println("Enter a second number:");
				n2 = scanner.nextDouble();
				scanner.close();
				System.out.println(divide_doubles(n1,n2));
				executed = true;
			
			}catch(DivisionZeroException e) {
				
				System.out.println(e);
				System.out.println("Enter another number.");
			}
			
		}
	}
}















