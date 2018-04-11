package exercice1; // and exercice 2 

public class Fibon {
	
	public static int cache_array [] = new int[10000];
	
	public static int Fibon_recursive(int index) {
		if(index==0) {
			return 0;
		}else if(index==1 || index==2) {
			return 1;
		}else {
			return Fibon_recursive(index-1) + Fibon_recursive(index-2);
		}
	}
	
	//Fibonacci with mem
	public static int Fibon_recursive_mem(int index) {
		int fibcvalue;
		
		if(index==0) {
			return 0;
		}else if(index==1 || index==2) {
			return 1;
		}else if(cache_array[index]!=0) {
			return cache_array[index];
		}else {
			fibcvalue = Fibon_recursive_mem(index-1) + Fibon_recursive_mem(index-2);
			cache_array[index] = fibcvalue;
			return fibcvalue;
		}
	}
	
	public static void main(String[] args) {
		long current_time, current_timekl, final_time;
		
		current_time = System.nanoTime();
		System.out.println(Fibon_recursive(6)); // TRY TO put a high value here, worked fine with max 45
		current_timekl = System.nanoTime();
		final_time = current_time - current_timekl;
		System.out.println("The recursion without memoization took:"+final_time+" nano seconds.");
		
		current_time = System.nanoTime();
		System.out.println(Fibon_recursive_mem(6)); // TRY TO put a high value here, worked fine with max 45
		current_timekl = System.nanoTime();
		final_time = current_time - current_timekl;
		System.out.println("The recursion with memoization took:"+final_time+" nano seconds.");

	}

}
