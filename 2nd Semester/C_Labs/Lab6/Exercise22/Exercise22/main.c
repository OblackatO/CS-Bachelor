//
//  main.c
//  Exercise22
//
//  Created by Pedro Gomes  on 29/03/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(int argc, const char * argv[]) {
    
    char *string_array1_pointer;
    string_array1_pointer = calloc(0,sizeof(char));
    char *string_array_temp;
    string_array_temp = calloc(0,sizeof(char));
    
    char c;
    int i=0;
    
    while(1) {
        printf("Input string:\n");
        while((c = getchar()) != '\n' && c != EOF){
            *(string_array_temp + i++) = c;
            string_array1_pointer = realloc(string_array1_pointer, i*sizeof(char));
            string_array_temp = realloc(string_array_temp, i*sizeof(char));
            
        }
        i=0;
        
        if (strcmp(string_array_temp, "END") == 0) {
            break;
        }else {
            string_array1_pointer = realloc(string_array1_pointer, strlen(string_array1_pointer)+1);
            strcat(string_array1_pointer, " ");
            strcat(string_array1_pointer, string_array_temp);
            free(string_array_temp);
            string_array_temp = calloc(0,sizeof(char));
        }
    }
    
    printf("\nThe string you input string:%s\n", string_array1_pointer);
    free(string_array1_pointer);
    
    return 0;
}
