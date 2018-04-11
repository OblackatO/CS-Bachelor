package exercice3;

import java.util.Random;

public class Normal_Room extends Room{
	
	/*
	 * Creature Array is used in case other creatures are added to the room apart from wolves
	 * in future versions
	 */
	private static Random generator = new Random(System.currentTimeMillis());
	private Creature [] room_creatures; 
	
	public Normal_Room(Door room_door, Creature [] room_creatures) {
		super(room_door);
		
		// maximum 5 wolves 
		if(room_creatures.length < 5) { 
			System.out.println("Maximum creatures per room: 5");
			System.exit(1);
		}else {
			this.room_creatures = room_creatures;
		}
	}
	
	public Creature [] Get_total_creatures() {
		return this.room_creatures;
	}
	
	public Creature Get_Creature() {
		return this.room_creatures[generator.nextInt(6)];
	}

}
