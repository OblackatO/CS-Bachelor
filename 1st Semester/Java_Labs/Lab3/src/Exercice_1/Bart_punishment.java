package Exercice_1;

import java.util.Scanner; 

public class Bart_punishment {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int a; //number of times specified by teacher
		
		System.out.println("[>]Enter the number of times you want Bart to write the phrase:");
		a = scanner.nextInt();
		scanner.close();
		
		for(int b=1; b<=a ; b++) {
			System.out.println("Je ne suis pas allergique à la programmation.");
		}
		//System.exit(1);
		

	}

}
