package exercice3;

public class Pilot extends Person {

	String airline;
	
	Pilot(String name, String passportNumber, String airline) {
		super(name, passportNumber); 
		this.airline = airline;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}
	
	@Override
	public String toString() {
		return "\n"+"name:"+super.getName()+"\n"+"Airline:"+this.airline;
	}

}
