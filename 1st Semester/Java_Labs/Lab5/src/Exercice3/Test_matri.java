package Exercice3;

import java.util.Scanner;

public class Test_matri {

	public static void main(String[] args) {
		int rows,colu;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter dimension of rows:");
		rows = scanner.nextInt();
		System.out.println("Enter dimension of colu.:");
		colu = scanner.nextInt();
		scanner.close();
		Matrix object1 = new Matrix(rows,colu);
		
		object1.randomFill(); //filling with random numbers
		System.out.println("Aspect of the array:");
		object1.print();
		
		object1.set(1, 2, 254);
		System.out.println("Aspect2 of the array:");
		object1.print();
		
		object1.transpose();
		

	}

}
