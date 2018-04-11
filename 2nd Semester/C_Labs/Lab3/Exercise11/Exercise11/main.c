//
//  main.c
//  Exercise11
//
//  Created by Pedro Gomes  on 10/03/2018.
//

#include <stdio.h>
#include <time.h>
#include <stdlib.h>

#define BOMB -1
#define CLEAR 1
int const X_LENGTH = 15;
int const Y_LENGTH = 10;
int const PROBABI = 50;

int main(int argc, const char * argv[]) {
    
    int minesweeper_array[X_LENGTH][Y_LENGTH];// =  {CLEAR};
    
    for(int i=0; i<X_LENGTH; i++) {
        for(int i2=0; i2<Y_LENGTH; i2++) {
            minesweeper_array[i][i2] = CLEAR;
        }
    }
     
    int total_bombs = (int) ((X_LENGTH*Y_LENGTH)*PROBABI)/100;
    
    for(int i=0; i<total_bombs; i++) {
        
        int x = rand() % X_LENGTH;
        int y = rand() % Y_LENGTH;
        if (minesweeper_array[x][y] == CLEAR) {
            minesweeper_array[x][y] = BOMB;
        }else {
            i--;
        }
    }
    
    printf("Write 2 values separated by a space, 1st value for X 2nd value for Y.\n");
    printf("X max : %d (included)\n", X_LENGTH-1);
    printf("Y max : %d (included)\n", Y_LENGTH-1);
    
    int x,y;
    int safe_fields_count = (X_LENGTH*Y_LENGTH) - total_bombs;
    
    int selected_points[X_LENGTH][Y_LENGTH]; //=  {0};
    
    for(int i=0; i<X_LENGTH; i++) {
        for(int i2=0; i2<Y_LENGTH; i2++) {
            selected_points[i][i2] = 0;
        }
    }
    
    
    //int buffer;
    while(1) {
        
        printf("\nValues:");
        scanf("%d",&x);
        scanf("%d",&y);
        //printf("\nthis is the value for the coordinates on the array: %d\n", minesweeper_array[x][y]);
        if (selected_points[x][y] == 1) {
            printf("You have already chose that point, try another one.\n");
        
        }else if (minesweeper_array[x][y] == BOMB) {
            printf("Sorry pal, you\'ve just lost :(\n");
            break;
        
        }else if (minesweeper_array[x][y] == CLEAR) {
            safe_fields_count--;
            selected_points[x][y] = 1;
            printf("Wayyy to go ! Remaining safe fields: %d\n",safe_fields_count);
        }
        
        //while((buffer = getchar()) != EOF && buffer != '\n');
    }
    
    if (safe_fields_count == 0) {
        printf("You god damn won pal !");
    }
    return 0;
}
 