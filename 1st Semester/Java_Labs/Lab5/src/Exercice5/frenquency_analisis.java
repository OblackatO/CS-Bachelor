package Exercice5;

import java.util.Scanner;

public class frenquency_analisis {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a sentence:");
		String text = scanner.nextLine();
		text = text.toUpperCase().replaceAll("[^A-Z]", "");
		scanner.close();
		
		int[] alphabet_count=new int[26];
		char[] alphabet_real=  {'A','B','C','D','E','F','G','H',
								'I','J','K','L','M','N','O','P','Q',
								'R','S','T','U','V','W','X','Y','Z'
								};
		
		for(int ti=0;ti<=text.length()-1;ti++) { //check if needed -1 or not : needed
			char current_char = text.charAt(ti);
			for(int ti1=0;ti1<=alphabet_real.length-1;ti1++)  {  
				if(alphabet_real[ti1]==current_char) {
					alphabet_count[ti1] += 1;
				}
			}
		}
		
		for(int ti=0;ti<=alphabet_count.length-1;ti++) {
			System.out.println(alphabet_real[ti]+":"+alphabet_count[ti]); 
		}
	}
}


