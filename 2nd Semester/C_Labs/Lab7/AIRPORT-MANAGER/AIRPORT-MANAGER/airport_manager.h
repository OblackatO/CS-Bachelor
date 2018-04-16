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
    char *seats_map;
    
    
}flight;


typedef struct airport {
    
    char *name;
    char *code;
    int total_flights;
    /*flights : Tried to use **flight to dynamically allocate memory, but after several hours of trying, and bothering my professor it still did not work, so fuck it.
     */
    flight **flights;
    
    
}airport;

airport *new_airport(char *name, char *code);
flight *new_flight(char *al, int fn, char *or, char *des, int hour, int min, int gt, int sm_size);


int add_flight(airport *airport, flight *flight);
int check_in(char *passenger_name, int flight_number, airport *airport);
int remove_flight(airport *airport, int flight_number);
void print_schedule(airport *airport);




#endif /* AIRPORT_MANAGER_H_ */
