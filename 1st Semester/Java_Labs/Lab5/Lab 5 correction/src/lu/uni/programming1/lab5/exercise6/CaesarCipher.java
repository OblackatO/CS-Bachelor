package lu.uni.programming1.lab5.exercise6;

import java.util.Scanner;

public class CaesarCipher {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a plaintext: ");
		String plainText = scanner.nextLine();

		int shift;
		do {
			System.out.print("Enter a shift constant: ");
			shift = scanner.nextInt();
		} while ((shift % 26) == 0);

		scanner.close();

		plainText = plainText.toUpperCase().replaceAll("[^A-Z]", "");
		shift = shift % 26;
		if (shift < 0) {
			shift += 26;
		}

		String cipherText = "";
		char originalLetter, newLetter;
		int offset;
		for (int i = 0; i < plainText.length(); i++) {
			originalLetter = plainText.charAt(i);
			offset = originalLetter - 'A';
			offset = (offset + shift) % 26;
			newLetter = (char) ('A' + offset);
			cipherText += newLetter;
		}

		System.out.println("\nCaesar Cipher (Shift = " + shift + ")");
		System.out.println("Plaintext  :  " + plainText);
		System.out.println("Ciphertext :  " + cipherText);
	}
}