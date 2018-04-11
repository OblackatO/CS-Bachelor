package exercise4;

public class exceptions {
	
	/*
	 * (1°)
	 * 
	 * The exception thrown by the Integer.parseInt() method is NumberFormatException. 
	 * I think it is an unchecked exception because when compiling the program we haven't got an error 
	 * but only if the user passes letters as arguments. This means that for instance, if a user writes 
	 * "123 14 hello" the program will run anyway, but in the hello word the NumberFormatException will be 
	 * thrown. 
	 */
	
	//Code from correction
	public static void main(String[] args) {
		int number, sum = 0;
		boolean in_exception = false;
		
		for (String arg : args) {
			try {
				number = Integer.parseInt(arg);
				sum += number;
			}catch(NumberFormatException e) {
				System.out.println("Argument is not a number. Cannot convert to int.");
				System.out.println("Exception details:"+e);
				System.out.println("--------\nSum: " + sum);
				in_exception = true;
			}
		}
		if(!(in_exception)) {
			System.out.println("---All arguments are fine----\nSum: " + sum);
		}
	}
}
	


