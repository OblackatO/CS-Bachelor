//
//  main.c
//  Exercise7
//
//  Created by Pedro Gomes  on 01/03/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

#include <stdio.h>
#include "Calculations_Functions.h"

int main() {
    
    int result;
    float n, n1;
    char choice = 'n';
    char buffer;
    
    while(choice != 'e') {
        
        printf("\n\nChoose one of the following operations and press enter:");
        printf("\n+");
        printf("\n-");
        printf("\n/");
        printf("\n*");
        printf("\n\"f\" for factorial.");
        printf("\n\"e\" for exit.");
        printf("\n\nChoice:");
        result = scanf("%c", &choice);
        
        /*
        if (result != 0) {
            printf("Shit happened. Please try again.");
            continue;
        }
        */
        
        switch(choice) {
                
            case '/' :
                printf("Input 2 numbers separated by spaces:");
                //char buffer;
                //while((buffer = getchar()) != EOF && buffer != '\n');
                scanf("%f", &n);
                scanf("%f", &n1);
                
                if (n1 == 0) {
                    printf("Division by 0 not possible.");
                    continue;
                }else {
                    printf("Result:%.2f", division(n,n1));
                }
                break;
                
            case 'f' :
                printf("Input 2 numbers separated by spaces:");
                scanf("%f", &n);
                
                if (n < 0) {
                    printf("Factorial of negative numbers not possible.");
                    continue;
                }else {
                    printf("Result: %lu", iterative_factorial(n));
                }
                break;
                
            case '+':
                printf("Input 2 numbers separated by spaces:");
                scanf("%f", &n);
                scanf("%f", &n1);
                
                printf("Result: %.2f", sum(n, n1));
                break;
                
            case '-':
                printf("Input 2 numbers separated by spaces:");
                scanf("%f", &n);
                scanf("%f", &n1);
                
                printf("Result: %.2f", sub(n, n1));
                break;
            default:
                printf("Operation not recognized.");
                break;
        }
        while((buffer = getchar()) != EOF && buffer != '\n');
    }
    
    return 0;
}

