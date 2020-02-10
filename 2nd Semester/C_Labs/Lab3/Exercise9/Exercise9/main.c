x//
//  main.c
//  Exercise1
//
//  Created by Pedro Gomes  on 08/03/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

char array_alphabet[26] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z' };

int array_alphabet_index[26];
int c;
char buffer;
char file_path[200];
char current_char;

int main(int argc, const char * argv[]) {
    
    for(int i = 0; i <= 25; i++) {
        array_alphabet_index[i] = 0;
    }
    
    printf("Write file path or \'l\' to enter letter, and press enter:");
    scanf("%s", file_path);
    while((buffer = getchar()) != EOF && buffer != '\n');
    
    
    if (*file_path == 'l') {
        while(current_char != '1') {
            printf("Enter char:");
            scanf("%c", &current_char);
            printf("This is the input char: %c", current_char);
            for(int i=0; i<=25; i++) {
                if (array_alphabet[i] == current_char) {
                    printf("got char");
                    array_alphabet_index[i] += 1;
                }
            }
            while((buffer = getchar()) != EOF && buffer != '\n');
        }
        
    }else {
        printf("\nthis is the current file path: %s",file_path);
        FILE *fp;
        fp = fopen(file_path, "r");
        
        if(fp) {
            while((c = getc(fp)) != EOF) {
                //printf("\nThis is the current char: %c", c);
                for(int i=0; i<=25; i++) {
                    if (array_alphabet[i] == c) {
                        array_alphabet_index[i] += 1;
                    }
                }
            }
            fclose(fp);
        }
    }
    
    for(int i = 0; i<=25; i++) {
        if (array_alphabet_index[i] != 0) {
            printf("\nNumber of chars of the letter: %c : %d", array_alphabet[i], array_alphabet_index[i]);
        }
    }
    printf("\n");
    return 0;
}




