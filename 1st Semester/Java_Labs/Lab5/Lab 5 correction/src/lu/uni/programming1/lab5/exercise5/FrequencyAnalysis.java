package lu.uni.programming1.lab5.exercise5;

import java.util.Scanner;

public class FrequencyAnalysis {

	public static void main(String[] args) {

		// read text
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a text: ");
		String text = scanner.nextLine();
		scanner.close();

		// clean data
		text = text.toUpperCase().replaceAll("[^A-Z]", "");

		// frequency analysis
		int[] letterFrequency = new int[26];
		for (int i = 0; i < text.length(); i++) {
			char letter = text.charAt(i);
			letterFrequency[letter - 'A']++;
		}

		// print analysis
		for (int i = 0; i < letterFrequency.length; i++) {
			char letter = (char) ('A' + i);
			System.out.print(letter + ": " + letterFrequency[i] + "\t");
			if ((i + 1) % 13 == 0) {
				System.out.println();
			}
		}
	}
}