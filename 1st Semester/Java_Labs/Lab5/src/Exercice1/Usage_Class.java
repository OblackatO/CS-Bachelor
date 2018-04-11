package Exercice1;

import java.util.Scanner;

public class Usage_Class {

	public static void main(String[] args) {
		int size1, size2;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the size of the first vector:");
		size1 = scanner.nextInt();
		System.out.println("Enter the size of the second vector:");
		size2 = scanner.nextInt();
		scanner.close();
		
		Vector vector1 = new Vector(size1);
		Vector vector2 = new Vector(size2);
		
		vector1.randomFill(0, 100);
		vector2.randomFill(0, 100);
		
		System.out.println(vector1.getDimension());
		System.out.println(vector2.getDimension());
		
		System.out.println(vector1.toString_1());
		System.out.println(vector2.toString_1());
		
		Vector vector3 = new Vector(size1);
		vector3 = vector1.add(vector2);
		System.out.println(vector3.toString_1());
		
		

	}

}
