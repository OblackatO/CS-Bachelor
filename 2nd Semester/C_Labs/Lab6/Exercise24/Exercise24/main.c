//
//  main.c
//  Exercise24
//
//  Created by Pedro Gomes  on 30/03/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

#include <stdio.h>
#include <string.h>

int main(int argc, const char * argv[]) {
    
    //string_array1 = "I just changed string number two"; // NOT ASSINGABLE.
    //printf("Here is the 2nd ")
    
    
    char *string_array = "hello, I can be changed.\n";
    char *string_array_pointer = string_array;
    char string_array1[] = "hello, this is a god damn constant string\n";
    
    printf("\nPrinting string enterily:\n");
    printf("not const string:%s",string_array);
    printf("const string:%s\n",string_array1);
    
    
    
    printf("\nPrinting string char by char, using pointer syntax.\n");
    
    printf("not const string:\n");
    for(int i=0; i<strlen(string_array);) {
        printf("%c", *(string_array + i++));
    }
    
    printf("const string:\n");
    for(int i=0; i<strlen(string_array1);) {
        printf("%c", *(string_array1 + i++));
    }
    
    
    printf("\nPrinting string char by char, using brackets syntax.\n");
    
    printf("not const string:\n");
    for(int i=0; i<strlen(string_array);) {
        printf("%c", string_array[i++]);
    }
    
    printf("const string:\n");
    for(int i=0; i<strlen(string_array1);) {
        printf("%c", string_array1[i++]);
    }
    
    printf("Printing sizeof results for the three vars.\n");
    printf("Sizeof(string_array1[]):%lu\n", sizeof(string_array1));
    printf("Sizeof(*string_array_pointer):%lu\n", sizeof(*string_array_pointer));
    printf("Sizeof(*string_array):%lu\n", sizeof(*string_array));
    
    
    printf("Giving strcpc commands...\n");
    char string_array2[] = "char_array";
    printf("copy a constant string into a char array\n");
    strcpy(string_array2,"hello");
    printf("Result:%s\n",string_array);
    
    printf("copy a char array into a constant string\n");
    char constant_string3[] = "I am the 2ns constant string";
    strcpy(constant_string3,string_array2);
    printf("Result:%s\n", constant_string3);
    
    /*
    printf("copy a char array into itself1\n");
    strcpy(string_array1,string_array1);
    printf("Result:%s",string_array1);
     error occurs : 2018-03-30 10:51:04.639949+0200 Exercise24[1281:44955] detected source and destination buffer overlap
    */
    
    char uni_string[] = "Université";
    printf("strlen(uni_string) && sizeof(uni_string)\n");
    printf("       %lu         &&   %lu\n", strlen(uni_string),sizeof(uni_string));
    
    
    //same exercise, using char array
    char *uni_string1 = "Université";
    printf("strlen(uni_string1) && sizeof(uni_string1)\n");
    printf("       %lu         &&   %lu\n", strlen(uni_string1),sizeof(uni_string1));
    
    
    
    
    /*
     Do you observe any difference?
     Yes the number of bytes is reduced to 8, but after checking on the web the total bytes of "Université" is indeed 13, and not 8.
     */
    
    /*
     sizeof() : size in bytes on Université
     strlen() : the CPU, checks every cell in memory that is allocated
     to the array, if it finds NULL, no char is counted, otherwise the current_value++
     and returns the total number of chars excluding the \0, which defines the end of the string.
     
     */
    
    
    /*
     1)No differences, in printing strings in various forms. Why ? A pointer to a char array is quite
     the same thing as a char array(which is also a pointer). We cannot change the "string_array1[]" var
     because of the way it was declared. At the end both arrays should print the same content, no matter
     the method used to print them.
     
     2)Modify the content of these variables. Which calls are valid?
     Not valid to chanage contents of "string_array1[]"
     
     3)What does the sizeof operator return on these 3 variables?
     Sizeof(string_array1[]):43
     Sizeof(*string_array_pointer):1
     Sizeof(*string_array):1
     */
    
    return 0;
}
