//
//  main.c
//  Exercise15
//
//  Created by Pedro Gomes  on 22/03/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

#include <stdio.h>
#define ARRAY_SIZE 5

int main(int argc, const char * argv[]) {
    
    int array1[ARRAY_SIZE];
    int max_size = 0;
    int *array_pointer;
    array_pointer = array1;
    
    int scanned_int;
    printf("Enter a total of %d integers\n",ARRAY_SIZE);
    while(max_size <= ARRAY_SIZE) {
        printf("\nInteger %d", max_size+1);
        scanf("%d",&scanned_int);
        *(array_pointer + max_size) = scanned_int;
        max_size++;
    }
    
    printf("Your array:");
    printf("\n[");
    for(int i=0; i<=ARRAY_SIZE-1; i++) {
        printf("%d", *(array_pointer + i));
    }
    printf("]");
    
    return 0;
}
