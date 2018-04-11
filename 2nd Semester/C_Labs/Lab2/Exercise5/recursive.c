/*
 * recursive.c
 *
 *  Created on: Mar 1, 2018
 *      Author: pedrogomes
 */

#include "recursive.h"

long recursive_factorial(int n) {

    if (n == 0) {
        return 1;
    }
    return n * recursive_factorial(n-1);
}
