package lu.uni.programming1.lab5.exercise1;

import java.util.Scanner;

public class Launcher {

	public static void main(String[] args) {
		int dimension;

		Scanner scanner = new Scanner(System.in);

		do {
			System.out.print("Enter a dimension: ");
			dimension = scanner.nextInt();
		} while (dimension < 0);

		scanner.close();

		Vector v1 = new Vector(dimension);
		v1.randomFill(0, 100);

		Vector v2 = new Vector(dimension);
		v2.randomFill(0, 100);

		Vector v3 = v1.add(v2);

		System.out.println("Vector 1: " + v1);
		System.out.println("Norm: " + v1.getNorm());
		System.out.println("Vector 2: " + v2);
		System.out.println("Norm: " + v2.getNorm());
		System.out.println("Vector 3: " + v3);
		System.out.println("Norm: " + v3.getNorm());
	}
}