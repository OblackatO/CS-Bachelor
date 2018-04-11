package exercise3;

public class Loyalty_Card {
	
	private int ID; 
	private double accumulated_points; 
	
	public Loyalty_Card(int ID) {
		this.ID = ID;
	}
		
	public void checkout(double bill) {
		double points = (10*bill)/100;
		this.accumulated_points += points;
	}
		
	public boolean checkout_with_points(double bill) {
		if(bill <= this.accumulated_points ) {
			this.accumulated_points -= bill;
			return true;
		}else {
			return false;
		}
	}
		
	public int Get_ID() {
		return this.ID;
	}
	
	public double Get_accumulated_points() {
		return this.accumulated_points;
	}
		
	@Override 
	public int hashCode() {
		return Get_ID();
	}
	
	@Override
	public boolean equals(Object object) {
		boolean flag; 
			
		Loyalty_Card card =  (Loyalty_Card) object;
		if (card == this) {
			flag = true;
			return flag;
		}else {
			return false;
		}
	}
}


