package exercice1;

import java.util.Random;
import java.util.Arrays;

public class Launcher {

	public static void main(String[] args) {
		// Creates postivie random array and use methods on it. 
		
		int[] positive_array = new int[50];
		Random generator = new Random(System.currentTimeMillis());
		int min = -50;
		int max = 50;
		
		for(int ti=0; ti<=positive_array.length-1; ti++) {
			positive_array[ti] = generator.nextInt(max-min+1)+min;
		}
		
		System.out.println("Passed array:"+Arrays.toString(positive_array));
		
		//Negative numbers method
		Negative_Filter nfilter_object = new Negative_Filter(positive_array);
		int [] result = nfilter_object.Negative_Numbers();
		if(result != null) {
			System.out.println("Negative numbers of array:");
			System.out.println(Arrays.toString(result));
		}else {
			System.out.println("No negative numbers of the specified array.");
		}
		
		//Positive numbers method
		Positive_Filter pfilter_object = new Positive_Filter(positive_array);
		result = pfilter_object.Positive_Numbers();
		if(result != null) {
			System.out.println("Positive numbers of array:");
			System.out.println(Arrays.toString(result));
		}else {
			System.out.println("No positive numbers of the specified array.");
		}
		
		//Divisable numbers 
		Divisable dfilter_object = new Divisable(positive_array, 4);
		result = dfilter_object.Divisable_Numbers();
		if(result != null) {
			System.out.println("Divisable numbers of the specified number:");
			System.out.println(Arrays.toString(result));
		}else {
			System.out.println("No divisable numbres on the array.");
		}
		
		//Greater Filter 
		Greater_Filter gfilter_object = new Greater_Filter(positive_array, 15);
		result = gfilter_object.GreaterEqual_Numbers();
		if(result != null) {
			System.out.println("Greater numbers than the specified number:");
			System.out.println(Arrays.toString(result));
		}else {
			System.out.println("No greater numbres on the array.");
		}
		
		//Less Filter
		Less_Filter lfilter_object = new Less_Filter(positive_array, 60);
		result = lfilter_object.Less_Numbers();
		if(result != null) {
			System.out.println("Lesser numbers than the specified number:");
			System.out.println(Arrays.toString(result));
		}else {
			System.out.println("No numbres smaller than the specified one, on the array.");
		}
		
		//Even Filter
		Even_Filter efilter_object = new Even_Filter(positive_array);
		result = efilter_object.Get_even_numbers();
		if(result != null) {
			System.out.println("Even numbers than the specified number:");
			System.out.println(Arrays.toString(result));
		}else {
			System.out.println("No even numbers on the array.");
		}
		
		//Odd Filter
		Odd_Filter ofilter_object = new Odd_Filter(positive_array);
		result = ofilter_object.Get_odd_numbers();
		if(result != null) {
			System.out.println("Odd numbers on the array:");
			System.out.println(Arrays.toString(result));
		}else {
			System.out.println("No odd numbers on the array.");
		}

	}

}
