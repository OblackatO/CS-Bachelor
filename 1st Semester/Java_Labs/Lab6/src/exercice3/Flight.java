package exercice3;

import java.util.Calendar;

public class Flight {
	
	
	private static String  [][] scheduling = new String  [31][100]; 
	private static int total_passengers=0;
	private static Passenger[] passenger_array;
	private String number;
	private Airport origin, destination;
	private Pilot captain;
	private Airlines airline;
	private Plane current_plane;
	private String takeoff_day, takeoff_time;
	
	public Flight(String number, Airport origin, Airport destination, String takeoff_day, String takeoff_time,  Airlines airline) {
	
		if(verify_schedule_validity(takeoff_day, takeoff_time)) {
			set_scheduling(takeoff_day, takeoff_time);
		}
		
		this.number = number;
		this.origin = origin;
		this.destination = destination;
		this.airline = airline;
		this.airline.less1_plane();
		
		if(this.airline.set_plane() != null) {
			this.current_plane = this.airline.set_plane();
			set_passengers_array();
		}else {
			System.out.println("There are no more planes available for the airline:"+ this.airline.getName());
			System.exit(1);
		}
		
	}
	
	private boolean LeapYear(int year) {
		if((year%4 == 0) & (year%100 == 0) & (year%400 == 0)) {
			return true;
		}else if((year%4 == 0) & (year%100 == 0)) {
			return true;
		}else {
			return false;
		}
	}

	private boolean verify_schedule_validity(String takeoff_day, String takeoff_time) {
		
		int current_year = Calendar.getInstance().get(Calendar.YEAR);
		int current_month = Calendar.getInstance().get(Calendar.MONTH);
		
		boolean leap_year = LeapYear(current_year);
		int array_31_months[] =  {0,3,5,7,8,10,12};
		
		if((leap_year) & (current_month == 2)) {
			if(Integer.parseInt(takeoff_day) > 29) {
				System.out.println("Invalid day:"+takeoff_day+" for month:"+current_month);
				return false;
			}
		}
		
		boolean is31days = false ; 
		for(int ti=0; ti<=array_31_months.length-1; ti++) {
			if(array_31_months[ti] == current_month) {
				is31days = true;
			}
		}
		
		if(is31days) {
			if(Integer.parseInt(takeoff_day) > 31) {
				System.out.println("Invalid day:"+takeoff_day+" for month:"+current_month);
				return false;
			}
		}else if(!is31days) {
			if(Integer.parseInt(takeoff_day) > 30) {
				System.out.println("Invalid day:"+takeoff_day+" for month:"+current_month);
				return false;
			}
		}
		
		// Only 24 hour format is considered 
		String time_splited[] = new String[3];
		int hours, minutes, seconds; 
		
		time_splited = takeoff_time.split(":");
		hours = Integer.parseInt(time_splited[0]);
		minutes = Integer.parseInt(time_splited[1]);
		seconds = Integer.parseInt(time_splited[2]);
		
		
		// "< 25", because the 00 or 24 can be specified for midnight
		if((hours < 25) & (minutes < 60) & (seconds < 60)) {
			return true;
		}else {
			return false;
		}
	}
	
	private String set_scheduling(String takeoff_day, String takeoff_time) {
		
		boolean sche_set=false;
		for(int ti=0; ti<=scheduling[0].length-1; ti++) {
			if(scheduling[Integer.parseInt(takeoff_day)][ti] != takeoff_time) {
				scheduling[Integer.parseInt(takeoff_day)][ti] = takeoff_time;
				sche_set = true;
				return "[>] Scheduling has been set.";
			}
		}
		
		if(! sche_set) {
			System.out.println("There is already a flight on:"+ takeoff_day+" at "+takeoff_time);
			return null;
		}
		
		return null;
	}
		
	private void set_passengers_array() {
		passenger_array = new Passenger[this.current_plane.get_maxpassengers()];
	} 

	public void set_Pilot(Pilot captain) {
		if(captain.airline == this.airline.getName()) {
			this.captain  = captain;
		}else {
			System.out.println("The captain"+captain.getName()+" does not work for:"+this.airline.getName());
		}
	}
	
	public Pilot get_Pilot() {
		return this.captain;
	}
	
	public void add_passenger(Passenger passenger_object) {
		try {
			
			Flight.passenger_array[Flight.total_passengers] = passenger_object;
			Flight.total_passengers++;
			System.out.println("Sucessfully added passenger:"+passenger_object.getName());
			System.out.println("Passport number:"+passenger_object.getPassportNumber());
			
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("There are not available places in the plane:"+ this.current_plane);
			System.exit(1);
		}
	}
	
	public String getNumber() {
		return number;
	}

	public Airport getOrigin() {
		return origin;
	}

	public Airport getDestination() {
		return destination;
	}
	
	@Override
	public String toString() {
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH);
		
		return "From:"+ this.origin.getCity()+ "  --->  "+this.destination.getCity()+"\n"+ 
				"Departure date and time:"+ this.takeoff_day+"/"+Integer.toString(year)+"/"+Integer.toString(month)+"  "+this.takeoff_time+"\n"+
				"Airline:"+ this.airline.getName()+"\n"+
				"Plane:"+this.current_plane+"\n"+
				"Pilot:"+this.captain+"\n"+
				"Total passengers:"+Flight.total_passengers;
	}
}


