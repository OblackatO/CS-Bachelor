package Exercice_6;

import java.util.Scanner;
import java.util.Random;

public class deviner_nombre {

	public static void main(String[] args) {
		int rn,gn=-1,nof=0 ;//rn : random number, gn:guessed number,nof:number of tries
		Random generator = new Random(System.currentTimeMillis());
		rn = generator.nextInt(101);
		
		Scanner scanner = new Scanner(System.in);
		while(rn!=gn) {
			System.out.println();
			System.out.println("Number between 0-100(both included):");
			gn = scanner.nextInt();
			if (rn<gn) {
				System.out.println("Number is too big.");
				nof++;
			} else if(rn>gn) {
				System.out.println("Number is too small.");
				nof++;
			} else if(rn==gn) {
				System.out.println("You guessed the right number: "+gn);
				System.out.println("Number of attempted times: "+nof);
				scanner.close();
				break;
			}
				
		}
			
			

	}

}
