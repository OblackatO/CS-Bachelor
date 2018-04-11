package lu.uni.helloworld;

import java.util.Scanner;

public class Hows_weather {

	public static void main(String[] args) {
		Double temp_celcius,temp_fahrenheit;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the temperature in celcius:");
		temp_celcius = scanner.nextDouble();
		scanner.close();
		temp_fahrenheit = (temp_celcius*(1.0*9/5)+32); //multiply by one to convert result into float and get right result of 1.8
		System.out.println("The temperature "+temp_celcius+"°C"+" is "+temp_fahrenheit+"F");
	}

}
