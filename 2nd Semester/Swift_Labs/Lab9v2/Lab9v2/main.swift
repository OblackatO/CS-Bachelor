//
//  main_file.swift
//  Lab9v2
//
//  Created by Pedro Gomes  on 26/04/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

import Foundation

let airport = AirPort("Luxairport")
let airline = Airline("Luxair")

let airport_manager = AirportManager(airport)

let airport1 = AirPort("Berlin")
let airline1 = Airline("Luxair")

let flight = Flight(123, (airport.name, airport1.name), (22,10), airline, 20, 4)
let flight1 = Flight(312, (airport1.name, airport.name), (19,10), airline, 14, 40)
flight.gate = "A06"
flight1.gate = "B03"

let passenger1 = Passenger(name: "pedro", "one1@gmail.com")
let passenger2 = Passenger(name: "Esteves", "two@gmail.com")

let checkin1 = flight.checkin(passenger: passenger1)
if checkin1 != nil {
    print("Passenger successfully seated on",checkin1!.0,  ":", checkin1!.1)
}

let checkin2 = flight1.checkin(passenger: passenger2)
if checkin2 != nil {
    print("Passenger successfully seated on",checkin2!.0,  ":", checkin2!.1)
}

airport_manager.add_flight(flight)
airport_manager.add_flight(flight1)

print("\n")
flight.print_seatmap()

print("\n")
flight1.print_seatmap()


airport_manager.printSchedule()
print("\n")
flight1.print_passengerslist()





