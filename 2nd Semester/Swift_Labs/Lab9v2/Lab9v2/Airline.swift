//
//  Airline.swift
//  Lab9
//
//  Created by Pedro Gomes  on 26/04/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

import Foundation

class Airline {
    
    let name : String
    
    init(_ name: String) {
        self.name = String(name.prefix(2))
    }
}
