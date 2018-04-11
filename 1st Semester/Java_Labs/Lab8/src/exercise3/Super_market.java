package exercise3;

import java.time.LocalDate;
import java.util.*;

public class Super_market {
	
	private static List <Loyalty_Card> card_list = new ArrayList <Loyalty_Card>();
	private static Map<LocalDate, List<Loyalty_Card>> data_base = new HashMap<LocalDate, List<Loyalty_Card>>();
	private static Map<Integer, Integer> card_members = new HashMap<Integer, Integer>(); //keeps track of how many people have the card
	
	/*
	 * Had an error on data_base.put() method if use ArrayList. Noticed that it was because 
	 * of the type List of the card_list variable. 
	 * 
	 * private static Map<LocalDate, ArrayList<Loyalty_Card>> data_base = new HashMap<LocalDate, ArrayList<Loyalty_Card>>(); :
	 * will not work, as the type of card_list is List, works if type is changed to ArrayList
	 */
	
	public Super_market() {}
		
	public void add_client(Loyalty_Card card) {
		LocalDate date = LocalDate.now();
		Super_market.card_list.add(card);
		Super_market.data_base.put(date,Super_market.card_list); //remark : ".add" won't work  
		Super_market.card_members.put(Integer.valueOf(card.Get_ID()), Integer.valueOf(1));
	}
	
	public void increase_cardID_total(Loyalty_Card card) {
		/*
		 * Use this method if family members wants to have a card of its own
		 */
		
		Integer id_int = Integer.valueOf(card.Get_ID());
		if(Super_market.card_members.containsKey(id_int)) {
			Integer current_index = Super_market.card_members.get(id_int);
			Super_market.card_members.put(id_int,++current_index); // do not use current_index, other current_index will be added and than encremented. 
		}else {
			System.out.println("The client is not yet in the database, creating a new Loyalty_card.");
			add_client(card);
		}
	}
	
	public int AssociatedMembers_ToCard(Loyalty_Card card) {
		Integer id_int = Integer.valueOf(card.Get_ID());
		return Super_market.card_members.get(id_int);
		
	}
	
	/*
	 * Checks if card is in the List, in case it is not , allows redeem and 
	 * and the card to the List. Note that the current available points 
	 * are checked with the public boolean checkout_with_points(double bill)
	 * method of the Loyalty_Card class
	 */
	public boolean allow_redeem(Loyalty_Card card) {
		if(Super_market.data_base.containsValue(card)) {
			return false;
		}else {
			return true;
		}
	}
	
	

}
