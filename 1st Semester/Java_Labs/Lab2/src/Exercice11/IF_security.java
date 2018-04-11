package Exercice11;

import java.util.Scanner;

public class IF_security {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a;
		System.out.println("Enter a number:");
		a = scanner.nextInt();
		scanner.close();
		if (a==3) // {
			//stopProgram();
			System.out.println("the number is a three...");
			System.out.println("the number is a three,second line..."); 
			// }
		if (a==4)
			System.out.println("the number is a four...");
		
	}

}
//In line 15 we have out 1st instruction after the first if statement. Since we do not 
//close the if statement with a "}" , java considers the line 16 to be out of the if statement
//This 16th is going to be executed, even if the condition is not satisfied. 