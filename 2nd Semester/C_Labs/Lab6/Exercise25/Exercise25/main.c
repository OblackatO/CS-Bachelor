//
//  main.c
//  Exercise25
//
//  Created by Pedro Gomes  on 30/03/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>

int main(int argc, const char * argv[]) {
    
    
    /*
     After watching Apple wwdc 2015 as stated in the exercise I turned on addresse sanitizer on xcode.
     */
    
    
    //creating buffer over flow.
    char string_array[3];
    printf("Input a string > 3 chars:");
    scanf("%s", string_array);
    
    
    //creating dangling pointer
    char *string_array2;
    string_array2 = malloc(4*sizeof(char));
    free(string_array2);
    string_array2 = "dangling pointer";
    
    
    
    return 0;
}
