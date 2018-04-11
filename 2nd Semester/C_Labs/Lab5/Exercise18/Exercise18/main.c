//
//  main.c
//  Exercise18
//
//  Created by Pedro Gomes  on 22/03/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

#include <stdio.h>
#include "array_manager.h"

int main(int argc, const char * argv[]) {
    
    int buffer;
    
    char string_array[] = "Drei Chinesen mit dem Kontrabass sassen auf der Strasse und erzaehlten sich was.Da kam die Polizei, fragt: \"Was ist denn das?\" Drei Chinesen mit dem Kontrabass.\n";
    
    printf("Original string %s\n", string_array);
    
    char n,x = '\0';
    printf("Input two chars separated by a space. The 1st one to be replaced by the 2nd one in the initial string:\n");
   
    scanf("%c", &n);
    while((buffer = getchar()) != EOF && buffer != '\n') {
        scanf("%c", &x);
    }
    
    
    replace_char(string_array, sizeof(string_array)/sizeof(string_array[0]), n, x);
    printf("String with replaced chars:\n");
    printf("%s\n", string_array);
    
    char vowel;
    printf("Input a vowel, and all vowels of the string will be replaced with it:\n");
    scanf("%c", &vowel);
    replace_vowels(string_array, sizeof(string_array)/sizeof(string_array[0]) , vowel);
    printf("String with replaced vowels");
    printf("%s", string_array);
    
    printf("\n");
    return 0;
    
}

