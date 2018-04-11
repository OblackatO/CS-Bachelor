package exercice3;

import java.util.Random;

public class Set_random_creatures {
	
	private Creature [] random_creatures = new Creature[5];
	Random generator = new Random(System.currentTimeMillis());
	
	int total_creatures = generator.nextInt(6); //total must be <=5 
	
	public Set_random_creatures() {
		for(Creature x : this.random_creatures) {
			Creature creature_object = new Wolf(12, 2, "green");
			x = creature_object;
		}Get_Random_Creatures();
	}
	
	public Creature [] Get_Random_Creatures() {
		return this.random_creatures;
	}
}
	
	
