package Exercice_1;

import java.text.DecimalFormat;
import java.util.Scanner;

class Calculatrice  {
	double valeur;
	
	//Constructors
	Calculatrice(double valeur) {
		this.valeur = valeur;
	}
	Calculatrice() {
		this(0);
	}
	
	//addition
	void add(double value2) {
		valeur = valeur + value2;
	}
	
	//subtract
	void soustraction(double value2) {
		add(-value2);
	}
	
	//multiply
	void multiplication(double value2) {
		valeur = valeur * value2;
	}
	
	//division
	void division(double value2) {
		multiplication(1/value2);
	}
	
	double getValue() {
		return valeur;
	}
}



public class Class_calculette {

	public static void main(String[] args) {
		double number1=0,operation;
		DecimalFormat df = new DecimalFormat("#.##");
		Calculatrice object_1 = new Calculatrice(number1);
		Scanner scanner; 
		
		while(number1!=5) {
			scanner = new Scanner(System.in);
			System.out.println("Available operations:");
			System.out.println("1 "+"for +");
			System.out.println("2 "+"for -");
			System.out.println("3 "+"for *");
			System.out.println("4 "+"for /");
			System.out.println("5 "+"to quit");
			System.out.println("Select one option and press enter:");
			operation = scanner.nextDouble();
			if(operation==5) {
				System.out.println("Programming is exiting");
				scanner.close();
				break;
			
			}else if(operation==1) {
				System.out.println("Enter a number:");
				number1 = scanner.nextDouble();
				object_1.add(number1);
				System.out.println();
				System.out.println("Current value:"+df.format(object_1.getValue()));
				//scanner.close();
			
			}else if(operation==2) {
				System.out.println("Enter a number:");
				number1 = scanner.nextDouble();
				object_1.soustraction(number1);
				System.out.println();
				System.out.println("Current value:"+df.format(object_1.getValue()));
				//scanner.close();
			
			}else if(operation==3) {
				System.out.println("Enter a number:");
				number1 = scanner.nextDouble();
				object_1.multiplication(number1);
				System.out.println();
				System.out.println("Current value:"+df.format(object_1.getValue()));
				//scanner.close();
				
			}else if(operation==4) {
				System.out.println("Enter a number:");
				number1 = scanner.nextDouble();
				object_1.division(number1);
				System.out.println();
				System.out.println("Current value:"+df.format(object_1.getValue()));
				//scanner.close();
			}
		
		/**
		 * I was not able to close the stream at the end of each else if condition 
		 * 
		 * Traceback : 
		 * Exception in thread "main" java.util.NoSuchElementException
		 * at java.base/java.util.Scanner.throwFor(Scanner.java:858)
	     * at java.base/java.util.Scanner.next(Scanner.java:1497)
	     * at java.base/java.util.Scanner.nextDouble(Scanner.java:2467)
	     * at Exercice_1.Class_calculette.main(Class_calculette.java:61)

		*/
		
		
		}
 
	}
}

