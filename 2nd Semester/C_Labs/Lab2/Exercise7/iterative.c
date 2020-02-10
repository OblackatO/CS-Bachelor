//
//  iterative.c
//  Exercise7
//
//  Created by Pedro Gomes  on 01/03/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

#include <stdio.h>
#include "Calculations_Functions.h"
long iterative_factorial(int n) {
    
    long final_result = 1;
    
    while(n > 1) {
        final_result = final_result * n;
        n--;
    }
    return final_result;
}
