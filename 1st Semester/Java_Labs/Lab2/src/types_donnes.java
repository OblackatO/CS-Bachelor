

import java.util.Scanner;

public class types_donnes {
	
	public static void main(String[] args) {
		
		boolean a,b,c ; 
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the value of a (true/false):");
		a =  scanner.nextBoolean();
		System.out.println("Enter the value of b (true/false):");
		b = scanner.nextBoolean();
		scanner.close();
		c = !a || b;
		System.out.println("The result of a-->b is :"+c);
		

	}

}
