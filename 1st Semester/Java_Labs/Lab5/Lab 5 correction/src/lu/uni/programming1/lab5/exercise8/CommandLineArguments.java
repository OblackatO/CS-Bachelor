package lu.uni.programming1.lab5.exercise8;

public class CommandLineArguments {

	public static void main(String[] args) {
		int number, sum = 0;
		for (String arg : args) {
			number = Integer.parseInt(arg);
			sum += number;
			System.out.println(number);
		}
		System.out.println("--------\nSum: " + sum);
	}
}