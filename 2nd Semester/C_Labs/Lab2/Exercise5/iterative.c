/*
 * iterative.c
 *
 *  Created on: Mar 1, 2018
 *      Author: pedrogomes
 */
#include "iterative.h"

long iterative_factorial(int n) {

    long final_result = 1;

    while(n > 1) {
        final_result = final_result * n;
        n--;
    }
    return final_result;
}
