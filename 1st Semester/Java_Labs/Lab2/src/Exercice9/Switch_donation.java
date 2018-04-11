package Exercice9;

import java.util.Scanner;

public class Switch_donation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int da; //da : donation amount
		String a,b,c,d,e,f; //Recompenses  
		
		System.out.println("(>)Donation amounts:10;20;50;100;200;500 (€)");
		System.out.println("(>)Enter the amount you wish to donate:");
		da = scanner.nextInt();
		
		a = "Un High five avec les assistants";
		b = "Votre nom en ASCII";
		c = "Affichage public de votre don sur Moodle";
		d = "Une clé USB de 8Go";
		e = "Couvercle Uni.lu pour votre Smartphone";
		f = "Autographe de vos professeurs";
		
		switch(da) {
			case 10 :
				System.out.println(a);
				break;
			case 20 : 
				System.out.println(b);
				break;
			case 50 : 
				System.out.println(c);
				break;
			case 100 : 
				System.out.println(c+"\n"+d);
				break;
			case 200 : 
				System.out.println(c+"\n"+d+"\n"+e);
				break;
			case 500 : 
				System.out.println(c+"\n"+d+"\n"+e+"\n"+f);
				break;
			default: 
				System.out.println("(!)The amount you entered is invalid");
				System.exit(1);
				
		}
	}

}
