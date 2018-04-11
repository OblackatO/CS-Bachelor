package exercise2;

public class Outposts extends Item implements Attackable{
	
	private int power_to_give = 100;
	
	public Outposts(String name, int height, int weight) {
		super(name, height, weight);
	}
	
	
	public int repair_shield() {
		
		return this.power_to_give; //default value of maximum shield power
		
	}
	
	@Override
	public void Reduce_shield_power(int damage) {
		System.out.println("Outpost destroyed.");
		this.power_to_give = 0;
	}
	
	@Override
	public void Add_shield_power(int hp) {}	
	
	
	
	

}
