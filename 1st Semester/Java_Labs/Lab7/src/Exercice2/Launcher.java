package Exercice2;

public class Launcher {

	public static void main(String[] args) {
		
		//Using hard-code to try the distribution machine, no user interaction
		
		//Two clicks on button coke 
		Button coke_object = new Coke_Button("Cola");
		Button coke_object1 = new Coke_Button("Cola");
		
		//Click on Bounty Button 
		Button bounty_object = new Bounty_Button("Bounty");
		
		//checking total items on the basket
		System.out.println("Items on the basket:");
		bounty_object.total_items();
		
		//Click on Cokezero Button
		Button cokezero_object = new Cokezero_Button("Coke_zero");
		
		//making checkout
		System.out.println("\n");
		cokezero_object.checkout();

	}

}
