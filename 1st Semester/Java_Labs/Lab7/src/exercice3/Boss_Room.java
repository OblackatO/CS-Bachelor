package exercice3;

public class Boss_Room extends Room{
	
	private Creature boss_creature; //
	
	public Boss_Room(Door room_door, Creature boss_creature) {
		super(room_door);
		
		this.boss_creature = boss_creature;
	}
	
	public Creature Get_Creature() {
		return this.boss_creature;
	}
	
	
}

