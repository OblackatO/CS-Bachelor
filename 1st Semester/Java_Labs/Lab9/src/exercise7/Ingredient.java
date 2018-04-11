package exercise7;

public class Ingredient {
	
	private String name; 
	private double quantity;
	private Units unit;
	
	public Ingredient(String name, double quantity, Units unit) {
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Units getUnit() {
		return unit;
	}

	public void setUnit(Units unit) {
		this.unit = unit;
	}
	
	@Override
	public int hashCode() {
		return (this.name.hashCode() | (int)this.quantity | this.unit.hashCode());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
			
		if(!(obj instanceof Ingredient)) {
				return false;
		}
			
		Ingredient s = (Ingredient) obj;
		return (s.getName().equals(this.getName()));
	}
}

