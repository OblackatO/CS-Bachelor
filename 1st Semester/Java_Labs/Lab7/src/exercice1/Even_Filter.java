package exercice1;

public class Even_Filter extends Filter{
	
	private int[] final_array;
	
	Even_Filter(int[] set_of_numbers){
		super(set_of_numbers);
	}
	
	public int[] Get_Even_Array() {
		return this.final_array;
	}
	
	public int[] Get_even_numbers() {
		boolean array_created=false;
		int [] set_of_numbers = Get_Set_Numbers();
		this.final_array = new int [set_of_numbers.length];
		int current_even_number=0;
		
		for(int ti=0; ti<=set_of_numbers.length-1; ti++) {
			if(set_of_numbers[ti]%2 == 0) {
				this.final_array[current_even_number] = set_of_numbers[ti];
				current_even_number++;
				array_created = true;
			}
		}
		
		if(array_created) {
			return Get_Even_Array();
		}else {
			return null;
		}
	}
	
	@Override 
	public String toString() {
		return "Use the method Get_even_numbers() to extract even numbers from the specified array.";
	}

}




