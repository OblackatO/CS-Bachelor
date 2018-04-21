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
        
        flight_to_return->total_passengers = 0;
        flight_to_return->max_passengers = sm_size;
        if((flight_to_return->seats_map = malloc(sm_size*(sizeof(char*)))) == NULL) {
            perror("no more memory available to allocate flight seats.");
            exit(0);
        }
        
        return flight_to_return;
    
    }
}

int add_flight(airport *airport, flight *flight) {
    
    /*
     if size of array of pointers to flight is 0, use malloc, otherwise
     use realloc, because there are already some pointers to flight.
     Please note a very important fact that I'm allocating sizeof(*flight)
     and not sizeof(flight), as it is an array of pointers. If sizeof(flight)
     is used, the program will act in a stranger way.
     */
    
    if(airport->total_flights == 0) {
        if((airport->flights = malloc(sizeof(*flight)*1)) == NULL) {
            perror("no more memory to add flight");
            exit(0);
         }
        
        airport->flights[airport->total_flights++] = flight;
        return TRUE;
            
    }else {
        int total_flights = airport->total_flights;
        airport->flights = realloc(airport->flights, ++total_flights*sizeof(*flight));
        if(airport->flights == NULL) {
            perror("no more memory to add flight");
            exit(0);
        }
        
        airport->flights[airport->total_flights++] = flight;
        return TRUE;
    }
}
    
int check_in(char *passenger_name, flight *flight) {
    
    if(flight == NULL) {
        printf("Flight does not exit.\n");
        return FALSE;
    }
    
    if(flight->total_passengers == flight->max_passengers) {
        printf("No more places available.\n");
        return FALSE;
    }
    
    flight->seats_map[flight->total_passengers++] = passenger_name;
    return TRUE;
}

void show_passengers(flight *flight) {
    
    if(flight->total_passengers == 0) {
        printf("No passengers were added.\n");
        return;
    }
    
    if(flight == NULL) {
        printf("Flight does not exist.");
        return;
    }
    
    //Let's use a while loop, no for loop this time.
    int start_index = 0;
    while(!(start_index == flight->total_passengers)) {
        printf("Seat:%d Passenger:%s", start_index+1, flight->seats_map[start_index]);
        start_index++;
    }
}


/* flight *search_flight(airport *airport, int flight_number)
 *----------------------
 * searches a flight by its number in the array of pointers to flight
 * in a given airport.
 *
 * *airport : pointer to the airport where we want to look for the flight
 * flight_number : Flight number of the flight we want to get
 *
 * returns : *flight if match found for the given flight_number
 *           NULL if match not found for the given flight_number
 */
flight *search_flight(airport *airport, int flight_number) {
    for(int i=0; i<airport->total_flights; i++) {
        if(airport->flights[i]->flight_number == flight_number) {
            return airport->flights[i];
        }
    }
    return NULL;
}

int free_flight(airport *current_airport, flight *flight_to_free) {
    
    //Frees arrays of chars
    free(flight_to_free->airline);
    free(flight_to_free->destination); free(flight_to_free->origin);
    
    /*Frees array of strings, do not need to free each place
     as in the creation of the flight I allocate the maximum numbers of places
     input by the user. It would be a wiser implementation to allocate/reallocate the
     array when a check in is made, and in that case I would need to free() every
     place in the sets_map using a for loop for instance.
     */
    free(flight_to_free->seats_map);
    free(flight_to_free); flight_to_free = NULL; //=NULL avoid dangling pointer
    
    
    
    return TRUE;
}

int remove_flight(airport *airport, flight *flight_to_remove) {
    
    if(airport->total_flights == 0  || flight_to_remove == NULL) {
        printf("Flight is not in airport:%s\n", airport->name);
        return FALSE;
    }
    
    int index_OfFound_Flight = 0;
    for(int i=0; i<airport->total_flights; i++) {
        if(airport->flights[i]->flight_number == flight_to_remove->flight_number) {
            
            index_OfFound_Flight = i;
            if(free_flight(airport, airport->flights[i]) == TRUE) {
                    
            }else {
                printf("An error occurred while removing flight:%s", airport->code);
                exit(1);
            }
        }
    }
    
    airport->total_flights--;
    for(int i = index_OfFound_Flight; i<airport->total_flights; i++) {
        airport->flights[i] = airport->flights[i+1];
    }
    
    if((airport->flights = realloc(airport->flights, airport->total_flights*sizeof(flight *))) == NULL) {
        perror("An error occurred while reallocate flight array ");
        exit(1);
    }
    
    return TRUE;
}

void print_schedule(airport *airport) {
    if(airport->total_flights == 0) {
        printf("no flights were added.");
    }
    
    printf("Total flights scheduled:%d\n", airport->total_flights);
    for(int i=0; i<airport->total_flights; i++) {
        printf("\nAirline: %s", airport->flights[i]
               ->airline);
        printf("Origin:%s", airport->flights[i]->origin);
        printf("Destination:%s", airport->flights[i]->destination);
        printf("Time %d:%d", airport->flights[i]->hour, airport->flights[i]->minutes);
    }
}


