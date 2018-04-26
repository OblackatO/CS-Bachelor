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
    
    
    func add_flight(_ flight: Flight) {
        self.schedule.append(flight)
    }
    
    var departures = [Flight]()
    var arrivals = [Flight]()
    
    //I am not using closures unless someone puts a gun in my head and says to do so.
    //I will gladly lose marks in the exam if needed, just not to use them.
    func printSchedule() {
        
        for flight in self.schedule {
            if flight.origin_destination.0 == "Lu" {
                departures.append(flight)
            }else {
                arrivals.append(flight)
            }
        }
        
        print("Departures:")
        for flight in self.departures {
            print("\n")
            print(flight.print_flight_info())
        }
        
        print("Arrivals:")
        for flight in self.arrivals {
            print("\n")
            print(flight.print_flight_info())
        }
        
    }
}


