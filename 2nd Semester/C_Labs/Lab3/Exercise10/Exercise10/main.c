//
//  main.c
//  Exercise10
//
//  Created by Pedro Gomes  on 08/03/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <stdio.h>

#define l1 30
#define l2 35

int t1[l1];
int t2[l2];
int t3[l1+l2];

void fill_array(int array[], int size);
void sort_array(int array[], int size);
void quicksort(int list[],int m,int n);
void swap(int *x,int *y);
void print_array(int array[], int size);

void fill_array(int array[], int size) {
    for(int i=0; i<size; i++) {
        array[i] = rand() % 100;
    }
}

void sort_array(int array[], int size) {
    quicksort(array, 0, size);
}

void quicksort(int list[],int m,int n)
{
    int key,i,j,k;
    if( m < n)
    {
        k = (m+n)/2;
        swap(&list[m],&list[k]);
        key = list[m];
        i = m+1;
        j = n;
        while(i <= j)
        {
            while((i <= n) && (list[i] <= key))
                i++;
            while((j >= m) && (list[j] > key))
                j--;
            if( i < j)
                swap(&list[i],&list[j]);
        }
        
        swap(&list[m],&list[j]);
        
        quicksort(list,m,j-1);
        quicksort(list,j+1,n);
    }
}

void swap(int *x,int *y){
    
    int temp;
    temp = *x;
    *x = *y;
    *y = temp;
}

void print_array(int array[], int size) {
    printf("[");
    for(int i=0; i<size; i++) {
        printf("%d", array[i]);
        printf("    ");
    }
    printf("]");
}

int main(int argc, const char * argv[]) {
    
    srand(time(NULL));
    fill_array(t1, sizeof(t1)/sizeof(t1[0]));
    fill_array(t2, sizeof(t2)/sizeof(t2[0]));
    
    printf("t1 array: ");
    print_array(t1, sizeof(t1)/sizeof(t1[0]));
    printf("\n");
    printf("t2 array: ");
    print_array(t2, sizeof(t2)/sizeof(t2[0]));
    printf("\n");
    
    sort_array(t1, sizeof(t1)/sizeof(t1[0]));
    sort_array(t2, sizeof(t2)/sizeof(t2[0]));
    printf("\n");
    printf("t1 array sorted: ");
    print_array(t1, sizeof(t1)/sizeof(t1[0]));
    printf("\n");
    printf("t2 array sorted: ");
    print_array(t2, sizeof(t2)/sizeof(t2[0]));
    printf("\n");
    
    //int max_index = sizeof(t3)/sizeof(t3[0]);
    int i1 = 0;
    int i2 = 0;
    
    for(int i=0; i<l1+l2; i++) {
        
        if (i1 >= l1) {
            t3[i] = t2[i2++];
        }else if (i2 >= l2) {
            t3[i] = t1[i1++];
        }else if(t1[i1] <= t2[i2]) {
            t3[i] = t1[i1++];
        }else {
            t3[i] = t2[i2++];
        }
    }
    
    printf("t3 array sorted: ");
    print_array(t3, sizeof(t3)/sizeof(t3[0]));
    printf("\n");
    return 0;
}

