package exercise2;

public class Launcher {

	public static void main(String[] args) {
		

		//Creates two Ships, Startfleet and Klingon
		Starfleet_Ship starfleet_object = new Starfleet_Ship("TR-064", 100, 100, 250, 1, 30);
		Klingon_Ship klingon_object = new Klingon_Ship("OrakaTokar", 115, 85, 20, 260);
		
		//Klingon_Ship attacks Starfleet and Starfleet responds
		System.out.println("Klingons preparing attack.");
		klingon_object.attack(starfleet_object, 15);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("Exiting game...");
			System.exit(1);
		}
		
		System.out.println("StarFleet is getting ready to respond...");
		starfleet_object.attack(klingon_object, 17);
		
		System.out.println("Current status of both ships:");
		System.out.println("Starfleet:"+starfleet_object.getName());
		System.out.println("Power of shield:"+starfleet_object.get_Shield_power());
		System.out.println("Energy remaining:"+starfleet_object.getEnergy());
		System.out.println("\n"+"Klingon:"+klingon_object.getName());
		System.out.println("Power of shield:"+klingon_object.get_Shield_power());
		System.out.println("Energy remaining:"+klingon_object.getEnergy()+"\n");
		
		//Klingon sets cloak and starfleet tries to attack again
		klingon_object.cloak_on_off(true);
		
		starfleet_object.attack(klingon_object, 20);
		
		//Starfleet uses moteur sporique to uncloak Klingon ship
		if(starfleet_object.moteur_sporique(klingon_object.getCloak_power())) {
			klingon_object.cloak_on_off(false);
			System.out.println("Trying to uncloak the ship");
			
			try {
				Thread.sleep(5000);
			}catch(InterruptedException e) {
				System.out.println("Exiting game...");
				System.exit(1);
			}
			
			System.out.println("Ship uncloaked, attack !");
			starfleet_object.attack(klingon_object, 50);
			System.out.println("Energy of klingon_ship:"+klingon_object.get_Shield_power());
		}else {
			System.out.println("Moteur sporique has no more energy left or not enough");
		}
		
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			System.out.println("Exiting game...");
			System.exit(1);
		}
		
		//klingon ship gets repaired and also gets more energy from crystal
		Outposts repairing_station = new Outposts("Station-Spacex", 80, 500,60);
		Crystal crystal_consumable = new Crystal("Crystal_or",3,100,30);
		klingon_object.repair_machine(repairing_station);
		klingon_object.Add_energy_power(crystal_consumable);
		
		System.out.println("\n"+"New status of klingon ship:");
		System.out.println("\n"+"Klingon:"+klingon_object.getName());
		System.out.println("Power of shield:"+klingon_object.get_Shield_power());
		System.out.println("Energy remaining:"+klingon_object.getEnergy()+"\n");
		
		//klingon ships itself for mistake
		klingon_object.attack(klingon_object, 50);
		
		//More Klingon ships arrive and completely destroy StarfleetShip before it can escape
		Klingon_Ship klingon_object2 = new Klingon_Ship("OrakaTJiar", 115, 85, 20, 100);
		Klingon_Ship klingon_object3 = new Klingon_Ship("OrakaTPytar", 115, 85, 20, 400);
		
		klingon_object2.attack(starfleet_object, 30);
		System.out.println(starfleet_object.getName()+" under attack");
		System.out.println("Shield power:"+starfleet_object.get_Shield_power());
		klingon_object3.attack(starfleet_object, 40);
		System.out.println("Shield power:"+starfleet_object.get_Shield_power());
		klingon_object.attack(starfleet_object, 30);
		klingon_object.attack(starfleet_object, 10);
		
		System.out.println("\n"+"Klingon ships are moving away...");
		klingon_object = null;
		klingon_object2 = null;
		klingon_object3 = null;
		
		//Starfleet ship repairs
		Outposts repair_station = new Outposts("\n"+"Station NASA", 100, 600,60);
		crystal_consumable = new Crystal("Cystal_or",3,5,60);
		starfleet_object.repair_machine(repair_station);
		starfleet_object.Add_energy_power(crystal_consumable);
		System.out.println("Starfleet ship"+starfleet_object.getName()+" has been repaired.");
		System.out.println("Starfleet ship"+starfleet_object.getName()+"new status:");
		System.out.println("Shield power:"+starfleet_object.get_Shield_power());
		System.out.println("Energy:"+starfleet_object.getEnergy());
			
	}
}


