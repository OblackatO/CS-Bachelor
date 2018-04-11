package Exercice_4;

import java.util.Scanner;

public class split_numbers2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int powerten=0;
		double number,n1;
		
		System.out.println("Enter a value:");
		number = scanner.nextInt();
		scanner.close();
		
		while (true) {
			if (number<0)  {
				number = Math.abs(number);
				System.out.print("moins ");
			} 
			while (number>=Math.pow(10,powerten)) {
				powerten = powerten +1;
			}
			powerten = powerten-1;
			n1 = number/(Math.pow(10,powerten));
			int n11 = (int) n1;
			switch(n11)  {
				case 0:
					System.out.print("zero ");
					break;
				case 1:
					System.out.print("one ");
					break;
				case 2:
					System.out.print("two ");
					break;
				case 3:
					System.out.print("three ");
					break;
				case 4:
					System.out.print("four ");
					break;
				case 5:
					System.out.print("five ");
					break;
				case 6:
					System.out.print("six ");
					break;
				case 7:
					System.out.print("seven ");
					break;
				case 8:
					System.out.print("eight ");
					break;
				case 9:
					System.out.print("nine ");
					break;
				}
			if (powerten<1) {
				break;
			}
			number = number%Math.pow(10, powerten);
			powerten=0;

	} 

	}
}

