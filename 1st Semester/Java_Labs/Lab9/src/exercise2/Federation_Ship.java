package exercise2;

public class Federation_Ship extends Ship{
	
	int total_vulcains;
	int total_humans;
	int moteur_sporique;
	
	public Federation_Ship(String name, int energy, int shield_power, int sporique_spins, int total_humans, int total_vulcains) {
		super(name, energy, shield_power);
		this.total_humans = total_humans;
		this.total_vulcains = total_vulcains;
		this.moteur_sporique = sporique_spins;
	}
	
	public void attack(Attackable object_to_attack, int demage) {
		if(!(getEnergy()==0)) {
			object_to_attack.Reduce_shield_power(demage);
			reduce_energy(demage);
		}else {
			System.out.println("Captain Archer, we have no more energy.");
			System.out.println("T-pole needs to recharge the batteries !");
		}
	}
}
