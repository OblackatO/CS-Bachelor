package Exercice2;

public class Coke_Button extends Button {
	
	private static int total_quantity=15; //Default quantity of cookes in the machine
	private double price= 2; //2 euros
	
	public Coke_Button(String name) {
		super(name);
		
		if(Coke_Button.total_quantity == 0) {
			System.out.println("Product not available anymore.");;
		}else {
			/*
			 * Adds price to total bill and the name of product to basket
			 */
			Button.total_price += price;
			Button.total_products[Button.current_product] = name;
			Button.current_product++;
			Coke_Button.total_quantity--;
		}
	}
}
