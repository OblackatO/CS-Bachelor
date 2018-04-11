package exercise2;

public class Starfleet_Ship extends Ship{
	
	int total_vulcains;
	int total_humans;
	int moteur_sporique_power;
	
	public Starfleet_Ship(String name, int energy, int shield_power, int total_humans, int total_vulcains, int moteur_sporique_power) {
		super(name, energy, shield_power);
		this.total_humans = total_humans;
		this.total_vulcains = total_vulcains;
		this.moteur_sporique_power = moteur_sporique_power;
	}
	
	public boolean moteur_sporique(int total_quantum_spins) {
		/*Used to instant teleportation of ships, faster than the "distorsion" 
		 * If the ships makes several jumps at once in a certain amount of coordinates 
		 * around a cloak ship that is sabotaged by inside detectors, the clocked ship 
		 * is discovered. Each cloaked ship requires a certain amount of jumps(spins)
		 * to be detected, if that amount is less than the available spins of the "moteur sporique" 
		 * than its cloak is broken. (Concept introduced in the latest Star trek Discovery, by Netflix)
		 */
		if(this.moteur_sporique_power >= total_quantum_spins) {
			return true;
		}else {
			return false;
		}
		
		/*
		 * Moteur sporique cannot be charged, at least not in my program. 
		 */
	}
	
	
	
	

}
