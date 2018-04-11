package exercice3;

public class Laucnher {

	public static void main(String[] args) {
		
		//Creates a player 
		Player player_object = new Player(60, 2, 2);
		
		
		//Creates random creatures for rooms
		Set_random_creatures random_object = new Set_random_creatures();
		Creature [] random_creatures  = random_object.Get_Random_Creatures();
		
		//Creates Doors for rooms
		Door_normal normal_door = new Door_normal();
		
		//Creates a Normal_Room
		Room room_object = new Normal_Room(normal_door, random_creatures);
		
		boolean rooms_yet = true;
		
		while(rooms_yet) {
			if(room_object == null) {
				/*
				 * If room_object is null no rooms are available and the CPU has 
				 * arrived at the end of the quest. See next_random_room() on the Room class
				 * for more details
				 */
				
				/*
				 * GOT java.lang.NullPointerException exception, meaning the while does not break in time. 
				 * Cannot see why. I had to use the break keyword to make it work. 
				 */
				//rooms_yet = false;
				
				break;
			}
			
			if(room_object.Get_Door().isDoorOpen()) {
				/*
				 * If player is in a normal room he moves to the next random room without
				 * killing any wolves
				 */
				System.out.println("\n"+"Door is opened."+player_object.Get_Name()+" is moving to the next random room.");
				System.out.println("Total rooms left:"+room_object.Get_total_rooms());
				room_object = room_object.next_random_room();
				try {
					Thread.sleep(1000);
				}catch (InterruptedException ex) {
					System.out.println("Exception handled");
					System.exit(1);
				}
			
			}else {
				/*
				 * If player is in a boss room he kills the boss, the door is opened and 
				 * the player moves to the next random room. Please note that there is not a condition 
				 * comparing if the boss is dead or not and if the door is open or not. I first check 
				 * if the door is opened, if it isn't it is because a Boss is there and he has to be killed
				 * so the player can continue his quest
				 */
				System.out.println("\n"+"Battle between you and boss has started.");
				System.out.println("When the Boss is dead you can move the next room.");
				player_object.kill(room_object.Get_Creature());
				room_object = room_object.next_random_room();
				System.out.println("Boss is killed. Moving to the next random room.");
				try {
					Thread.sleep(1000);
				}catch (InterruptedException ex) {
					System.out.println("Exception handled");
					System.exit(1);
				}
			}
		}
	}
}
