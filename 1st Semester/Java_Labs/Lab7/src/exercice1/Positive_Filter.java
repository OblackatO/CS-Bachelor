package exercice1;

public class Positive_Filter extends Filter{
	
	private int[] final_array;
	
	Positive_Filter(int[] set_of_numbers){
		super(set_of_numbers);
	}
	
	public int [] Get_Positive_Array() {
		return this.final_array;
	}
	
	public int [] Positive_Numbers() {
		boolean array_created = false;
		int [] set_of_numbers = Get_Set_Numbers();
		this.final_array = new int [set_of_numbers.length];
		int current_positive_number=0;
		
		for(int ti=0; ti<=set_of_numbers.length-1; ti++) {
			if(set_of_numbers[ti] >= 0) {
				array_created = true;
				this.final_array[current_positive_number] = set_of_numbers[ti]; 
				current_positive_number++;
			}
		}
		
		if(array_created) {
			return Get_Positive_Array();
		}else {
			return null;
		}
	}
	
	@Override 
	public String toString() {
		return "Use the Positive_Numbers()  to get all positive numbers in the specified array";
	}
}
