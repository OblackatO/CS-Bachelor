//
//  array_manager.c
//  Exercise18
//
//  Created by Pedro Gomes  on 22/03/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

#include "array_manager.h"
#include <ctype.h>

int count_chars(char array1[], int SIZE) {
    
    int total_chars = 0;
    for(int i=0; i<=SIZE-1; i++) {
        
        if(islower(*(array1 + i)) || isupper(*(array1 + i))){
            total_chars++;
        }
    }
    return total_chars;
}

void replace_char(char array[], int SIZE, char n, char x) {
    
    for(int i=0; i<=SIZE-1; i++) {
        if(*(array + i) == n) {
            if (islower(*(array + i))) {
                *(array + i) = tolower(x);
            }else {
                *(array + i) = toupper(x);
            }
        }
    }
}

void replace_vowels(char array[], int SIZE, char vowel) {
    
    char vowels[] = "aeiou";
    
    for(int i=0; i<=SIZE-1; i++) {
        for(int i1=0; i1<=sizeof(vowels)/sizeof(vowels[0]); i1++) {
            
            if(*(array + i) == *(vowels + i1)) {
                *(array + i) = vowel;
            }
        }
    }
}
