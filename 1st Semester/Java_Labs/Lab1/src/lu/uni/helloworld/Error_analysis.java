package lu.uni.helloworld;

public class Error_analysis {

	public static void main(String[] args) {
		//1.syntax error, not commas in the variables and not ";" at the end, and two duplicate var 
		int a, b, c, d,f = 200; //corrected version
		//2.last parenthesis not needed : syntax error
		System.out.println((1+2)-3); //corrected version
		// 3.not int, 0.1 it's a double
		double e = 0.1; //corrected version : syntax error
		// 4.var f is not declared ! : syntax error, (or semantic ? idk)
		f = f + 1; 
		System.out.println(f);
	}
}
//I found more difficult to distingish between syntax and 
//semantic errors here, because eclipse detects semantic errors
//before compilation time, which does not happen when we run the program
//in the command line with an interpreter. 