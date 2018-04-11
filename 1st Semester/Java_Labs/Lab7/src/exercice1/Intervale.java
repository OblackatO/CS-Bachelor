package exercice1;

public class Intervale extends Filter{
	
	private int[] final_array;
	int number_to_check;
	
	Intervale(int[] set_of_numbers, int number_to_check){
		super(set_of_numbers);
		this.number_to_check = number_to_check;
	}
	
	public int [] Get_Intervale_Array() {
		return this.final_array;
	}
	
	public int [] Intervale_Numbers() {
		boolean array_created = false;
		int [] set_of_numbers = Get_Set_Numbers();
		this.final_array = new int [set_of_numbers.length];
		int current_intervale_number=0;
		
		int max_count=0;
		for(int ti=0; ti<=set_of_numbers.length-1; ti++) {
			max_count++;
			if(max_count==this.number_to_check) {
				this.final_array[current_intervale_number] = set_of_numbers[ti]; 
				current_intervale_number++;
			}
		}
		
		if(array_created) {
			return Get_Intervale_Array();
		}else {
			return null;
		}
	}
	
	@Override 
	public String toString() {
		return "Use the Intervale_Numbers() to get all numbers of the specified interval.";
	}
}
