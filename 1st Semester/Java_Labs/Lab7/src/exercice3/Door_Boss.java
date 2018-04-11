package exercice3;

public class Door_Boss extends Door{
	
	private Creature boss_creature;
	
	public Door_Boss(Creature creature){
		this.boss_creature = creature;
	}
	
	
	public boolean isDoorOpen() {
		if(this.boss_creature.Get_health() == 0) {
			return true;
		}else {
			return false;
		}
	}

}
