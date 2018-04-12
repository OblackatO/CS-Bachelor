//
//  main.c
//  Exercise20
//
//  Created by Pedro Gomes  on 29/03/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "array_manager.h"

int main(int argc, const char * argv[]) {
    
    int array1[0];
    int *array1_pointer = array1;
    int array_size;
    
    printf("Input size of the array:\n");
    scanf("%d", &array_size);
    
    array1_pointer = calloc(array_size, sizeof(int));
    if (array1_pointer == NULL) {
        printf("Problem allocation size to array.\n");
        exit(1);
    }
    
    fill_array(array1_pointer, array_size);
    printf_array(array1_pointer, array_size);
    free(array1_pointer);
    printf("\n");
    
    char string_array1[255];
    char string_array2[0];
    char *string_array2_pointer = string_array2;
    
    printf("Input a string:\n");
    scanf("%s", string_array1);
    
    string_array2_pointer = calloc(strlen(string_array1)*2+1, sizeof(char)); //Where +1 is for the \0
    strcat(string_array2_pointer, string_array1);
    strcat(string_array2_pointer, string_array1);
    printf("Original:%s\n",string_array1);
    printf("Double:%s\n", string_array2_pointer);
    free(string_array2_pointer);
    
    return 0;
}
