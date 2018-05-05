//
//  List.swift
//  Exercise31
//
//  Created by Pedro Gomes  on 05/05/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

import Foundation

struct Item {
    
    let title: String
    let description: String
    private(set) var done: Bool = false
    
    init(_ title: String, _ description: String){
        self.title = title
        self.description = description
    }
    
    mutating func Set_Done(){
        
        self.done = true
    }
    
}

class List_TODO {
    
    let name: String
    private(set) var items = [Item]() //private(set)
    
    init(_ name: String){
        
        self.name = name
    }
    
    
    func add_item(_ item: Item){
        self.items.append(item)
    }
    
    func set_task_done(_ name: String) -> Bool{
        var index = -1
        
        for x in 0...self.items.count-1{
            if self.items[x].title == name{
                index = x
            }
        }
        
        if index == -1{
            return false
        }
        
        self.items[index].Set_Done()
        return true
    }
    
    func AddTasks_FromList(_ list: List_TODO){
        
        for task in list.items{
            add_item(task)
        }
    }
    
    func PrintAll_Taks(){
        
        for task in self.items{
            print("Name: \(task.title)")
            print("Description: \(task.description)")
            if task.done{
                print("Task is done")
            }else{
                print("Task is not done")
            }
            
        }
        
    }
}
