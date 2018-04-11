package exercice1;



public abstract class Filter {
	
	private int[] set_of_numbers;
	
	Filter(int[] set_of_numbers){
		this.set_of_numbers = set_of_numbers;
	}
	
	public int[] Get_Set_Numbers() {
		return this.set_of_numbers;
	}
	
	
	
}

