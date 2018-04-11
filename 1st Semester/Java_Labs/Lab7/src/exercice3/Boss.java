package exercice3;

public class Boss extends Creature {
	
	private String name;
	private int legs, arms;
	
	public Boss(int health, String name, int legs, int arms) {
		super(health);
		this.legs = legs;
		this.arms = arms;
	}
	
	protected String body_format() {
		return "\n"+"Total number of legs"+this.legs+"\n"+"Total number of arms:"+this.arms+"\n";
	}
	
	public String Get_Name() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return "Boss name:"+Get_Name()+body_format();
	}
	

}
