package exercice1;

public class Divisable extends Filter{
	
	private int[] final_array;
	int number_to_check;
	
	Divisable(int[] set_of_numbers, int number_to_check){
		super(set_of_numbers);
		this.number_to_check = number_to_check;
	}
	
	public int [] Get_Divisable_Array() {
		return this.final_array;
	}
	
	public int [] Divisable_Numbers() {
		boolean array_created = false;
		int [] set_of_numbers = Get_Set_Numbers();
		this.final_array = new int [set_of_numbers.length];
		int current_divisable_number=0;
		
		for(int ti=0; ti<=set_of_numbers.length-1; ti++) {
			if(set_of_numbers[ti]%this.number_to_check==0) {
				array_created = true;
				this.final_array[current_divisable_number] = set_of_numbers[ti]; 
				current_divisable_number++;
			}
		}
		
		if(array_created) {
			return Get_Divisable_Array();
		}else {
			return null;
		}
	}
	
	@Override 
	public String toString() {
		return "Use the Divisable_Numbers() to get all numbers which are divisable than the specified one";
	}
}


