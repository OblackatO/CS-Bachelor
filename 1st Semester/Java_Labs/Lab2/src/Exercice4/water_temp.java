package Exercice4;

import java.util.Scanner;

public class water_temp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		float tempe;
		boolean tf; 
		
		System.out.println("(>)Enter the temp you desire:");
		tempe = scanner.nextFloat();
		scanner.close();
		tf = tempe < 0 ; 
		System.out.println("(>)The temperature "
		+tempe+ " freezes water:"+tf);

	}

}
