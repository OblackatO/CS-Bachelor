/*
 * airport_manager.h
 *
 *  Created on: Apr 15, 2018
 *      Author: pedrogomes
 */

#ifndef AIRPORT_MANAGER_H_
#define AIRPORT_MANAGER_H_

typedef struct flight {
    
    char *airline;
    int flight_number;
    char *origin, *destination;
    int hour, minutes;
    int gate;
    int total_passengers, max_passengers;
    char **seats_map;
    
    
}flight;


typedef struct airport {
    
    char *name;
    char *code;
    int total_flights;
    flight **flights;
    
    
}airport;

airport *new_airport(char *name, char *code);
flight *new_flight(char *al, int fn, char *or, char *des, int hour, int min, int gt, int sm_size);


int add_flight(airport *airport, flight *flight);
int check_in(char *passenger_name, flight *flight);
flight *search_flight(airport *airport, int flight_number);
int remove_flight(airport *airport, flight *flight_to_remove);
void print_schedule(airport *airport);
void show_passengers(flight *flight);




#endif /* AIRPORT_MANAGER_H_ */
