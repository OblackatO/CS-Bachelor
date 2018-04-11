package Exercice8;

public class command_line_args {

	public static void main(String[] args) {
		int current_number=0; 
		double average =0 ;
		for(int ti=0;ti<=args.length-1;ti++) {
			current_number += Integer.parseInt(args[ti]);
		}
		average = current_number/args.length;
		System.out.println("the average is:"+average);
	}

}
