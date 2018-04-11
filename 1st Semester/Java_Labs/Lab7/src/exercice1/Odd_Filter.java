package exercice1;

public class Odd_Filter extends Filter{
	
	private int[] final_array;
	
	Odd_Filter(int[] set_of_numbers){
		super(set_of_numbers);
	}
	
	public int[] Get_Odd_Array() {
		return this.final_array;
	}
	
	public int[] Get_odd_numbers() {
		int [] set_of_numbers = Get_Set_Numbers();
		this.final_array = new int [set_of_numbers.length];
		int current_odd_number=0;
		
		for(int ti=0; ti<=set_of_numbers.length-1; ti++) {
			if(set_of_numbers[ti]%2 != 0) {
				this.final_array[current_odd_number] = set_of_numbers[ti];
				current_odd_number++;
			}
		}
		
		if(this.final_array != null) {
			return Get_Odd_Array();
		}else {
			return null;
		}
	}
	
	
	@Override 
	public String toString() {
		return "Use the method Get_odd_numbers() to extract odd numbers from the specified array.";
	}

}




