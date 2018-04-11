#include <stdio.h>
#include "temperature.h"
//#define float Temperature;

int main() {

	//printf("Hello world\n2nd hello world");
	printf("74°F to Celsius: %.2f", toCelsius(74.0));
	printf("\n24°C to Fahrenheit: %.2f", toFahrenheit(24.0));
	return 0;

}

