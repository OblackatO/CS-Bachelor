/*
 * main.c
 *
 *  Created on: Mar 15, 2018
 *      Author: student
 */


#include <stdio.h>
#include <math.h>
#define TRUE 1
#define FALSE 0

int mysqrt (double number, double* result){

	if (number > 0){
		*result = sqrt(number);
		return 1;
	}else{
		return 0;
	}

}

int main() {

	double square_result=0;
	double scanned_number;


	while(1){

		printf("\nEnter a number:");
		scanf("%lf", &scanned_number);

		if (mysqrt(scanned_number, &square_result) == TRUE){
			printf("Sqrt of %0.1lf is: %.2lf\n", scanned_number,square_result);
			break;
		}else{
			printf("Number %0.1lf is invalid.\n",scanned_number);
		}

	}

	return 0;
}

