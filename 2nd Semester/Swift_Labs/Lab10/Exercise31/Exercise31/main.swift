//
//  main.swift
//  Exercise31
//
//  Created by Pedro Gomes  on 05/05/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

import Foundation

print("Hello, World!")

let list1 = List_TODO("TODO homeword")
let list2 = List_TODO("TODO playground")

var task1 = Item("Programming", "Finish wheel of fortune programming project")
var task2 = Item("Maths", "See online ressources to better understand")

var task3 = Item("Exercise", "Run 3 km")
var task4 = Item("Tv Show", "Continue to watch 7 deadly sins")

//adds tasks to list1
list1.add_item(task1); list1.add_item(task2)
list2.add_item(task3); list2.add_item(task4)

print("\nAll tasks on \(list1.name)")
list1.PrintAll_Taks()

print("\nAll tasks on \(list2.name)")
list2.PrintAll_Taks()


//merges tasks
list1.AddTasks_FromList(list2)

//sets programming task ON list1 to done
if list1.set_task_done("Programming") {
    print("\nTask marked as done successfully.")
}else {
    print("\nTask does not exist.")
}

//Prints all tasks again NOTE the difference between Programming in list1 && list2
print("\nAll tasks on \(list1.name)")
list1.PrintAll_Taks()

print("\nAll tasks on \(list2.name)")
list2.PrintAll_Taks()

//var choice: String = ""
/*
 while(choice != "0"){
 print("[1]Create TODO list\n")
 print("[2]Add Task to existing TODO list\n")
 print("[3]Share tasks between lists\n")
 print("[4]Delete task of a list\n")
 print("[5]Print all tasks of a lists\n")
 print("[0]Exit")
 
 if let response = readLine(){
 choice = response
 }
 
 if(choice == "1"){
 print("TODO list name:")
 if let name = readLine(){
 List_TODO(name)
 
 }
 
 }else if(choice == "2"){
 var task_name: String
 var task_description: String
 var list_name: String
 
 print("Task name:")
 if let tn = readLine(){
 task_name = tn
 }
 
 print("Description:")
 if let td = readLine(){
 task_description = td
 }
 
 print("List name:")
 if let ln = list_name{
 list_name = ln
 }
 
 Item(task_name, task_description)
 
 
 }
 
 }
 */
