package exercise2;

import java.util.*;

public abstract class Ship implements Attackable, Repairable {
	
	static Random generator = new Random(System.currentTimeMillis());
	private String name;
	private int energy; 
	protected int shield_power;
	
	public Ship(String name, int energy, int shield_power) {
		
		this.name = name;
		this.shield_power = shield_power;
		this.energy = energy;
		
	}
	
	public String getName() {
		return name;
	}

	public int getEnergy() {
		return energy;
	}
	
	public int get_Shield_power() {
		return this.shield_power;
	}
	
	public void reduce_energy(int amount) {
		this.energy -= amount;
	}
	
	@Override 
	public int hashCode() {
		return (this.name.hashCode() | generator.nextInt(300));
	}
	
	
	@Override 
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if(!(obj instanceof Ship)) {
			return false;
		}
		
		Ship s = (Ship) obj;
		return (s.getName().equals(this.getName()));
	}
	
	@Override
	public void Reduce_shield_power(int damage) {
		
		if (this.shield_power <= 0) {
			System.out.println("Ship:"+getName()+" is destroyed");
		}else {
			this.shield_power -=damage;
		}
	}
	
	@Override 
	public void Add_shield_power(int hp) {
		this.shield_power = hp;
	}
	
	public void attack(Attackable attackable_object, int damage) {
		
		/*
		 * I'm not sure if this is right. It works fine, but
		 * I'm using the equals method on an attackable object and not in a Ship object
		 * so the question is, if I use the equals method in a Ship object that implements 
		 * attackable, which equals method is used ? The one I overwrite here in the Ship class
		 * or the default one of the Attackable interface ? As I said said, it worked fine in the 
		 * Launcher, so I think it uses the one I overwrote, but even if it does I do not 
		 * see exactly how and why. : Question answered by professor. 
		 */
		
		if(attackable_object.equals(this)) {
			System.out.println("Auto-Defense system activated. Cannot choose your own ship as a target, or not enough energy.");
		}
		
		if(this.energy < 0) {
			System.out.println("Not enough energy.");
		}
		
		if(!(attackable_object.equals(this) && this.energy <0 )) {
			attackable_object.Reduce_shield_power(damage);
			this.energy -=damage;
		}
		
		
		
	}
	
	public void Add_energy_power(Consumable product_to_consume) {
		//Note that the total energy of a ship can always increase, if more crystals are used. 
		if(product_to_consume.give_energy() == 0) {
			System.out.println("Crystal is destroyed or has no more energy.");
		}else {
			this.energy +=product_to_consume.give_energy();
		}
	}
	
	@Override
	public void repair_machine(Outposts repair_station) {
		Add_shield_power(repair_station.repair_shield());
	}
}
