//
//  Airport_Manager.swift
//  Lab9
//
//  Created by Pedro Gomes  on 26/04/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

import Foundation

class AirportManager {
    
    var schedule = [Flight]()
    let airport : AirPort
    
    init(_ airport: AirPort) {
        self.airport = airport
    }
    
    func add_flight(_ flight: Flight) {
        self.schedule.append(flight)
    }
    
    var departures = [Flight]()
    var arrivals = [Flight]()
    
    //closures suck, even more than java itself.
    func FlightsFilter(filter: (Flight) -> Bool) {
        for flight in self.schedule.filter(filter) {
            flight.print_flight_info()
        }
    }
        
    func printSchedule() {
        print("*****Flights Schedule*****")
        
        print("     Departures:          ")
        FlightsFilter() {flight in return
            flight.origin_destination.0 == airport.name
        }
        
        print("     Arrivals:          ")
        FlightsFilter() {flight in return
            flight.origin_destination.1 == airport.name
        }
    }
}


