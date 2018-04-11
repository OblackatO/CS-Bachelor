package exercice3;

public class Player extends Creature{

	private final String name = "Player";
	private int legs, arms;
	
	public Player(int health, int legs, int arms) {
		
		super(health);
		this.legs = legs;
		this.arms = arms;
	}
	
	protected String body_format() {
		return "\n"+"Number of legs"+this.legs+"\n"+"Number of arms:"+this.arms+"\n";
	} 
	
	public String Get_Name() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return Get_Name()+body_format();
	}
}
