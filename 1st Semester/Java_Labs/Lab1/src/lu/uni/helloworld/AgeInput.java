package lu.uni.helloworld;

import java.util.Scanner;

public class AgeInput {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your age:");
		int age = scanner.nextInt();
		scanner.close();
		System.out.println("Your age is: "+age+" !");
	}
}
