package exercice3;

public class Wolf extends Creature{

	private final String name = "Wolf";
	private int legs;
	private String eyes_color;
	
	public Wolf(int health, int legs, String eyes_color) {
		
		super(health);
		this.legs = legs;
		this.eyes_color = eyes_color;
	}
	
	protected String body_format() {
		return "\n"+"Total number of legs"+this.legs+"\n"+"Eyes color:"+this.eyes_color+"\n";
	} 
	
	public String Get_Name() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return Get_Name()+body_format();
	}
}
