package exercice1;

public class Less_Filter extends Filter{
	
	private int[] final_array;
	int number_to_check;
	
	Less_Filter(int[] set_of_numbers, int number_to_check){
		super(set_of_numbers);
		this.number_to_check = number_to_check;
	}
	
	public int [] Get_Less_Array() {
		return this.final_array;
	}
	
	public int [] Less_Numbers() {
		boolean array_created = false;
		int [] set_of_numbers = Get_Set_Numbers();
		this.final_array = new int [set_of_numbers.length];
		int current_less_number=0;
		
		for(int ti=0; ti<=set_of_numbers.length-1; ti++) {
			if(set_of_numbers[ti] < this.number_to_check) {
				array_created = true;
				this.final_array[current_less_number] = set_of_numbers[ti]; 
				current_less_number++;
			}
		}
		
		if(array_created) {
			return Get_Less_Array();
		}else {
			return null;
		}
	}
	
	@Override 
	public String toString() {
		return "Use the GreaterEqual_Numbers() to get all numbers which are equal of greater than the specified one";
	}
}



