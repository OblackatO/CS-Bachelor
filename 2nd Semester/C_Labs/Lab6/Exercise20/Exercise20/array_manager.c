//
//  array_manager.c
//  Exercise20
//
//  Created by Pedro Gomes  on 29/03/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

#include <stdio.h>
#include <time.h>
#include <stdlib.h>
//#include <stdio.h>

void fill_array(int *array1, int array_size) {
    
    for(int i=0; i<array_size; i++) {
       *(array1 + i) = rand() % 100;
    }
}

void printf_array(int *array1, int array_size) {
    
    printf("[");
    for(int i=0; i<array_size;i++) {
        printf("%d",*(array1 + i));
        if(i != array_size-1) {
            printf(", ");
        }
        
    }
    printf("]");
    
}
