//
//  Flight.swift
//  Lab9
//
//  Created by Pedro Gomes  on 26/04/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

import Foundation

class Flight {
    
    let flight_number: Int
    let origin_destination: (String, String)
    var time: (Int, Int) {
        didSet(previousvalue) {
            for row in self.seat_map {
                for seat in row {
                    if seat != nil {
                        let message = "Old Time: \(previousvalue.0):\(previousvalue.1)\n, Updated Time: \(time.0):\(time.1)"
                        seat?.notifyFlightUpdate(flight: self, message: message )
                    }
                }
            }
        }
    }
    
    let airline: Airline
    var gate: String? {
        didSet(previousvalue) {
            var message : String
            
            if previousvalue == nil {
                message = "New gate set:\(String(describing: gate))"
            }else {
                message = "Old gate:\(String(describing: previousvalue)), Updated Gate:\(self.gate!)"
            }
            
            for row in self.seat_map {
                for seat in row {
                    if seat != nil {
                        seat?.notifyFlightUpdate(flight: self, message: message )
                    }
                }
            }
        }
    }
    
    var flightDesignator: String? {
        
        get {return airline.name+String(flight_number)}
    }
    
    static let rows_number = 30; static let seats_per_row = 10
    var seat_map : [[Passenger?]]
    
    init(_ flight_number: Int, _ origin_destination: (String, String), _ time: (Int, Int), _ airline: Airline, _ rows: Int, _ seats: Int) {
        
        self.flight_number = flight_number
        self.origin_destination = origin_destination
        self.time = time
        self.airline = airline
        self.gate = nil
        
        self.seat_map = Array(repeating: Array(repeating: nil, count: seats), count: rows)
        
    }
    
    convenience init(_ flight_number: Int, _ origin_destination: (String, String), _ time: (Int, Int), _ airline: Airline) {
    
        self.init(flight_number, origin_destination, time, airline, Flight.rows_number, Flight.seats_per_row)
    }
    
    func checkin(passenger p: Passenger) -> (Int, Int)? {
        
        for row in 0...self.seat_map.count-1 {
            for seat in 0...self.seat_map[row].count-1 {
                if self.seat_map[row][seat] == nil {
                    self.seat_map[row][seat] = p
                    return(row, seat)
                }
            }
        }
        
        return nil
    }
    
    func print_seatmap() {
        
        for row in 0..<self.seat_map.count {
            for seat in 0..<self.seat_map[row].count {
                if self.seat_map[row][seat] != nil {
                    print(terminator:"*")
                }else {
                    print(terminator:"_")
                }
            }
            print()
        }
        //print()
    }
    
    func print_passengerslist() {
        for x in 0..<self.seat_map.count {
            for y in 0..<self.seat_map[x].count {
                if let p = self.seat_map[x][y] {
                    print("Seat:\(x+1)--\(y+1):\(p.name)")
                }
            }
        }
    }
    
    func print_flight_info() {
        
        if self.gate != nil {
            print("Gate:\(self.gate!)")
        }else {
            print("Gate: None)")
        }
        
        print("\(self.origin_destination.0)  --> \t\(self.origin_destination.1)")
        print("Time:\(self.time.0):\(self.time.1)")
    }
}



