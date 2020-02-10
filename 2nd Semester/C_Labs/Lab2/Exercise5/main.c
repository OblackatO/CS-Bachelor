/*
 * main.c
 *
 *  Created on: Mar 1, 2018
 *      Author: pedrogomes
 */

#include <stdio.h>
#include "iterative.h"
#include "recursive.h"

int main(int argc, const char * argv[]) {

    int n = -1;

    while(n < 0) {
        printf("Enter a number:");
        scanf("%d", &n);
    }

    printf("\nFactorial of number %d in iterative way:", n);
    printf("%lu", iterative_factorial(n));

    printf("\nFactorial of number %d in recursive way:", n);
    printf("%lu", recursive_factorial(n));
    printf("\n");

    return 0;

}
