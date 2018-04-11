/*
 * main.c
 *
 *  Created on: Mar 15, 2018
 *      Author: student
 */

//correction of exercise 13 (bug detection.)

#include <stdio.h>

int main(){


double*ptr , i;

printf("i = ");
scanf("%lf", &i);
ptr = &i;


printf("i = %p", ptr);
return 0;

}
