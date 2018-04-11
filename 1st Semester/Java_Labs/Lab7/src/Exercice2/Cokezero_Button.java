package Exercice2;

public class Cokezero_Button extends Button {
	
	private static int total_quantity=10; //Default quantity of  zerocookes in the machine
	private double price= 2.10; //2.10 euros
	
	public Cokezero_Button(String name) {
		super(name);
		
		if(Cokezero_Button.total_quantity == 0) {
			System.out.println("Product not available anymore.");;
		}else {
			/*
			 * Adds price to total bill and the name of product to basket
			 */
			Button.total_price += price;
			Button.total_products[Button.current_product] = name;
			Button.current_product++;
		}
	}
}
