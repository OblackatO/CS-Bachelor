package exercice3;

import java.util.Random;

public abstract class Room {
	
	public static Random generator = new Random(System.currentTimeMillis());
	private static int total_rooms = 10; //A game has 10 rooms in total
	private Door room_door; // door type
	
	public Room(Door door) {
		this.room_door = door;
		Room.total_rooms--;
	}
	
	//next random room
	public Room next_random_room() { 
		System.out.println("Im here!");
		if(Room.total_rooms == 0) {
			System.out.println("You just won CPU. No more rooms available");
			return null;
		}else {
			
			/*
			 * Consider that 1 is the Normal_Room and 2 is the Boss_Room
			 */
			int room = generator.nextInt(2-1+1)+1;
			if(room == 1) {
				Door normal_door = new Door_normal();
				Set_random_creatures random_object = new Set_random_creatures();
				Room room1 = new Normal_Room(normal_door, random_object.Get_Random_Creatures());
				return room1;
			}else{
				Creature boss_creature = new Boss(70, "Boss"+generator.nextInt(3000), generator.nextInt(50), generator.nextInt(60));
				Door boss_door = new Door_Boss(boss_creature);
				Room room2 = new Boss_Room(boss_door, boss_creature);
				return room2;
			}	
		}
	}
	
	public Door Get_Door() {
		return this.room_door;
	}
	
	public int Get_total_rooms() {
		return this.total_rooms;
	}
	
	public abstract Creature Get_Creature();
}
