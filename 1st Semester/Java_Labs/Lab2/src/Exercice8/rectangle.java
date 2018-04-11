package Exercice8;

import java.util.Scanner;

public class rectangle {

	public static void main(String[] args) {
		int xmin,xmax,ymin,ymax,p1,p2;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the Xmin rectangle coordinate:");
		xmin = scanner.nextInt();
		System.out.println("Enter the Ymin rectangle coordinate:");
		ymin = scanner.nextInt();
		System.out.println("Enter the Xmax rectangle coordinate:");
		xmax = scanner.nextInt();
		System.out.println("Enter the Ymax rectangle coordinate:");
		ymax = scanner.nextInt();
		System.out.println("Enter the 1st coordinate of the point:");
		p1 = scanner.nextInt();
		System.out.println("Enter the 2nd coordinate of the point:");
		p2 = scanner.nextInt();
		scanner.close();
		
		if ((p1>xmin && p1<xmax) && (p2>ymin && p2<ymax)) {
			System.out.println("The point:"+p1+","+p2+"is in the rectangle");
		}else  {
			System.out.println("The point:"+p1+","+p2+"is not in the rectangle");
		}
		
		
	}

}
