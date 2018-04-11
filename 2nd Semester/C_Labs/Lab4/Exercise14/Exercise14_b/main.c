//
//  main.c
//  Exercise14_b
//
//  Created by Pedro Gomes  on 15/03/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

//
//  main.c
//  Exercise14
//
//  Created by Pedro Gomes  on 15/03/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

#include <stdio.h>

typedef int ARRAY_TYPE;
#define ARRAY_SIZE 15

int main(int argc, const char * argv[]) {
    
    ARRAY_TYPE array1[ARRAY_SIZE];
    
    int size_array = sizeof(array1)/sizeof(array1[0]);
    printf("size array %d", size_array);
    for(int i=0; i<size_array; i++) {
        int difference = (&array1[i+1] - &array1[i]) * sizeof(ARRAY_TYPE);
        
        printf("\nElement %d at %p   Distance to element %d: %d\n", i,&array1[i],i+1,difference);
        
    }
    
    return 0;
}
