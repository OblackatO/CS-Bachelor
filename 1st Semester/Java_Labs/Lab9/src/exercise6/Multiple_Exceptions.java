package exercise6;

public class Multiple_Exceptions {
	
	/*
	 * (1°) The code provided should give us an error because "Christian".length < 10 
	 * 
	 *  Array out of bound should pop as well because teachers.length == 3 (we start counting at 0) 
	 * 
	 */
	
	/*
	public static void main(String[] args) {
	 
		String[] teachers = new String[] { "Denis", "Steffen", "Gilles", "Christian" }; 
		int m = 4;
		int n = 10; 
		System.out.println(teachers[m].charAt(n));
	} 
	*/

	
	/*
	//2◦ Rewrite this code with a catch-block for each exception that might be thrown.
	public static void main(String[] args) {
		 
		String[] teachers = new String[] { "Denis", "Steffen", "Gilles", "Christian" }; 
		int m = 3;
		int n = 10; 
		
		try {
			System.out.println(teachers[m].charAt(n));
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("The length of the list is:"+(teachers.length-1));
		}catch(StringIndexOutOfBoundsException e) {
			System.out.println("String is not long enough.");
		}
	}
	*/
	
	/*
	//3◦ Rewrite this code with a single catch-block by benefiting from polymorphism. Hint: Lookup which common superclass the
	//exceptions caught in the previous step have.
	
	public static void main(String[] args) {
		 
		String[] teachers = new String[] { "Denis", "Steffen", "Gilles", "Christian" }; 
		int m = 4;
		int n = 10; 
		
		try {
			System.out.println(teachers[m].charAt(n));
		}catch(Exception  e){
			System.out.println("Something went wrong.");
			
		}
	}
	*/
	
	/*
	//4◦ Rewrite this code with the same set of different exceptions as in the second step, but in a single catch-block.
	public static void main(String[] args) {
		 
		String[] teachers = new String[] { "Denis", "Steffen", "Gilles", "Christian" }; 
		int m = 4;
		int n = 10; 
		
		try {
			System.out.println(teachers[m].charAt(n));
		}catch(StringIndexOutOfBoundsException |ArrayIndexOutOfBoundsException  e){
			System.out.println("Something went wrong.");
			System.out.println("Exceptions details:"+e);
			
		}
	}
	*/
}

