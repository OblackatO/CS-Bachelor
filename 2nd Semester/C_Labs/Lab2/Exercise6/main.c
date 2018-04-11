/*
 * main.c
 *
 *  Created on: Mar 1, 2018
 *      Author: pedrogomes
 */

#include <stdio.h>
#include "swap.h"

int main() {

	int n, n1, result;

	printf("Enter a number:");
	scanf("%d", &n);

	printf("\nEnter a second number:");
	scanf("%d", &n1);

	printf("\nValues before swap: \n n:%d \n n1:%d",n,n1);
	if (swap_values(n,n1) == 0)  {
		printf("\nValues after swap: \n n:%d \n n1:%d",n,n1);

	}
	return 0;
}
