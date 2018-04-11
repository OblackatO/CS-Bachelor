//
//  main.c
//  Exercise21
//
//  Created by Pedro Gomes  on 29/03/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#define TRUE 1

int main(int argc, const char * argv[]) {
    
    int array1[0];
    int *array1_pointer = array1;
    
    //loop that frees mem
    /*
    while(TRUE) {
        array1_pointer = calloc(200, sizeof(int));
        free(array1_pointer);
    }
    */
    
    while(TRUE) {
        array1_pointer = calloc(200, sizeof(int));
        //free(array1_pointer);
    }
    
    
    return 0;
}
