//
//  Email_classes.swift
//  Exercise32
//
//  Created by Pedro Gomes  on 05/05/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

import Foundation

enum EmailFlag {
    case
        Unread,
        Important,
        Spam,
        Read
}

class Email {
    
    let subject: String
    let message: String
    let date: String
    var flag: EmailFlag? = EmailFlag.Unread
    var email_code: Int
    
    init(_ subject: String, _ message: String) {
        
        self.subject = subject
        self.message = message
        let date = Date()
        let formatter = DateFormatter()
        formatter.dateFormat = "dd.MM.yyyy"
        self.date = formatter.string(from: date)
        
        self.email_code = (self.subject.hashValue & self.date.hashValue)*2%10000
    }
}

class MailServer {
    
    var all_emails = [Email]()
    
    init() {print("Mail server created.")}
    
    func add_email(_ email: Email) {
        all_emails.append(email)
    }
    
    func retrieve_emails() -> [Email] {
        return self.all_emails
    }
}

class MailClient {
    
    let mail_server: MailServer
    var all_emails = [Email]()
    
    init(_ mail_server: MailServer) {
        self.mail_server = mail_server
    }
    
    func read_email(_ email_number:Int) {
        print("\nSubject:",self.all_emails[email_number].subject)
        print("Date:",self.all_emails[email_number].date)
        print("Message:",self.all_emails[email_number].message)
        print("ID:", self.all_emails[email_number].flag!)
    }
    
    func delete_email(_ email_code:Int) {
        for x in 0...self.all_emails.count-1 {
            if self.all_emails[x].email_code == email_code {
                self.all_emails.remove(at: x)
            }
        }
        
        //do not need  make another for loop for the email in the
        //server, because objects are called by reference.
    }
    
    func read_all_emails() {
        for email in self.all_emails {
            
            print("\nSubject:",email.subject)
            print("Date:",email.date)
            print("Message:",email.message)
            print("Email ID:",email.email_code)
            
            if(email.subject != "Culture Flash") {
                email.flag = EmailFlag.Read
            }else {
                email.flag = EmailFlag.Spam
            }
            print("ID:", email.flag!)
        }
    }
}

//For the exercise 32, I would have used structures intead of classes, because that way
//copies of emails would be created, instead of having a referance, like in a class.

