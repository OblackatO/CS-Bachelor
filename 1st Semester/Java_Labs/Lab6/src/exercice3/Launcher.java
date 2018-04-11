package exercice3;

import java.util.Random;

public class Launcher {

	public static void main(String[] args) {
		
		//Creates an origin and destination airport
		Airport origin = new Airport("NY", "USA", "0022");
		Airport destination = new Airport("Findel", "LU", "7862");
		
		//Creates array of planes available for a certain airline, in this case Luxair
		Plane[] plane_array = new Plane[50]; //50 available planes for Luxair
		Random generator = new Random(System.currentTimeMillis());
		for(int ti=0; ti<=plane_array.length-1; ti++) {
			int max_passengers = generator.nextInt(100);
			String plane_name = "Plane_number_"+Integer.toString(generator.nextInt(10000));
			plane_array[ti] = new Plane(plane_name, max_passengers);
		}
		
		//Creates a pilot for the flight 
		int passport_number = generator.nextInt(100000);
		String airline_name = "Luxair";
		Pilot captain = new Pilot("John virker", Integer.toString(passport_number), airline_name);
		
		//creating three passengers and adding them to the flight 
		//Passenger 1
		passport_number = generator.nextInt(100000);
		int loyaltycard = generator.nextInt(1000);
		Passenger passenger_object1 = new Passenger("Marshall", Integer.toString(passport_number), loyaltycard);
		//Passenger 2 
		passport_number = generator.nextInt(100000);
		loyaltycard = generator.nextInt(1000);
		Passenger passenger_object2 = new Passenger("Lilly", Integer.toString(passport_number), loyaltycard);
		 //Passenger 3
		passport_number = generator.nextInt(100000);
		loyaltycard = generator.nextInt(1000);
		Passenger passenger_object3 = new Passenger("Ted", Integer.toString(passport_number), loyaltycard);
		
		//Creates airline
		Airlines airline = new Airlines(plane_array, airline_name);
		
		//Creates Flight 
		int flight_number = generator.nextInt(100);
		Flight flight_object = new Flight(Integer.toString(flight_number), origin, destination, "22", "14:23:21", airline); 
		
		//Adding three passengers 
		flight_object.add_passenger(passenger_object1);
		flight_object.add_passenger(passenger_object2);
		flight_object.add_passenger(passenger_object3);
		
		//Adding a Pilot
		flight_object.set_Pilot(captain);
		
		//Prints information about the flight 
		System.out.println(flight_object);
		
		

	}

}
