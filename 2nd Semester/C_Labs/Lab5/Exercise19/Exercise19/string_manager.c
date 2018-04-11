//
//  string_manager.c
//  Exercise19
//
//  Created by Pedro Gomes  on 22/03/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

#include <stdio.h>
#include <string.h>

void mygets(char * s, int maxLength) {
    fflush(stdout);
    if(fgets(s, maxLength , stdin) != NULL) {
        size_t lastIndex = strlen(s)-1;
        if(s[lastIndex] == '\n') {
            s[lastIndex] = '\0';
        }
        
    }
}

int compare_string_pointer(char *s, char *s1) {
    int size1=0;
    int size2=0;
    
    for(int i=0; (*(s+i) != '\0'); i++) {
        size1++;
    }
    
    for(int i=0; (*(s1+i) != '\0'); i++) {
        size2++;
    }
    
    if(size1 < size2 ) {
        return -1;
    }else if(size1 > size2) {
        return 1;
    }else {
        return 0;
    }
}

int compare_string_subscript(char s[], char s1[]) {
    int size1=0;
    int size2=0;
    
    for(int i=0; (s[i] != '\0'); i++) {
        size1++;
    }
    
    for(int i=0; (s1[i] != '\0'); i++) {
        size2++;
    }
    
    if(size1 < size2 ) {
        return -1;
    }else if(size1 > size2) {
        return 1;
    }else {
        return 0;
    }
}
