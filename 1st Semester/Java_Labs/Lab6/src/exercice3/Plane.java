package exercice3;

public class Plane {
	
	private String name;
	private int max_passengers;
	
	Plane(String name, int max_passengers) {
		this.name = name;
		this.max_passengers = max_passengers;
	}
	
	public int get_maxpassengers() {
		return this.max_passengers;
	}
	
	public String get_name() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "\n"+this.name+"\n"+"Maximum passengers:"+ this.max_passengers;
	}
	
	
}

