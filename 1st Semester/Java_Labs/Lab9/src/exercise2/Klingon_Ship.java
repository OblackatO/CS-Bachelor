package exercise2;

public class Klingon_Ship extends Ship {
	
	private int cloak_power;
	private int total_klingons;
	private boolean cloak; 
	
	public Klingon_Ship(String name, int energy, int shield_power, int cloak_power, int total_klingons) {
		
		super(name, energy, shield_power);
		this.cloak_power = cloak_power;
		this.total_klingons = total_klingons;
		
	}

	public int getCloak_power() {
		return cloak_power;
	}

	public void setCloak_power(int cloak_power) {
		this.cloak_power = cloak_power;
	}

	public int getTotal_klingons() {
		return total_klingons;
	}

	public void setTotal_klingons(int total_klingons) {
		this.total_klingons = total_klingons;
	}
	
	public void cloak_on_off(boolean value) {
		this.cloak = value;
	}
	
	public boolean get_cloak_value() {
		return this.cloak;
	}
	
	@Override 
	public void Reduce_shield_power(int damage) {
		
		if (this.shield_power <= 0) {
			System.out.println("Ship:"+getName()+"is destroyed");
		}else if(get_cloak_value()) {
			System.out.println("Target coordinates are cloaked. Ship is cloaked.");
		}else {
			this.shield_power -=damage;
		}
	}
}
