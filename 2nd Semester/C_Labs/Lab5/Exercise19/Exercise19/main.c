//
//  main.c
//  Exercise19
//
//  Created by Pedro Gomes  on 22/03/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

#include <stdio.h>
#include "string_manager.h"
#define MAX_SIZE 254

int main(int argc, const char * argv[]) {
    
    char string1[MAX_SIZE], string2[MAX_SIZE];
    
    printf("1st string:");
    //scanf("%s", &string1);
    mygets(string1, MAX_SIZE);
    printf("2nd string:");
    mygets(string2, MAX_SIZE);
    //scanf("%s", &string2);
    
    //mygets(string1, MAX_SIZE);
    //mygets(string2, MAX_SIZE);
    
    printf("\nComparing strings using both approaches...\n");
    printf("Using pointer notion:%d\n", compare_string_pointer(string1, string2));
    printf("Using subscript notion:%d", compare_string_subscript(string1, string2));
    
    printf("\n");
    return 0;
}
