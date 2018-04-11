package exercice4;

import java.util.Random;

public class Testing_purposes {

	public static void main(String[] args) {
		int array1  [] = new int [100];
		Random generator = new Random(System.currentTimeMillis());
		
		for(int ti=0; ti<=array1.length-1; ti++) {
			array1[ti] = generator.nextInt(101);
		}
		
		int element_to_search = array1[56];
		
		int min = 0;
		int max = array1.length-1;
		boolean found = false;
	
		while((min <= max) && (!found)) {
    		
			int pivot = array1[(min+max)/2];
			
    			if(pivot==element_to_search) {
				System.out.println("Element:"+element_to_search+" is the array.");
				found = true;
			}else if(pivot>element_to_search) {
				max = pivot-1;
			}else if(pivot<element_to_search) {
				min = pivot+1;
			}
		}
	}
}
