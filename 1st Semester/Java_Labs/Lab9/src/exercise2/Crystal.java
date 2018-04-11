package exercise2;

public class Crystal extends Item implements Consumable {
	
	private int amount_of_energy;
	
	public Crystal(String name, int height, int weight, int amount_of_energy) {
		super(name, height, weight);
		this.amount_of_energy = amount_of_energy;
	}
	
	@Override
	public int give_energy() {
		
		if(!(this.amount_of_energy <= 0 )) {
			return this.amount_of_energy;
		}else {
			return 0;
		}
	}
}
