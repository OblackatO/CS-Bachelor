//
//  main.swift
//  Exercise32
//
//  Created by Pedro Gomes  on 05/05/2018.
//  Copyright © 2018 Pedro Gomes . All rights reserved.
//

import Foundation

let email1 = Email("Programming", "Do not forget to send me the script")
let email2 = Email("Meeting", "We have a meeting ext friday at 16:00 do not forget to come.")
let email3 = Email("Culture Flash", "Do not forget to send me the script")

let mail_server = MailServer()
let email_client = MailClient(mail_server)

mail_server.add_email(email1)
mail_server.add_email(email2)
mail_server.add_email(email3)

//user opens email client, email client retrieves emails.
email_client.all_emails = mail_server.retrieve_emails()

//user reads all email, there are set to read, but the thrid email is set to spam
//because it comes from culture flash.
email_client.read_all_emails()

//User rereads all email
email_client.read_all_emails()

//Delete any email by ID
print("ID of email to delete:")
if let id = readLine() {
    let idint = Int(id)
    email_client.delete_email(idint!)
}

//User reads emails after deletion of an email X
email_client.read_all_emails()


