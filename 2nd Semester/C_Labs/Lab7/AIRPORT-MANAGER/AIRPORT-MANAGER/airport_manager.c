/*
 * airport_manager.c
 *
 *  Created on: Apr 15, 2018
 *      Author: pedrogomes
 */


#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "airport_manager.h"
#define TRUE 1
#define FALSE 0

airport *new_airport(char *name, char *code) {
    
    airport *airport_to_return;
    if((airport_to_return = malloc(1*sizeof(airport))) == NULL) {
        perror("no more memory available.");
        exit(0);
    }else {
        
        if((airport_to_return->name = strdup(name)) == NULL) {
            perror("no more memory available to add airport name.");
            exit(0);
        }
        
        if((airport_to_return->code = strdup(code)) == NULL) {
            perror("no more memory available to add airport code.");
            exit(0);
        }
        
        airport_to_return->total_flights = 0;
        return airport_to_return;
    }
}

flight *new_flight(char *al, int fn, char *or, char *des, int hour, int min, int gt, int sm_size) {
    
    flight *flight_to_return;
    if((flight_to_return = malloc(1*sizeof(flight))) == NULL) {
        perror("no more memory available to create flight.");
        exit(0);
    }else {
        
        if((flight_to_return->airline = strdup(al)) == NULL) {
            perror("no more memory available to add flight airline.");
            exit(0);
        }
        
        if((flight_to_return->origin = strdup(or)) == NULL) {
            perror("no more memory available to add flight origin.");
            exit(0);
        }
        
        if((flight_to_return->destination = strdup(des)) == NULL) {
            perror("no more memory available to add flight destination.");
            exit(0);
        }
        
        flight_to_return->flight_number = fn;
        flight_to_return->hour = hour; flight_to_return->minutes = min;
        flight_to_return->gate = gt;
        
        if((flight_to_return->seats_map = malloc(sm_size*(sizeof(char)))) == NULL) {
            perror("no more memory available to allocate flight seats.");
            exit(0);
        }
        
        for(int i=0; i<sm_size; i++) {
            flight_to_return->seats_map[i] = 1;
        }
        
        return flight_to_return;
    
    }
}


int add_flight(airport *airport, flight *flight) {
    
    if(airport->total_flights == 0) {
        if((airport->flights = malloc(sizeof(*flight)*1)) == NULL) {
            perror("no more memory to add flight");
            exit(0);
         }
        airport->total_flights = 0;
        airport->total_flights += 1;
        if((airport->flights[0] = malloc(sizeof(flight))) == NULL) {
            perror("no more memory to create flight");
            exit(0);
        }
        airport->flights[0] = flight;
        return TRUE;
            
    }else {
        airport->total_flights += 1;
        airport->flights = realloc(airport->flights, airport->total_flights*sizeof(*flight));
        if(airport->flights == NULL) {
            perror("no more memory to add flight");
            exit(0);
        }
        
        if((airport->flights[airport->total_flights] = malloc(sizeof(flight))) == NULL) {
            perror("no more memory to create flight");
            exit(0);
        }
        
        airport->flights[airport->total_flights] = flight;
        return TRUE;
    }
    //printf("size after the flight:%lu",sizeof(airport->flights));
    //return FALSE;
}
    


//does not work.
int check_in(char *passenger_name, int flight_number, airport *airport) {
    
    int total_flights = sizeof(airport->flights)/sizeof(airport->flights[0]);
    
    if(total_flights == 0) {
        if((airport->flights[0]->seats_map = strdup(passenger_name)) == NULL) {
            perror("No more places available || no more memory avaible.");
            exit(0);
         }
    }
    
    for(int i=0; i<total_flights; i++) {
        printf("current flight%d:", airport->flights[i]->flight_number);
        if(airport->flights[i]->flight_number == flight_number) {
            if((airport->flights[i]->seats_map = strdup(passenger_name)) == NULL) {
                perror("No more places available || no more memory avaible.");
                exit(0);
            }else {
                return TRUE;
            }
        }
    }
    return FALSE;
}

int remove_flight(airport *airport, int flight_number) {
    int total_flights = sizeof(airport->flights)/sizeof(airport->flights[0]);
    if(total_flights == 0) {
        perror("No flights were added");
        return FALSE;
    }else {
        for(int i=0; i<total_flights; i++) {
            if(airport->flights[i]->flight_number == flight_number) {
                airport->flights = realloc(airport->flights, --total_flights*sizeof(flight));
                return TRUE;
            }
        }
    }
    return FALSE;
}

void print_schedule(airport *airport) {
    if(airport->total_flights == 0) {
        printf("no flights were added.");
    }
    
    for(int i=0; i<airport->total_flights; i++) {
        printf("\nAirline: %s\n", airport->flights[i]
               ->airline);
        printf("%s ----> %s\n", airport->flights[i]->origin, airport->flights[i]->destination);
        printf("Time %d:%d", airport->flights[i]->hour, airport->flights[i]->minutes);
    }
}


