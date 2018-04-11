package exercice3;

public abstract class Creature {

	private double health;
	
	public Creature(int health) {
		this.health = health;
	}
	
	public void Set_health(double value) {
		this.health = value;
	}
	
	public double Get_health() {
		return this.health;
	}
	
	public void kill(Creature creature ) {
		creature.Set_health(0);
		if( Get_health() == 0) {
			System.out.println(creature.Get_Name()+" is dead.");
		}
	}
	
	protected abstract String Get_Name();
	protected abstract String body_format();
	
	@Override
	public abstract String toString();
	
}
