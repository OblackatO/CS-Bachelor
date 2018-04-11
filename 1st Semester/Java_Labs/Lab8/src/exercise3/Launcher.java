package exercise3;

import java.text.DecimalFormat; 

public class Launcher {
	

	public static void main(String[] args) {
		
		//Creates Proper format for doubles 
		DecimalFormat df = new DecimalFormat("#.00");
		
		//Creates Super_market
		Super_market market = new Super_market();
		
		//Creates object to assign id to loyalty card, checks for repeated IDS
		Set_ID assigner = new Set_ID();
		//Creates a loyalty card 
		Loyalty_Card card1 = new Loyalty_Card(assigner.set_random_ID());
		
		//Client shops twice with his card, and 10% is added to his points 
		card1.checkout(234.67); // 234.67€ : price1
		card1.checkout(34.45); // .... € : price2
		
		//Now client tries to pay with his points a bill greater than 10% of price1 and price2
		if(card1.checkout_with_points(4532.67) && market.allow_redeem(card1)) {
			System.out.println("Successfully paid. you have "+df.format(card1.Get_accumulated_points())+" points left.");
			market.add_client(card1); //adds client to list of the day
		}else {
			System.out.println("Sorry, no points available or you already have used points today.");
		};
		
		//Client successfully pays with card. 
		if(card1.checkout_with_points(14.67) && market.allow_redeem(card1)) {
			System.out.println("Successfully paid. you have "+df.format(card1.Get_accumulated_points())+" points left.");
			market.add_client(card1);
		}else {
			System.out.println("Sorry, no points available or you already have used points today.");
		};
		
		//Tries to pay again on the same day 
		if(card1.checkout_with_points(14.67) && market.allow_redeem(card1)) {
			System.out.println("Successfully paid. you have "+df.format(card1.Get_accumulated_points())+" points left.");
			market.add_client(card1);
		}else {
			System.out.println("Sorry, no points available or you already have used points today.");
		};
		
		//We add two family members to card1 
		market.increase_cardID_total(card1);
		market.increase_cardID_total(card1);
		
		//We check how many people card1 has associated to it, which in this case should be three
		System.out.println("\n"+"Total associated members to card ID:"+card1.Get_ID());
		System.out.println(market.AssociatedMembers_ToCard(card1));

	}
}
