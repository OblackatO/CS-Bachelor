//
//  Passenger.swift
//  Lab9
//
//  Created by Pedro Gomes  on 26/04/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

import Foundation

class Passenger {
    
    let name: String
    let email_address: String
    
    init(name: String, _ email_address: String) {
        self.name = String(name.prefix(25))
        self.email_address = email_address
    }
    
    func notifyFlightUpdate(flight:Flight, message:String) {
        print("Sending message to:\(email_address)")
        print("Message:", message)
    }
}
