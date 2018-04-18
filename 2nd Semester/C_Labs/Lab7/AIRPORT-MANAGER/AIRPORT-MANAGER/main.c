/*
 * main.c
 *
 *  Created on: Apr 15, 2018
 *      Author: pedrogomes
 */


#include <stdio.h>
#include <stdlib.h>
#include "airport_manager.h"
#define TRUE 1
#define FALSE 0

int main() {
    
    int buffer;
    int choice = -1;
    airport *current_airport;
    if((current_airport = malloc(sizeof(airport)*1)) == NULL) {
        perror("no mem to allocate a new aiport");
        exit(1);
    }
    
    while(choice != 0) {
        printf("\n\t\tAIRPORT MANAGER\t\t\n");
        printf("1. SET CURRENT AIRPORT\n");
        printf("2. CREATE && ADD FLIGHT TO AIRPORT.\n");
        printf("3. CHECK IN PASSENGER.\n");
        printf("4. REMOVE FLIGHT.\n");
        printf("5. SHOW SCHEDULE.\n");
        printf("6. SHOW PASSENGERS.\n");
        printf("0. EXIT.\n");
        printf("Your choice:");
        if(scanf("%d", &choice) <= 0) {
            perror("An error occurred while scanning choice.");
            exit(0);
        }
        while((buffer = getchar()) != EOF && buffer != '\n');
    
        if(choice == 1) {
            char *name;
            if((name = malloc(25*sizeof(char))) == NULL) {
                perror("no more memory available.");
                exit(1);
            }
            char *code;
            if((code = malloc(4*sizeof(char))) == NULL) {
                perror("no more memory available.");
                exit(1);
            }
        
            printf("Name(max 24 chars):\n");
            fgets(name, 25, stdin);
            printf("Code(max 3 chars):\n");
            fgets(code, 4, stdin);
        
            current_airport = new_airport(name, code);
            printf("Current airport info:\n");
            printf("name:%s\n", current_airport->name);
            printf("code:%s\n", current_airport->code);
            free(name); name = NULL;
            free(code); code = NULL;
    
        }else if(choice == 2) {
    
            char *airline;
            if((airline = malloc(25*sizeof(char))) == NULL) {
                perror("no more memory available.");
                exit(1);
            }
        
            char *origin;
            if((origin = malloc(15*sizeof(char))) == NULL) {
                perror("no more memory available.");
                exit(1);
            }
        
            char *destination;
            if((destination = malloc(15*sizeof(char))) == NULL) {
                perror("no more memory available.");
                exit(1);
            }
        
            int flightn, hour, minute, gate, smsz;
        
            printf("airline(max 24 chars):\n");
            fgets(airline, 25, stdin);
            printf("Origin(max 14 chars):\n");
            fgets(origin, 14, stdin);
            printf("Destination(max 14 chars):\n");
            fgets(destination, 14, stdin);
            printf("Flight Number:\n");
            if((scanf("%d", &flightn) <=0)) {
                perror("an error occurred.");
                exit(1);
            }
            printf("Hour Minutes(e.g. 20 30) :\n");
            if (scanf("%d %d", &hour,&minute) != 2) {
                perror("an error occurred while scanning time");
                exit(1);
            }
            //printf("hours:%d", hour);
            //printf("minutes:%d", minute);
        
            printf("Gate:\n");
            if((scanf("%d", &gate) <=0)) {
                perror("an error occurred.");
                exit(1);
            }
        
            printf("Total Seats:\n");
            if((scanf("%d", &smsz) <=0)) {
                perror("an error occurred.");
                exit(1);
            }
        
            flight *flight_to_add = new_flight(airline, flightn, origin, destination, hour, minute, gate, smsz);
        
            printf("Info about added flight:\n");
            printf("Airline:%s\n", flight_to_add->airline);
            printf("Flight number:%d\n", flight_to_add->flight_number);
            printf("Origin:%s\n", flight_to_add->origin);
            printf("Destination:%s\n", flight_to_add->destination);
            printf("Time %d:%d\n", flight_to_add->hour, flight_to_add->minutes);
            printf("Gate :%d\n", flight_to_add->gate);
            printf("Total seats:%lu\n", sizeof(flight_to_add->seats_map)/sizeof(flight_to_add->seats_map[0]));
            
            if(add_flight(current_airport, flight_to_add) == TRUE) {
                printf("Flight successfully added.");
                free(airline); airline = NULL;
                free(origin); origin = NULL;
                free(destination); destination = NULL;
            
            }else {
                printf("Flight not added.");
            }
        }else if(choice == 3) {
            
            char *name;
            if((name = malloc(21*sizeof(char))) == NULL) {
                perror("no more memory available.");
                exit(1);
            }
            
            printf("Name(max 20 chars):\n");
            fgets(name, 21, stdin);
            
            int flight_number = 0;
            
            printf("Flight Number(max 5 chars):\n");
            scanf("%d", &flight_number);
            
            if (check_in(name, search_flight(current_airport, flight_number)) == TRUE) {
                printf("Check-In made.");
                free(name); name = NULL;
            }
        }else if(choice == 4) {
            
            int flight_number = 0;
            
            printf("Flight Number(max 20 chars):\n");
            scanf("%d", &flight_number);
            
            if(remove_flight(current_airport, search_flight(current_airport, flight_number)) == TRUE) {
                printf("Flight was successfully removed");
            }else {
                printf("Flight was not removed");
            }
        }else if(choice == 5) {
            
            print_schedule(current_airport);
            
        }else if(choice == 6) {
            
            int flight_number = 0;
            
            printf("Flight Number(max 20 chars):\n");
            scanf("%d", &flight_number);
            
            show_passengers(search_flight(current_airport, flight_number));
            
        }else {
            break;
        }
    }
    
    return 0;
}
