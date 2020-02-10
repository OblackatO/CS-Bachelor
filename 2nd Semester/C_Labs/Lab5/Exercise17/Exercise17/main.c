//
//  main.c
//  Exercise17
//
//  Created by Pedro Gomes  on 22/03/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

#include <stdio.h>
#define ARRAY_SIZE 21


void print_array(int *array, int SIZE);
void applicable_post_pre(int *array, int SIZE);

void print_array(int *array, int SIZE) {
    
    printf("\n[");
    for(int i=0; i<=SIZE-1; i++) {
        if(i == SIZE-1) {
            printf("%d",*(array + i));
        }else {
            printf("%d,", *(array + i));
        }
    }
    printf("]");
}

void applicable_post_pre(int *array, int SIZE) {
    
    int sum=0;
    for(int i = 0; i<SIZE; i++) {
        
        sum += ++*array++;
    }
    printf("\nSum of array with conditions applied %d\n", sum);
}

int main(int argc, const char * argv[]) {
    
    int array1[ARRAY_SIZE];
    int *array_pointer;
    array_pointer = array1;
    
    for(int i = 0; i<=ARRAY_SIZE-1; i++) {
        
        if(i == 0) {
            *(array_pointer + i) = 1;
        }else {
            *(array_pointer + i) = i+1;
        }
    }
    
    printf("New formed array:\n");
    print_array(array1, ARRAY_SIZE);
    
    printf("\napplying conditions of incrementation...");
    applicable_post_pre(array1, ARRAY_SIZE);
    
    printf("\nNew array after incrementing:\n");
    print_array(array1, ARRAY_SIZE);
    
    printf("\n");
    return 0;
}
