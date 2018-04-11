package exercise3;

import java.util.*;

public class Set_ID {
	
	private static List <Integer> assigned_cards = new ArrayList<Integer>();
	private static Random generator = new Random(System.currentTimeMillis());
	
	public Set_ID(){};
	
	public int set_random_ID() {
		int generated_number = Set_ID.generator.nextInt(1000000);
		
		/*
		 * Does not let the System add repeated IDS and dynamically 
		 * creates a new using recursion.
		 */
		Integer Int_Obj = Integer.valueOf(generated_number);
		if(Set_ID.assigned_cards.contains(Int_Obj)) {
			return set_random_ID();
		}else {
			return generated_number;
		}
	}
	
	public void assign_existing_ID() {
		
	}

}
