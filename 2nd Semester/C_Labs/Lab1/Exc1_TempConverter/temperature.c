#include "temperature.h"


Temperature toFahrenheit(Temperature celsius) {
	return (celsius/(5.0/9))+32;
}

Temperature toCelsius(Temperature fahrenheit) {
	return (5.0/9) * (fahrenheit-32);
}

