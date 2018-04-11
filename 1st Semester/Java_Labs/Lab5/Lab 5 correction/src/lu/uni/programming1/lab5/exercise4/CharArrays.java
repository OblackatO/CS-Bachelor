package lu.uni.programming1.lab5.exercise4;

public class CharArrays {

	public static void main(String[] args) {
		char[] shortAlphabet = { 'a', 'b', 'c' };

		System.out.println("" + shortAlphabet[0] + shortAlphabet[2] + shortAlphabet[1] + shortAlphabet[0]);

		char[] longerAlphabet = new char[shortAlphabet.length + 1];

		for (int i = 0; i < shortAlphabet.length; i++) {
			longerAlphabet[i] = shortAlphabet[i];
		}
		longerAlphabet[shortAlphabet.length] = 'd';

		for (char element : longerAlphabet) {
			System.out.print(element + " ");
		}

		System.out.println();

		System.out.println((int) shortAlphabet[0]);
	}
}