/*
 * swap_values.c
 *
 *  Created on: Mar 1, 2018
 *      Author: pedrogomes
 */

int swap_values(int n, int n1) {

	int temp_var = n;
	n = n1;
	n1 = temp_var;
	printf("\nValues after swap in_function: \n n:%d \n n1:%d",n,n1);

	return 0;
}
