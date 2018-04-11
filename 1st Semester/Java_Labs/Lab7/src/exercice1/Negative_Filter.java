package exercice1;

public class Negative_Filter extends Filter{
	
	private int[] final_array;
	
	Negative_Filter(int[] set_of_numbers){
		super(set_of_numbers);
	}
	
	public int [] Get_Negative_Array() {
		return this.final_array;
	}
	
	public int [] Negative_Numbers() {
		boolean array_created = false;
		int [] set_of_numbers = Get_Set_Numbers();
		this.final_array = new int [set_of_numbers.length];
		int current_negative_number=0;
		
		for(int ti=0; ti<=set_of_numbers.length-1; ti++) {
			if(set_of_numbers[ti] < 0) {
				array_created = true;
				this.final_array[current_negative_number] = set_of_numbers[ti]; 
				current_negative_number++;
			}
		}
		
		if(array_created) {
			return Get_Negative_Array();
		}else {
			return null;
		}
	}
	
	@Override 
	public String toString() {
		return "Use the Negative_Numbers()  to get all negative numbers in the specified array";
	}
}



